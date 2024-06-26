package gameElements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;

import javax.swing.ImageIcon;

import Main.mainGame;

public class rocket {
	public static final double ROCKET_SIZE = 50;
	private double x;
	private double y;
	private float speed = 0.8f;
	private float angle = 0;
	private final Image image;
	private final Area rocketShape;

	public rocket() {
		this.image = new ImageIcon("C:/Users/ADMIN/eclipse-workspace/lapTrinhGiaoDien/finalProject/Images/rocket1.png")
				.getImage();
		Path2D p = new Path2D.Double();
		p.moveTo(0, ROCKET_SIZE / 2);
		p.lineTo(ROCKET_SIZE - 5, 13);
		p.lineTo(ROCKET_SIZE + 10, ROCKET_SIZE / 2);
		p.lineTo(ROCKET_SIZE - 5, ROCKET_SIZE - 13);
		p.lineTo(15, ROCKET_SIZE - 10);
		rocketShape = new Area(p);
	}

	public void changeLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void update() {
		x += Math.cos(Math.toRadians(angle)) * speed;
		y += Math.sin(Math.toRadians(angle)) * speed;

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
		tran.rotate(Math.toRadians(angle + 180), ROCKET_SIZE / 2, ROCKET_SIZE / 2);
		g2.drawImage(image, tran, null);
		Shape shape = getShape();
		g2.setTransform(oldTransform);

		/*
		 * g2.setColor(Color.red); g2.draw(shape); g2.draw(shape.getBounds2D());
		 */
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

	public Area getShape() {
		AffineTransform afx = new AffineTransform();
		afx.translate(x, y);
		afx.rotate(Math.toRadians(angle), ROCKET_SIZE / 2, ROCKET_SIZE / 2);
		return new Area(afx.createTransformedShape(rocketShape));
	}

	public boolean check(int width, int height) {
		Rectangle size = getShape().getBounds();
		if (x <= -size.getWidth() || y <= -size.getHeight() || x > width || y > height) {
			return false;
		} else {
			return true;
		}

	}

}
