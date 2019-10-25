package com.paracamplus.ilp2.ilp2tme5.sanslabel.compiler.normalizer;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.normalizer.INormalizationEnvironment;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.ilp2tme5.sanslabel.compiler.normalizer.INormalizationFactory;
import com.paracamplus.ilp2.ilp2tme5.sanslabel.interfaces.IASTbreak;
import com.paracamplus.ilp2.ilp2tme5.sanslabel.interfaces.IASTcontinue;
import com.paracamplus.ilp2.ilp2tme5.sanslabel.interfaces.IASTvisitor;

public class Normalizer extends com.paracamplus.ilp2.compiler.normalizer.Normalizer
		implements IASTvisitor<IASTexpression, INormalizationEnvironment, CompilationException> {

	public Normalizer(INormalizationFactory factory) {
		super(factory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public IASTexpression visit(IASTbreak iast, INormalizationEnvironment data) throws CompilationException {
		// TODO Auto-generated method stub
		return ((INormalizationFactory)factory).newBreak();
	}

	@Override
	public IASTexpression visit(IASTcontinue iast, INormalizationEnvironment data) throws CompilationException {
		// TODO Auto-generated method stub
		return ((INormalizationFactory)factory).newContinue();
	}

}
