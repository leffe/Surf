package com.helisim.conture;

import com.helisim.assembly.points.Value;
import com.helisim.assembly.points.Value2D;

public interface Line {
	public Value2D getStart();
	public Value2D getEnd();
	public Value getY(Value x);
	public Value2D getNext(Value2D current, Value dist);
	
	public Value getDerived();
}

