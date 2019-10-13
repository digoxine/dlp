package com.paracamplus.ilp2.ilp2tme3.vecteurs.interpreter.primitive;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Vector;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.Primitive;

public class vectorGet<E> extends Primitive{

	public vectorGet() {
		super("get");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getArity() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	public Object apply(Vector<E> vector, Object index) throws EvaluationException {
		
		if (index instanceof BigInteger) {
			
			BigInteger bi1 = (BigInteger) index;
			E element = vector.get(bi1.intValue());
			if (element instanceof BigInteger) {
				BigInteger bi2 = (BigInteger) element;
				return bi2;
			}
			else if (element instanceof BigDecimal) {
				BigDecimal bi2 = (BigDecimal) element;
				return bi2;
			}
			else {
				String msg = "A vector must be a collection of Double or Integer";
				throw new EvaluationException(msg);
			}
		}
		else {
			String msg = "index must be an integer";
			throw new EvaluationException(msg);
		}
		
		
	}
}
