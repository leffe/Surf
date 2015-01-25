package com.helisim.surf1;

import org.json.JSONObject;

public class EndBlock extends Block {

	EndBlock(JSONObject obj, SurfaceIf blockOrder) {
		super(obj, blockOrder, BlockType.POINT);
//		if (!getL().isNull() || !getY1().isNull()) {
//			throw new RuntimeException("End block is not null.");
//		}
	}

}
