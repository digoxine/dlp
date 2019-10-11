package com.paracamplus.ilp2.ilp2tme3.vecteurs.interpreter.primitive;

import java.math.BigInteger;
import java.util.Vector;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.Primitive;

public class makeVector<E> extends Primitive{

	public makeVector() {
		super("vector");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getArity() {
		// TODO Auto-generated method stub
		return 2;
	}
	public Object apply(Object taille, Object valeur) throws EvaluationException{
		if ( taille instanceof BigInteger ) {
			BigInteger bi1= (BigInteger) taille;
			Vector<E> res = new <E> Vector();

			if ( valeur instanceof BigInteger) {
			
			}
		}
	
		return null;
	}

}
