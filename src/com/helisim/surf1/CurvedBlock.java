package com.helisim.surf1;

import org.json.JSONObject;

public class CurvedBlock extends Block {

	CurvedBlock(JSONObject obj, SurfaceIf blockOrder) {
		super(obj, blockOrder, BlockType.CURVED);
	}

}
