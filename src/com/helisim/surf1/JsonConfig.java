package com.helisim.surf1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonConfig {
	
	public static final String BLOCK_A0 = "block-a0";
	public static final String BLOCK_A1 = "block-a1";
	public static final String INDEX = "index";
	public static final String BLOCKS = "blocks";
	public static final String ORIGO = "origo";
	public static final String TYPE = "type";
	public static final String FOIL = "foil";
	public static final String L_SCALE= "L";
	public static final String H_SCALE = "h-scale";
	public static final String Z_SCALE = "z-scale";
	
	public static final String X = "X";
	public static final String Y = "Y";
	public static final String Z = "Z";
	public static final String Y1 = "Y1";

	
//	type : linear,
//	foil : normal,
//	lengthScale : 150,
//	heightScale : 1,
//	origo : {X : 0.0, Y : 10, Z : 0.0},
	
	
	private final JSONArray mBlocks;
	
	public JSONArray getBlocks() {
		return mBlocks;
	}

	public JsonConfig(String fileName) throws IOException {
		Path p = Paths.get(fileName);

		List<String> str = Files.readAllLines(p, Charset.forName("UTF-8"));

		String all = "";
		for (String s : str) {
			all += s;
		}
		JSONObject data = new JSONObject(all);
		mBlocks = data.getJSONArray(BLOCKS);
		
	}

}
