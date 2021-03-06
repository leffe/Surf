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


	public Value minus(Value y) {
		return new Value(mValue - y.getNative());
	}


	public Value div(Value value) {
		return new Value(mValue/value.getNative());
	}


	public Value mul(Value x) {
		return new Value(mValue*x.getNative());
	}


	public Value sqr() {
		return new Value(mValue*mValue);
	}
	
	public Value sqrt() {
		return new Value(Math.sqrt(mValue));
	}
	
	public boolean greater(Value n) {
		return mValue > n.getNative();
	}
	
	public boolean less(Value n) {
		return mValue < n.getNative();
	}
	
	public Value abs() {
		return new Value(Math.abs(mValue));
	}
}
