package com.paracamplus.ilp2.ilp2tme3.interpreter.Primitive;

import java.io.IOException;
import java.io.Writer;
import java.lang.Math.*;
import java.math.BigDecimal;
import java.math.BigInteger;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.Primitive;

public class Sinus extends Primitive{

	public Sinus() {
		super("sinus");
	}


	@Override
	public int getArity() {
		return 1;
	}

	public Object apply(Object value) throws EvaluationException{
		if ( value instanceof BigInteger ) {
			BigInteger bi1 = (BigInteger) value;
			//Double d1 = new Double(bi1);
			return new BigDecimal(Math.sin(bi1.doubleValue()));
		}
		else if( value instanceof BigDecimal) {
			BigDecimal bd1 = (BigDecimal) value;
			return new BigDecimal(Math.sin(bd1.doubleValue()));

		}
		else {
			String msg = "Non numeric nor string argument";
			throw new EvaluationException(msg);
		}
	}
}
