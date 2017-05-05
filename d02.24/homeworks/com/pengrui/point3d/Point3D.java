package com.pengrui.point3d;

public class Point3D extends Point2D{
	private int z;
	
	public Point3D() {
		
	}
	
	public Point3D(Point2D point, int z) {
		super(point.getX(), point.getY());
		this.z = z;
	}
	
	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	public int getZ() {
		return z;
	}
	
	public void setZ(int z) {
		this.z = z;
	}
	
	public int[] getXYZ() {
		return new int[]{super.getX(), super.getY(), z};
	}
	
	public void setXYZ(int x, int y, int z) {
		super.setX(x);;
		super.setY(y);;
		this.z = z;
	}
	
	public String toString() {
		return "(" + super.getX() + "," + super.getY() + "," + getZ() + ")";
	}
}
