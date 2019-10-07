package com.paracamplus.ilp1.ilp1tme1.sequence;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

public class ASTsequence extends com.paracamplus.ilp1.ast.ASTsequence implements IASTsequence {

	public ASTsequence(IASTexpression[] expressions) {
		super(expressions);
		// TODO Auto-generated constructor stub
	}

	@Override
	public IASTexpression[] getAllButLastInstructions() throws EvaluationException {
		// TODO Auto-generated method stub
		IASTexpression[] iastex = getExpressions();
		IASTexpression[] iastex_no_last_instruction = new IASTexpression[iastex.length-1];
		for(int i=0;i<iastex.length-1;i++) {
			iastex_no_last_instruction[i]=iastex[i];
		}
		return iastex_no_last_instruction;				
	}

}
