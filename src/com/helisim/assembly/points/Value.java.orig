package com.helisim.assembly.points;

public class Value {
	
	private final double mValue;
	
	public Value(String value) {
		value = normalize(value);
		mValue = Double.parseDouble(value);
	};

	
	public Value(double optDouble) {
		mValue = optDouble;
	}
	
	public static Value Val(String value) {
		return new Value(value);
	}

	
	public Value add(Value val) {
		return new Value(mValue + val.mValue);
	}

	private static String normalize(String str) {
		return str.replace(",", ".");
	}
	
	@Override
	public String toString() {
		return Double.toString(mValue);
	}


	public double getNative() {
		return mValue;
	}


	public boolean isNull() {
		return mValue == 0.0;
	}
	
}
