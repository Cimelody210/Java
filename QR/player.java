package gameElements;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

import Main.mainGame;

public class player {
	public static final double PLAYER_SIZE = 64;
	private double x;
	private double y;
	private float angle = 0f;
	private final Image hinh;
	private final Image hinhspeed;
	private final float MAX_SPEED = 2f;
	private float speed = 0f;
	private boolean speedUp;

	public player() {
		this.hinh = new ImageIcon("C:/Users/ADMIN/eclipse-workspace/lapTrinhGiaoDien/finalProject/Images/ship1.png")
				.getImage();
		this.hinhspeed = new ImageIcon(
				"C:/Users/ADMIN/eclipse-workspace/lapTrinhGiaoDien/finalProject/Images/ship2.png").getImage();
	}

	public void changeLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void update() {
		mainGame gameWindow = new mainGame();
		double newX = x + Math.cos(Math.toRadians(angle)) * speed;
		double newY = y + Math.sin(Math.toRadians(angle)) * speed;
		if (newX >= 0 && newX <= gameWindow.getWindowWidth() - PLAYER_SIZE) {
			x = newX; // Update x-coordinate if within the horizontal boundaries
		} else {
			// If the new position is outside the horizontal boundaries, adjust the position
			// to make the player reappear from the opposite boundary
			x = (newX < 0) ? gameWindow.getWindowWidth() - PLAYER_SIZE : 0;
		}

		if (newY >= 0 && newY <= gameWindow.getWindowHeight() - PLAYER_SIZE) {
			y = newY; // Update y-coordinate if within the vertical boundaries
		} else {
			// If the new position is outside the vertical boundaries, adjust the position
			// to make the player reappear from the opposite boundary
			y = (newY < 0) ? gameWindow.getWindowHeight() - PLAYER_SIZE : 0;
		}

	}

	public void changeAngle(float angle) {
		if (angle < 0) {
			angle = 359;
		} else if (angle > 359) {
			angle = 0;
		}
		this.angle = angle;
	}

	public void draw(Graphics2D g2) {
		AffineTransform oldTransform = g2.getTransform();
		g2.translate(x, y);
		AffineTransform tran = new AffineTransform();
		tran.rotate(Math.toRadians(angle + 90), PLAYER_SIZE / 2, PLAYER_SIZE / 2);
		g2.transform(tran);
		g2.drawImage(speedUp ? hinhspeed : hinh, 0, 0, null);
		g2.setTransform(oldTransform);

	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public float getAngle() {
		return angle;
	}

	public void speedUp() {
		speedUp = true;
		if (speed > MAX_SPEED) {
			speed = MAX_SPEED;
		} else {
			speed += 0.01f;
		}
	}

	public void speedDown() {
		speedUp = false;
		if (speed <= 0) {
			speed = 0;
		} else {
			speed -= 0.005f;
		}
	}
}
