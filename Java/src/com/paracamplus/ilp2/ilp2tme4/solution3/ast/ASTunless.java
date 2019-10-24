package com.paracamplus.ilp2.ilp2tme4.solution3.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.ilp2tme4.solution3.interfaces.IASTunless;
import com.paracamplus.ilp1.interfaces.IASTvisitable;
public class ASTunless extends ASTexpression 
implements IASTunless,IASTvisitable {

	public ASTunless(IASTexpression body, IASTexpression condition) {
		this.condition = condition;
		this.body = body;
	}
	private final IASTexpression condition;
	private final IASTexpression body;
	
	


	@Override
	public IASTexpression getCondition() {
		// TODO Auto-generated method stub
		return condition;
	}

	@Override
	public IASTexpression getBody() {
		// TODO Auto-generated method stub
		return body;
	}

	@Override
	public <Result, Data, Anomaly extends Throwable> Result accept(
			com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor, Data data) throws Anomaly {
		// TODO Auto-generated method stub
		return ((com.paracamplus.ilp2.ilp2tme4.solution3.interfaces.IASTvisitor <Result, Data, Anomaly>) visitor).visit(this, data);
	}
}
	

