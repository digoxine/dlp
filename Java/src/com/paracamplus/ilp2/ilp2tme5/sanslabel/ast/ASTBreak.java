package com.paracamplus.ilp2.ilp2tme5.sanslabel.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvisitable;
import com.paracamplus.ilp1.interfaces.IASTvisitor;
import com.paracamplus.ilp2.ilp2tme5.sanslabel.interfaces.IASTbreak;

public class ASTBreak extends ASTexpression implements IASTbreak,IASTvisitable {

	@Override
	public <Result, Data, Anomaly extends Throwable> Result accept(IASTvisitor<Result, Data, Anomaly> visitor,
			Data data) throws Anomaly {
		// TODO Auto-generated method stub
		return ((com.paracamplus.ilp2.ilp2tme5.sanslabel.interfaces.IASTvisitor<Result,Data,Anomaly>) visitor).visit(this, data);
	}

}
