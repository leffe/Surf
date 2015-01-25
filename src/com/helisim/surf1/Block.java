package com.helisim.surf1;

import org.json.JSONObject;

import com.helisim.assembly.points.Value;
import com.helisim.assembly.points.Value3D;

public class Block {
	
//	{"type : linear : linear borders in X-direction"},
//	{"type : curved : curved borders in X-direction"},
//	{"type : point : block end in a single point."},
//	{"anchor: X, Y, Z : lower left of block. L : length of block in X-direction. Y1 : upper left y of block"},
	
	
	public enum BlockType {
		LINEAR, CURVED, POINT;
	}

	private final BlockType mBlockType;
	
//	private Value mL;
//	
//	private Value mY1;
	
	private Value3D mA0;
	
	private Value3D mA1;
	
	public Block(JSONObject obj, SurfaceIf blockOrder, BlockType blockType) {
		mBlockType = blockType;
		System.out.println("Creating block, type: " + blockType);
		
		JSONObject a0 = obj.optJSONObject(JsonConfig.BLOCK_A0);
		JSONObject a1 = obj.optJSONObject(JsonConfig.BLOCK_A1);
		if (a0 != null && a1 != null) {
//			mL = new Value(a0.optDouble(JsonConfig.L_SCALE, 0.0));
//			mY1 = new Value(a0.optDouble(JsonConfig.Y1, 0.0));
			mA0 = new Value3D(a0);
			mA1 = new Value3D(a1);
			System.out.println("a0: " + mA0 + ", a1: " + mA1);
		}
	}
	
	public Value3D getA0() {
		return mA0;
	}
	
	public Value3D getA1() {
		return mA1;
	}
	
	public BlockType getBlockType() {
		return mBlockType;
	}

//	public Value getL() {
//		return mL;
//	}
//
//	public Value getY1() {
//		return mY1;
//	}
	
}
