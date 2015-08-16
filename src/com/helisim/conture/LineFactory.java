package com.helisim.conture;

import com.helisim.assembly.points.Value;
import com.helisim.assembly.points.Value2D;

public class LineFactory {

	private LineFactory() {
	};

	public static LineFactory getInstance() {
		return new LineFactory();
	}
	
	public Line create(Value2D a, Value2D b) {
		Value lx = b.getAbsX().minus(a.getAbsX()).abs();
		Value ly = b.getAbsY().minus(a.getAbsY()).abs();
		System.out.println("lx=" + lx + ", ly=" +ly);
		if (lx.abs().greater(ly.abs())
				 
				) {
			return new XBasedLine(a, b);
		} else {
			return new YBasedLine(a, b);
		}
	}
	
	private class XBasedLine implements Line {
		private final Value2D ma;
		private final Value2D mb;
		
		private final Value mk;
		private final Value mm;
		private final Value ml;
		private final Value mSinAlpha;

		public XBasedLine(Value2D a, Value2D b) {
			ma = a;
			mb = b;
			/**
			 * 
			 * y = k*x + m
			 * m = y - k*x
			 * x = (y - m) / k 
			 * 
			 */
			mk = b.getY().minus(a.getY()).div(b.getX().minus(a.getX()));
			mm = a.getY().minus(mk.mul(a.getX()));
			ml  = b.getX().minus(a.getX()).sqr().add(b.getY().minus(a.getY()).sqr()).sqrt();
			
			mSinAlpha = new Value(Math.sin(Math.atan(mk.getNative())));
			System.out.println("XBased line: k=" + mk + ", m=" + mm + ", l=" + ml + ", sin(alpha)=" + mSinAlpha);
		}

		@Override
		public Value2D getStart() {
			return ma;
		}

		@Override
		public Value2D getEnd() {
			return mb;
		}

		@Override
		public Value2D getY(Value x) {
			return new Value2D(x, mk.mul(x).add(mm));
		}

		@Override
		public Value2D getNext(Value2D current, Value dist) {
			Value newX ;
			if (mk.getNative() == 0.0) {
				if (ma.getAbsX().less(mb.getAbsX())) {
					newX = current.getX().add(dist);
				} else {
					newX = current.getX().minus(dist);
				}
			} else if (mb.getX().minus(ma.getX()).getNative() > 0.0) {
				newX = current.getX().add((dist.mul(mSinAlpha)).div(mk));
			} else {
				newX = current.getX().minus((dist.mul(mSinAlpha)).div(mk));
			}
			if (inBounds(newX)) {
				return new Value2D(newX, getY(newX).getY());
			}
			return null;
		}
		
		private boolean inBounds(Value value) {
			if (ma.getX().less(value) && mb.getX().greater(value) ||
				ma.getX().greater(value) && mb.getX().less(value)) {
				return true;
			}
			return false;
		}

	}
	
	private class YBasedLine implements Line {
		private final Value2D ma;
		private final Value2D mb;
		
		private final Value mk;
		private final Value mm;
		private final Value ml;
		private final Value mCosAlpha;

		public YBasedLine(Value2D a, Value2D b) {
			ma = a;
			mb = b;
			/**
			 * 
			 * y = (x - m) / k
			 * m = x - k * y
			 * x = k * y + m 
			 * 
			 */
			mk = b.getX().minus(a.getX()).div(b.getY().minus(a.getY()));
			mm = a.getX().minus(mk.mul(a.getY()));
			ml  = b.getY().minus(a.getY()).sqr().add(b.getX().minus(a.getX()).sqr()).sqrt();
			mCosAlpha = new Value(Math.cos(Math.atan(mk.getNative())));
			System.out.println("YBased line: k=" + mk + ", m=" + mm + ", l=" + ml + ", cos(alpha)=" + mCosAlpha);
		}

		@Override
		public Value2D getStart() {
			return ma;
		}

		@Override
		public Value2D getEnd() {
			return mb;
		}

		@Override
		public Value2D getY(Value x) {
			return new Value2D(x, mk.mul(x).add(mm));
		}

		private Value2D getX(Value y) {
			return new Value2D(y.mul(mk).add(mm), y);
		}
		
		@Override
		public Value2D getNext(Value2D current, Value dist) {
			Value newY;
			if (mk.getNative() == 0.0) {
				if (ma.getAbsY().less(mb.getAbsY())) {
					newY = current.getY().add(dist);
				} else {
					newY = current.getY().minus(dist);
				}
			} else if (mb.getY().minus(ma.getY()).getNative() > 0.0) {
				newY = current.getY().add((dist.mul(mCosAlpha)));
			} else {
				newY = current.getY().minus((dist.mul(mCosAlpha)));
			}
			if (inBounds(newY)) {
				return new Value2D(getX(newY).getX(), newY);
			}
			return null;
		}
		
		private boolean inBounds(Value value) {
			if (ma.getY().less(value) && mb.getY().greater(value) ||
				ma.getY().greater(value) && mb.getY().less(value)) {
				return true;
			}
			return false;
		}

	}
	
}
