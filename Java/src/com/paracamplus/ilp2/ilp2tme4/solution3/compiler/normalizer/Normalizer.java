package com.paracamplus.ilp2.ilp2tme4.solution3.compiler.normalizer;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.interfaces.IASTCglobalFunctionVariable;
import com.paracamplus.ilp1.compiler.normalizer.INormalizationEnvironment;
import com.paracamplus.ilp1.compiler.normalizer.NormalizationEnvironment;
import com.paracamplus.ilp1.interfaces.IASTexpression;

import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp2.compiler.interfaces.IASTCfunctionDefinition;
import com.paracamplus.ilp2.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp2.ilp2tme4.solution3.compiler.normalizer.INormalizationFactory;
import com.paracamplus.ilp2.ilp2tme4.solution3.compiler.interfaces.IASTvisitor;

public class Normalizer extends com.paracamplus.ilp2.compiler.normalizer.Normalizer
		implements IASTvisitor<IASTexpression, INormalizationEnvironment, CompilationException> {

	public Normalizer(INormalizationFactory factory) {
		super(factory);
		// TODO Auto-generated constructor stub
	}



    public IASTCprogram transform(IASTprogram program) 
            throws CompilationException {
        INormalizationEnvironment env = NormalizationEnvironment.EMPTY;
        IASTfunctionDefinition[] functions = program.getFunctionDefinitions();
        IASTCfunctionDefinition[] funs = 
                new IASTCfunctionDefinition[functions.length];
        for ( IASTfunctionDefinition function : functions ) {
            IASTCglobalFunctionVariable gfv =
                    ((INormalizationFactory)factory).newGlobalFunctionVariable(function.getName());
            env = env.extend(gfv, gfv);
        }
        for ( int i=0 ; i<functions.length ; i++ ) {
            IASTfunctionDefinition function = functions[i];
            IASTCfunctionDefinition newfunction = visit(function, env);
            funs[i] = newfunction;
        }
        
        IASTexpression body = program.getBody();
        IASTexpression newbody = body.accept(this, env);
        return ((INormalizationFactory)factory).newProgram(funs, newbody);
    }



	@Override
	public IASTexpression visit(com.paracamplus.ilp2.ilp2tme4.solution3.compiler.interfaces.IASTunless iast,
			INormalizationEnvironment data) throws CompilationException {
		// TODO Auto-generated method stub
		IASTexpression c = iast.getCondition().accept(this, data);
		IASTexpression t = iast.getBody().accept(this, data);
		return ((INormalizationFactory)factory).newUnless(c, t);
	}

}
