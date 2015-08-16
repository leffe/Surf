package com.helisim.surf1;

import java.io.IOException;

import org.json.JSONArray;

import com.helisim.assembly.points.Value;
import com.helisim.assembly.points.Value2D;
import com.helisim.disp.Disp;



public class Main {

	public static void main(String[] args) throws IOException {
		
		   Disp GP = new Disp(new SegmentFitTest(null));  
	
		
//		Foil f = new Foil();
//		f.read("naca64a010.txt");
//
//		JsonConfig blockConfig = new JsonConfig("json-config.txt");
//		Assembly assembly = new Assembly();
//		
//		JSONArray blocks = blockConfig.getBlocks();
//		
//		BlockFactory factory = new BlockFactory(assembly);
//		
//		for (int idx = 0; idx < blocks.length(); idx++) {
//			assembly.addBlock(factory.newBlock(blocks.getJSONObject(idx)));
//		}
//		assembly.close();
//		
//		
//		
//		Tracer tracer = new YTracer(assembly);
//		
//		/** Assembly test */
//
////		tracer.go();
//		
//		
//		
//		/** Tests */
//		Value p1 = new Value("1");
//		Value p2 = new Value("1.1");
//		Value p3 = new Value("1,1");
//		
//		Value2D p22 = new Value2D("0.323443", "12.44334");
//		
//
//	     GP = new Disp(tracer);  
//
		
	}
	
	
	
	
}
