package com.snippets;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDec {

	public static void main(String[] args) {
		double value1 = 1.33343439434d;
		double value2 = 1.5343;
		System.out.println(BigDecimal.valueOf( value1 ).multiply( BigDecimal.valueOf( value2 ) ).doubleValue());
		System.out.println(multiply(value1, value2));

	}

	
	public static double multiply(double d1, double d2) {
		String numberD = String.valueOf(d2);
		int k = numberD.indexOf(".");
		k = k > 0 ? numberD.length()-k :  2;
		k = Math.max(k, 2);
		MathContext context = new MathContext(k, RoundingMode.HALF_UP);
		return BigDecimal.valueOf( d1 ).multiply( BigDecimal.valueOf( d2 ) , context).doubleValue();
	}
}
