package com.paracamplus.ilp2.ilp2tme4.modif2.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.ilp2tme4.modif2.interfaces.IASTvisitor;
import com.paracamplus.ilp2.ilp2tme4.modif2.interfaces.IASTunless;

public class ASTunless extends ASTexpression 
implements IASTunless {

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
			com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor,
			Data data) throws Anomaly {
		return ((IASTvisitor <Result, Data, Anomaly>) visitor).visit(this, data);
	}



	



	

}
