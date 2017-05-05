package com.pengrui.pointline;

public class LineSub extends Point{
	private Point end;
	
	public LineSub() {
		
	}
	
	public LineSub(double beginX, double beginY, double endX, double endY) {
		super(beginX, beginY);
		this.end = new Point(endX, endY);
	}
	
	public LineSub(Point begin, Point end) {
		super(begin.getX(), begin.getY());
		this.end = end;
	}
	
	public Point getBegin() {
		return super.getPoint();
	}
	
	public Point getEnd() {
		return end;
	}
	
	public void setBegin(double beginX, double beginY) {
		super.setPoint(beginX, beginY);
	}
	
	public void setEnd(double endX, double endY) {
		end.setPoint(endX, endY);
	}
	
	public double getBeginX() {
		return super.getX();
	}
	
	public double getBeginY() {
		return super.getY();
	}
	
	public double getEndX() {
		return end.getX();
	}
	
	public double getEndY() {
		return end.getY();
	}
	
	public void setBeginX(double beginX) {
		super.setX(beginX);
	}
	
	public void setBeginY(double beginY) {
		super.setY(beginY);
	}
	
	public void setBeginXY(double beginX, double beginY) {
		super.setPoint(beginX, beginY);
	}
	
	public void setEndX(double endX) {
		end.setX(endX);
	}
	
	public void setEndY(double endY) {
		end.setY(endY);
	}
	
	public void setEndXY(double endX, double endY) {
		end.setPoint(endX, endY);
	}
	
	public double getLength() {
		return Math.sqrt((end.getX() - super.getX()) * (end.getX() - super.getX()) + 
				(end.getY() - super.getY()) * (end.getY() - super.getY())); 
	}
	
	public double getGradient() {
		return Math.atan((end.getY() - super.getY())/ (end.getX() - super.getX()));
	}
	
	public String toString() {
		return "Begin:" + super.toString() + ",End:" + end.toString();
	}
}
