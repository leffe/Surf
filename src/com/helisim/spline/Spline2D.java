package com.helisim.spline;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;

import com.helisim.assembly.points.Point;
import com.helisim.assembly.points.Value;
import com.helisim.assembly.points.Value2D;

public class Spline2D {

	private List<Value2D> mKnots = new ArrayList<Value2D>();
	
	private PolynomialSplineFunction mSpline;
	
	public void add(Value2D value) {
		mKnots.add(value);
		mSpline = null;
	}
	
	
	public Point getAt(Value value) {
		Value val = getValAt(value);
		Value der = getDerAt(value);
		return new Point(val, der);
	}
	
	public Value2D get2DAt(Value value) {
		return new Value2D(value, getValAt(value));
	}
	
	private Value getValAt(Value value) {
		initSpline();
		return new Value(mSpline.value(value.getNative()));
	}
	
	private Value getDerAt(Value value) {
		initSpline();
		return new Value(mSpline.derivative().value(value.getNative()));
	}
	
	
	private void initSpline() {
		if (mSpline == null) {
			double[] x = new double[mKnots.size()];
			double[] y = new double[mKnots.size()];
			int idx = 0;
			for (Value2D v : mKnots) {
				x[idx] = v.getX().getNative();
				y[idx] = v.getY().getNative();
				idx++;
			}
			SplineInterpolator interpolator = new SplineInterpolator();
			mSpline = interpolator.interpolate(x, y);
		}
	}
}
