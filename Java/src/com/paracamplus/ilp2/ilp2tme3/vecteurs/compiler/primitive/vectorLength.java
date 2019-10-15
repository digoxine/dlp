package com.paracamplus.ilp2.ilp2tme3.vecteurs.compiler.primitive;
import java.math.BigInteger;
import java.util.Vector;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.Primitive;

public class vectorLength<E> extends Primitive{

	public vectorLength() {
		super("length");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getArity() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	public Object apply(Object vector) throws EvaluationException {
		
		if (vector instanceof Vector) {
			Vector<?> vect = (Vector) vector;
			return vect.size();
		}
		else {
			String msg = "object must be a vector";
			throw new EvaluationException(msg);
		}
		//BigInteger sizeVec = BigInteger.valueOf(vector.size());
		//System.out.print(sizeVec.intValue());
	}

}
