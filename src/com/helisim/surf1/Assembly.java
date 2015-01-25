package com.helisim.surf1;

import java.util.ArrayList;
import java.util.List;

import com.helisim.assembly.points.Value;
import com.helisim.assembly.points.Value2D;
import com.helisim.assembly.points.Value3D;
import com.helisim.spline.Spline2D;


public class Assembly implements SurfaceIf {
	
	private boolean mClosed = false;
	private final List<Block> mBlocks = new ArrayList<Block>();
	
	private Spline2D mY0Spline = new Spline2D();
	private Spline2D mY1Spline = new Spline2D();
	
	public void addBlock(Block block) {
		if (!mBlocks.contains(block) && !mClosed) {
			mBlocks.add(block);
		} else {
			throw new RuntimeException("Block already added or assembly is closed.");
		}
	}
	
	public void close() {
		for (Block b : mBlocks) {
			mY0Spline.add(b.getA0().get2D());
//			Value2D v1 = new Value2D(b.getA0().getX(), b.getY1());
			mY1Spline.add(b.getA1().get2D());
		}
		mClosed = true;
	}

	@Override
	public Value2D getX0() {
		checkClosed();
		return mBlocks.get(0).getA0().get2D();
	}


	@Override
	public Value2D getX1() {
		checkClosed();
		Block block = mBlocks.get(mBlocks.size()-1);
		return block.getA0().get2D();
	}


	@Override
	public Value getY0At(Value atX) {
		checkClosed();
		return mY0Spline.getAt(atX).getPoint();
	}

	@Override
	public Value2D getV0At(Value atX) {
		checkClosed();
		return mY0Spline.get2DAt(atX);
	}


	@Override
	public Value getY1At(Value atX) {
		checkClosed();
		return null;
	}


	@Override
	public Value2D getV1At(Value atX) {
		checkClosed();
		return mY1Spline.get2DAt(atX);
	}

	private void checkClosed() {
		if (!mClosed) {
			throw new RuntimeException("Assembly is not closed.");
		}
	}

}
