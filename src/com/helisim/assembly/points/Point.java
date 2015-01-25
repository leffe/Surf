package com.helisim.assembly.points;

public class Point {
	
	private Value mP;
	private Value mDer;
	
	public Point(Value p, Value der) {
		mP = p;
		mDer = der;
	}
	

	public Value getPoint() {
		return mP;
	}
	
	public Value getDer() {
		return mDer;
	}
	
	@Override
	public String toString() {
		return "v: " + mP.toString() + ", d: "+ mDer.toString();
	}


	
}
