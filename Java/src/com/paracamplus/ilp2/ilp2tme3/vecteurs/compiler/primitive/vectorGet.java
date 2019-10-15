package com.paracamplus.ilp2.ilp2tme3.vecteurs.compiler.primitive;

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
		return 2;
	}
	
	public Object apply(Object vector, Object index) throws EvaluationException {
		
		if (vector instanceof Vector) {
			Vector<?> vec = (Vector) vector;
			if (index instanceof BigInteger) {
				
				BigInteger bi1 = (BigInteger) index;
				System.out.println(bi1);
				//System.out.println(vec.get(bi1.intValue()));
				if (vec.get(bi1.intValue()) instanceof BigInteger) {
					System.out.println("if Big Integer");
					return vec.get(bi1.intValue());
				}
				else if (vec.get(bi1.intValue()) instanceof BigDecimal) {

					return vec.get(bi1.intValue());
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
		else {
			String msg = "first argument must be a vector";
			throw new EvaluationException(msg);
		}
		
		
		
	}
	
	
	
}
