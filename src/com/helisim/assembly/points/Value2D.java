package com.helisim.assembly.points;


public class Value2D {

	private final Value mX;
	private final Value mY;
	
	public Value2D(String x, String y) {
		mX = new Value(x);
		mY = new Value(y);
	}
	
	public Value2D(Value3D point3) {
		mX = point3.getX();
		mY = point3.getY();
	}
	
	public Value2D(Value x, Value y) {
		mX = x;
		mY = y;
	}
	
	public Value getX() {
		return mX;
	}

	public Value getY() {
		return mY;
	}
	
	@Override
	public String toString() {
		return getX() + ", " + getY();
	}
}
