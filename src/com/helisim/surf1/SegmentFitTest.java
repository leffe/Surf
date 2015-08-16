package com.helisim.surf1;

import java.awt.Graphics;

import com.helisim.conture.LineFactory;
import com.helisim.conture.Line;
import com.helisim.spline.Spline2D;
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
//		li = lf.create(b , c);	drawLine(li);
//		li = lf.create(c, d);	drawLine(li);
//		li = lf.create(d, e);	drawLine(li);
//		li = lf.create(e, f);	drawLine(li);
//		li = lf.create(f, g);	drawLine(li);
//		li = lf.create(g, h);	drawLine(li);
//		li = lf.create(h, a);	drawLine(li);
//
//		li = lf.create(g, c);	drawLine(li);
//		li = lf.create(b, f);	drawLine(li);
//		
//		li = lf.create(h, d);	drawLine(li);
//		li = lf.create(e, a);	drawLine(li);
		
		
		Spline2D mSpline = new Spline2D();
		
		mSpline.startPoint(b, new Value("-0.5"));
		
//		mSpline.add(new Value2D(new Value("100.0"), li.getY(new Value("100.0"))));
//		mSpline.add(new Value2D(new Value("105.0"), li.getY(new Value("105.0"))));
//		mSpline.add(new Value2D("110.0", "50.0"));
//		mSpline.add(new Value2D("110.1", "49.95"));
//		mSpline.add(new Value2D("120.0", "45.0"));
		mSpline.add(new Value2D("125.0", "41.0"));
		
		
		mSpline.endPoint(new Value2D("140","40"), new Value("0.0"));
		
		
		
		
		drawDot(mSpline.get2DAt(new Value("110.0")));
		drawDot(mSpline.get2DAt(new Value("111.0")));
		drawDot(mSpline.get2DAt(new Value("113.0")));
		drawDot(mSpline.get2DAt(new Value("115.0")));
		drawDot(mSpline.get2DAt(new Value("120.0")));
		drawDot(mSpline.get2DAt(new Value("125.0")));
		drawDot(mSpline.get2DAt(new Value("128.0")));
		drawDot(mSpline.get2DAt(new Value("129.0")));
		drawDot(mSpline.get2DAt(new Value("130.0")));
		drawDot(mSpline.get2DAt(new Value("133.0")));
		drawDot(mSpline.get2DAt(new Value("138.0")));
		drawDot(mSpline.get2DAt(new Value("139.0")));
		drawDot(mSpline.get2DAt(new Value("140.0")));

	}
	
	public void drawLine(Line l) {
		Value d = new Value("2.0");
		
		Value2D v = l.getStart();
		while (v != null) {
			drawDot(v);
			v = l.getNext(v, d);
		}
		drawDot(l.getEnd());
	}
	
}
