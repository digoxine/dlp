package com.paracamplus.ilp2.ilp2tme5.sanslabel.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.ilp2tme5.sanslabel.interfaces.IASTfactory;

public class ASTfactory extends com.paracamplus.ilp2.ast.ASTfactory implements IASTfactory {

	@Override
	public IASTexpression newBreak() {
		// TODO Auto-generated method stub
		return new ASTBreak();
	}

	@Override
	public IASTexpression newContinue() {
		// TODO Auto-generated method stub
		return new ASTContinue();
	}

}
