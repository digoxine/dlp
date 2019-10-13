package com.paracamplus.ilp2.ilp2tme3.vecteurs.interpreter.primitive;
import java.math.BigInteger;
import java.util.Vector;

import com.paracamplus.ilp1.interpreter.primitive.Primitive;

public class vectorLength<E> extends Primitive{

	public vectorLength() {
		super("length");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getArity() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Object apply(Vector<E> vector) {
		BigInteger sizeVec = BigInteger.valueOf(vector.size());
		return sizeVec;
	}

}
