package com.helisim.surf1;

import java.awt.Graphics;

import com.helisim.assembly.points.Value2D;
import com.helisim.assembly.points.Value;


public class YTracer extends Tracer {

	public YTracer(SurfaceIf surface) {
		super(surface);
	}

	@Override
	public void go(Graphics g) {
		super.go(g);
		Value2D x0 = mSurface.getX0();
		System.out.println("X0: " + x0);
		Value2D x1 = mSurface.getX1();
		System.out.println("X1: " + x1);
		
		Value x = new Value("5.0");
		System.out.println("Y0 at: " + x + "=" + mSurface.getY0At(x));
		x = new Value("490.0");
		System.out.println("Y0 at: " + x + "=" + mSurface.getY0At(x));
		x = new Value("500.0");
		System.out.println("Y0 at: " + x + "=" + mSurface.getY0At(x));
		
		for (int i = 0;i < 535; i+=3) {
			Value n = new Value(Integer.toString(i));
			drawDot(mSurface.getV0At(n));
     		drawDot(mSurface.getV1At(n));
		}
		
	}


}
