package com.pengrui.pointline;

public class Line {
	private Point point;
	private double x2;
	private double y2;
	
	public Line() {
		
	}
	
	public Line(double x1, double y1, double x2, double y2) {
		point.setPoint(x1, y1);
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public Line(Point point1, Point point2) {
		point = point1;
		this.x2 = point2.getX();
		this.y2 = point2.getY();
	}

	public double getX1() {
		return point.getX();
	}

	public void setX1(double x1) {
		point.setX(x1);
	}

	public double getY1() {
		return point.getY();
	}

	public void setY1(double y1) {
		point.setY(y1);
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}
	
	public Point getBegin() {
		return point.getPoint();
	}
	
	public Point getEnd() {
		Point p = new Point(x2, y2);
		return p;
	}
	
	public String toString() {
		Point p1 = new Point(x2, y2);
		return "Begin:" + point.toString() + ",End:" + p1.toString();
	}
}
