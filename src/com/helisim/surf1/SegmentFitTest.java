package com.helisim.surf1;

import java.awt.Graphics;

import com.helisim.conture.LineFactory;
import com.helisim.conture.Line;
import com.helisim.assembly.points.Value;
import com.helisim.assembly.points.Value2D;

public class SegmentFitTest extends Tracer {

	public SegmentFitTest(SurfaceIf surface) {
		super(surface);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void go(Graphics gr) {
		super.go(gr);		
		
		Value2D a = new Value2D("10.0", "100.0");
		Value2D b = new Value2D("110.0", "50.0");
		Value2D c = new Value2D("210.0", "50.0");
		Value2D d = new Value2D("310.0", "100.0");
		Value2D e = new Value2D("310.0", "200.0");
		Value2D f = new Value2D("210.0", "250.0");
		Value2D g = new Value2D("110.0", "250.0");
		Value2D h = new Value2D("10.0", "200.0");
		Value2D i = new Value2D("320.2", "110.0");

		LineFactory lf = LineFactory.getInstance();
		Line li;
		li = lf.create(a, b);	drawLine(li);
		li = lf.create(b , c);	drawLine(li);
		li = lf.create(c, d);	drawLine(li);
		li = lf.create(d, e);	drawLine(li);
		li = lf.create(e, f);	drawLine(li);
		li = lf.create(f, g);	drawLine(li);
		li = lf.create(g, h);	drawLine(li);
		li = lf.create(h, a);	drawLine(li);

		li = lf.create(g, c);	drawLine(li);
		li = lf.create(b, f);	drawLine(li);
		
		li = lf.create(h, d);	drawLine(li);
		li = lf.create(e, a);	drawLine(li);
	}
	
	public void drawLine(Line l) {
		Value d = new Value("3.0");
		
		Value2D v = l.getStart();
		while (v != null) {
			drawDot(v);
			v = l.getNext(v, d);
		}
		drawDot(l.getEnd());
	}
	
}
