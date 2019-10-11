package com.paracamplus.ilp1.interpreter.primitive;

import java.io.IOException;
import java.io.Writer;
import java.lang.Math.*;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

public class Sinus extends Primitive{

	public Sinus(Writer out) {
		super("sinus");
		this.out = out;
		// TODO Auto-generated constructor stub
	}
    private final Writer out;


	@Override
	public int getArity() {
		// TODO Auto-generated method stub
		return 1;
	}

	public Object apply(Object value) throws EvaluationException{
		try {
			double res = Math.sin((double) (value));
            out.append(Double.toString(res));
        } catch (IOException e) {
            throw new EvaluationException(e);
        }
        return Boolean.FALSE;
	}
}
