package com.helisim.surf1;

import java.awt.Graphics;

import com.helisim.assembly.points.Value2D;

public abstract class Tracer {

	public final SurfaceIf mSurface;
	private Graphics mG;

	public Tracer(SurfaceIf surface) {
		mSurface = surface;
	}
	
	public void go(Graphics g) {
		mG = g;
	}

	protected void drawDot(Value2D p) {
		int scale = 3;
		 mG.fillOval(
				 (int)Math.round(p.getX().getNative()*scale), 
				 (int)Math.round(p.getY().getNative()*scale), 
				 3, 3);
		
	}

}
