package com.paracamplus.ilp2.ilp2tme4.solution3.compiler.normalizer;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.ilp2tme4.solution3.compiler.ast.ASTunless;

public class NormalizationFactory extends com.paracamplus.ilp2.compiler.normalizer.NormalizationFactory 
implements INormalizationFactory{

	@Override
	public IASTexpression newUnless(IASTexpression condition, IASTexpression body) {
		// TODO Auto-generated method stub
		return new ASTunless(body,condition);
	}

}
