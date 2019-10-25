package com.paracamplus.ilp2.ilp2tme5.sanslabel.interpreter;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

public class BreakException extends EvaluationException {

	public BreakException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
	public BreakException(Exception e) {
		super(e);
	}

}
