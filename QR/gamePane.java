package gameElements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class gamePanel extends JComponent {

	private Graphics2D g2;
	private BufferedImage image;
	private int width;
	private int height;
	private Thread thread;
	private boolean start = true;
	private int shotTime;
	// Game FPS
	private final int FPS = 60;
	private final int TARGET_TIME = 1000000000 / FPS;
	// key board
	private keyBoard key;
	// Player
	private player player;
	// Bullet
	private List<bullet> bullets;
	// Rocket
	private List<rocket> rockets;
	// Effect
	private List<effect> boomEffects;

	public void start() {
		width = getWidth();
		height = getHeight();
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g2 = image.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (start) {
					long startTime = System.nanoTime();
					try {
						drawBackground();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					drawGame();
					render();
					long time = System.nanoTime() - startTime;
					if (time < TARGET_TIME) {
						long sleep = (TARGET_TIME - time) / 1000000;
						sleep(sleep);
					}

				}
			}
		});
		initobjectGamePlayer();
		initKeyBoard();
		initBullet();
		thread.start();
	}

	public void addRocket() {
		Random ran = new Random();
		int locationY = ran.nextInt(height - 50) + 25;
		rocket rk = new rocket();
		rk.changeLocation(0, locationY);
		rk.changeAngle(0);
		rockets.add(rk);
		int locationY2 = ran.nextInt(height - 50) + 25;
		rocket rk2 = new rocket();
		rk2.changeLocation(width, locationY2);
		rk2.changeAngle(180);
		rockets.add(rk2);
	}

	public void initobjectGamePlayer() {
		player = new player();
		player.changeLocation(width / 2, height / 2);
		rockets = new ArrayList<>();
		boomEffects = new ArrayList<>();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (start) {
					addRocket();
					sleep(3000);
				}

			}
		}).start();
	}

	private void initKeyBoard() {
		key = new keyBoard();
		requestFocus();
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_A) {
					key.setKeyLeft(true);
				} else if (e.getKeyCode() == KeyEvent.VK_D) {
					key.setKeyRight(true);
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					key.setKeySpace(true);
				} else if (e.getKeyCode() == KeyEvent.VK_J) {
					key.setKeyJ(true);
				} else if (e.getKeyCode() == KeyEvent.VK_K) {
					key.setKeyK(true);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_A) {
					key.setKeyLeft(false);
				} else if (e.getKeyCode() == KeyEvent.VK_D) {
					key.setKeyRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					key.setKeySpace(false);
				} else if (e.getKeyCode() == KeyEvent.VK_J) {
					key.setKeyJ(false);
				} else if (e.getKeyCode() == KeyEvent.VK_K) {
					key.setKeyK(false);
				}
			}
		});
		new Thread(new Runnable() {

			@Override
			public void run() {
				float s = 0.5f;
				while (start) {
					float angle = player.getAngle();
					if (key.isKeyLeft()) {
						angle -= s;
					}
					if (key.isKeyRight()) {
						angle += s;
					}
					if (key.isKeyJ() || key.isKeyK()) {
						if (shotTime == 0) {
							if (key.isKeyJ()) {
								bullets.add(0, new bullet(player.getX(), player.getY(), player.getAngle(), 8, 3f));
							} else {
								bullets.add(0, new bullet(player.getX(), player.getY(), player.getAngle(), 25, 3f));
							}
						}
						shotTime++;
						if (shotTime == 15) {
							shotTime = 0;
						}
					} else {
						shotTime = 0;
					}

					if (key.isKeySpace()) {
						player.speedUp();
					} else {
						player.speedDown();
					}
					player.update();
					player.changeAngle(angle);
					for (int i = 0; i < rockets.size(); i++) {
						rocket rocket = rockets.get(i);
						if (rocket != null) {
							rocket.update();
							if (!rocket.check(width, height)) {
								rockets.remove(rocket);
							}
						}
					}
					sleep(5);
				}
			}
		}).start();
	}

	private void initBullet() {
		bullets = new ArrayList<>();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (start) {
					for (int i = 0; i < bullets.size(); i++) {
						bullet bullet = bullets.get(i);
						if (bullet != null) {
							bullet.update();
							checkBullet(bullet);
							if (!bullet.check(width, height)) {
								bullets.remove(bullet);
							}
						} else {
							bullets.remove(bullet);
						}
					}
					/*for (int i = 0; i <= boomEffects.size(); i++) {
						effect boomEffect = boomEffects.get(i);
						if (boomEffect != null) {
							boomEffect.update();
							if (!boomEffect.check()) {
								boomEffects.remove(boomEffect);
							}
						} else {
							boomEffects.remove(boomEffect);
						}
					}*/
					sleep(1);
				}

			}
		}).start();
	}

	private void checkBullet(bullet bullet) {
		for (int i = 0; i < rockets.size(); i++) {
			rocket rocket = rockets.get(i);
			if (rocket != null) {
				Area area = new Area(bullet.getShape());
				area.intersect(rocket.getShape());
				if (!area.isEmpty()) {
					/*boomEffects.add(new effect(bullet.getCenterX(), bullet.getCenterY(), 3, 5, 60, 0.5f,
							new Color(230, 207, 105)));*/
					rockets.remove(rocket);
					bullets.remove(bullet);
				}
			}
		}
	}

	private void drawBackground() throws IOException {
		g2.setColor(new Color(30, 30, 30));
		g2.fillRect(0, 0, width, height);
		try {
			BufferedImage backgroundImage = ImageIO.read(
					new File("C:/Users/ADMIN/eclipse-workspace/lapTrinhGiaoDien/finalProject/Images/background.png"));
			g2.drawImage(backgroundImage, 0, 0, width, height, null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void drawGame() {
		player.draw(g2);
		for (int i = 0; i < bullets.size(); i++) {
			bullet bullet = bullets.get(i);
			if (bullet != null) {
				bullet.draw(g2);
			}
		}
		for (int i = 0; i < rockets.size(); i++) {
			rocket rocket = rockets.get(i);
			if (rocket != null) {
				rocket.draw(g2);
			}
		}
		for (int i = 0; i < boomEffects.size(); i++) {
			effect boomEffect = boomEffects.get(i);
			if (boomEffect != null) {
				boomEffect.draw(g2);
			}
		}

	}

	private void render() {
		Graphics g = getGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
	}

	public gamePanel() {

	}

	private void sleep(long speed) {
		try {
			Thread.sleep(speed);
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}

}
