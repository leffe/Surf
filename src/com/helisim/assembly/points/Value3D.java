package com.helisim.assembly.points;

import org.json.JSONObject;

import com.helisim.surf1.JsonConfig;


public class Value3D {

	private final Value mX;
	private final Value mY;
	private final Value mZ;
	
	public Value3D(String x, String y, String z) {
		mX = new Value(x);
		mY = new Value(y);
		mZ = new Value(z);
	}

	public Value3D(JSONObject anchorObject) {
		mX = new Value(anchorObject.optDouble(JsonConfig.X, 0.0));
		mY = new Value(anchorObject.optDouble(JsonConfig.Y, 0.0));
		mZ = new Value(anchorObject.optDouble(JsonConfig.Z, 0.0));
	}
	
	@Override
	public String toString() {
		return getX() + ", "  + getY() + ", " + getZ();
	}

	public Value2D get2D() {
		return new Value2D(this);
	}
	
	public Value getX() {
		return mX;
	}

	public Value getY() {
		return mY;
	}

	public Value getZ() {
		return mZ;
	}

}
