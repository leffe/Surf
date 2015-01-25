package com.helisim.surf1;

import org.json.JSONObject;

public class LinearBlock extends Block {

	LinearBlock(JSONObject obj, SurfaceIf blockOrder) {
		super(obj, blockOrder, BlockType.LINEAR);
	}

}
