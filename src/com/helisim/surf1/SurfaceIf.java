package com.helisim.surf1;

import com.helisim.assembly.points.Value;
import com.helisim.assembly.points.Value2D;

public interface SurfaceIf {

	public Value2D getX0();

	public Value2D getX1();

	public Value getY0At(Value atX);

	public Value2D getV0At(Value atX);

	public Value getY1At(Value atX);
	
	public Value2D getV1At(Value atX);


	
}
