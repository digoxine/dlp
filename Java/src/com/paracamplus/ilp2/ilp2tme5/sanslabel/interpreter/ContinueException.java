package com.paracamplus.ilp2.ilp2tme5.sanslabel.interpreter;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

public class ContinueException extends EvaluationException {

	public ContinueException(Exception e) {
		super(e);
		// TODO Auto-generated constructor stub
	}
	public ContinueException(String msg) {
		super(msg);
	}

}
