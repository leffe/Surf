package com.helisim.surf1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;

public class Foil {
	
	
	public void read(String fileName) throws IOException {
		
		Path p = Paths.get(fileName);
		
		List<String> lines =	Files.readAllLines(p, Charset.forName("UTF-8"));
		
		for (String s : lines){
		System.out.println(s);
		}
        System.out.println("Test");
		
	       double x[] = { 0.0, 0.5, 1.0 };
	        double y[] = { 0.0, 0.4, 0.77 };
	        SplineInterpolator i = new SplineInterpolator();
	        PolynomialSplineFunction ss = i.interpolate(x, y);
	        
	        
	        System.out.println(ss.value(0.0));
	        System.out.println(ss.value(0.25));
	        System.out.println(ss.value(0.5));
	        System.out.println(ss.value(0.75));
	        System.out.println(ss.value(1.0));
//	        verifyInterpolation(f, x, y);		
		
	}

	

}
