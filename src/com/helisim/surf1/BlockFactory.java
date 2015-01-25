package com.helisim.surf1;

import org.json.JSONObject;

public class BlockFactory {

	private final SurfaceIf mBlockOrder;
	
	public BlockFactory(SurfaceIf blockOrder) {
		mBlockOrder = blockOrder;
	}
	
	public Block newBlock(JSONObject block) {
		if (block.optString("type").equals("linear")) {
			return new LinearBlock(block, mBlockOrder);
		} else if (block.optString("type").equals("curved")) {
			return new CurvedBlock(block, mBlockOrder);
		} else if (block.optString("type").equals("point")) {
			return new EndBlock(block, mBlockOrder);
		} else {
			throw new RuntimeException("Unspecified block type.");
		}
	}
}
