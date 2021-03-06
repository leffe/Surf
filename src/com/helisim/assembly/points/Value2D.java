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
	
	public Value2D() {
		mX = new Value("0.0");
		mY = new Value("0.0");
	}

	public Value getX() {
		return mX;
	}

	public Value getAbsX() {
		return new Value(Math.abs(mX.getNative()));
	}

	public Value getY() {
		return mY;
	}
	
	public Value getAbsY() {
		return new Value(Math.abs(mY.getNative()));
	}
	
	@Override
	public String toString() {
		return getX() + ", " + getY();
	}
}
