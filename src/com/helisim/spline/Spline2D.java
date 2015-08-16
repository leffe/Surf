package com.helisim.spline;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;

import com.helisim.assembly.points.Point;
import com.helisim.assembly.points.Value;
import com.helisim.assembly.points.Value2D;

public class Spline2D {

	/**
	 * x distance used to create point on pre and aft lines
	 */
	private final Value mPreDist = new Value("2.0");
	
	private List<Value2D> mKnots = new ArrayList<Value2D>();
	
	private PolynomialSplineFunction mSpline;
	
	
	/**
	 * Sets the start point of the curve together with its derivative.
	 * @param point
	 * @param derivate
	 */
	public void startPoint(Value2D point, Value derivate) {
		/* Create two points left of the start point on a straight line 
		 * through the start point with the given derivative.
		 */
		Value dx = mPreDist; 
		Value dy = dx.mul(derivate);
		Value2D pMinus1 = new Value2D(point.getX().minus(dx), point.getY().minus(dy));
		dx = mPreDist.mul(new Value("2.0")); 
		dy = dx.mul(derivate);
		Value2D pMinus2 = new Value2D(point.getX().minus(dx), point.getY().minus(dy));
		
		add(pMinus2);
		add(pMinus1);
	}

	/**
	 * Sets the end point together with its derivative
	 * @param point
	 * @param derivate
	 */
	public void endPoint(Value2D point, Value derivate) {
		/* Create two points right of the end point on a straight line 
		 * through the end point with the given derivative.
		 */
		Value dx = mPreDist; 
		Value dy = dx.mul(derivate);
		Value2D pPlus1 = new Value2D(point.getX().add(dx), point.getY().add(dy));
		dx = mPreDist.mul(new Value("2.0")); 
		dy = dx.mul(derivate);
		Value2D pPlus2 = new Value2D(point.getX().add(dx), point.getY().add(dy));
		
		add(pPlus1);
		add(pPlus2);
		
	}

	
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
