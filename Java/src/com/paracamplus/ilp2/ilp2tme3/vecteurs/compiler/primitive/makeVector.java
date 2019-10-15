package com.paracamplus.ilp2.ilp2tme3.vecteurs.compiler.primitive;

import java.math.BigDecimal;
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
			//Class<E> persistentClass = (Class<E>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			if ( valeur instanceof BigInteger) {
				//On creee notre vecteur donc ici nous sommes sure du type de E. Ce sera celui de valeur

				BigInteger bi2 = (BigInteger) valeur;
				Vector<BigInteger> res = new Vector<BigInteger>();

				for (int i =0 ; i<bi1.intValue();i++) {

					res.addElement(bi2);
				}
				return res;			
			}
			else if ( valeur instanceof BigDecimal) {
				//Vector<Double>
				BigDecimal bi2 = (BigDecimal) valeur;
				Vector<BigDecimal> res = new Vector<BigDecimal>();
				for (int i=0; i<bi1.intValue();i++) {
					res.add(bi2);
				}
				return res;
			}
			else {
				String msg = "value must be an integer or a Double";
				throw new EvaluationException(msg);
			}
		}
		else {
			String msg = "length must be an integer";
			throw new EvaluationException(msg);
		}
	
	}

}
