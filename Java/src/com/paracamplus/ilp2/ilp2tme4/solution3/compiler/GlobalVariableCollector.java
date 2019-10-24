package com.paracamplus.ilp2.ilp2tme4.solution3.compiler;

import java.util.Set;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.interfaces.IASTCglobalVariable;
import com.paracamplus.ilp2.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp2.ilp2tme4.solution3.compiler.interfaces.IASTCvisitor;
import com.paracamplus.ilp2.ilp2tme4.solution3.compiler.interfaces.IASTunless;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;

public class GlobalVariableCollector extends com.paracamplus.ilp2.compiler.GlobalVariableCollector
implements IASTCvisitor<Set<IASTCglobalVariable>, 
Set<IASTCglobalVariable>, 
CompilationException> {

	 public Set<IASTCglobalVariable> analyze(IASTCprogram program) 
	            throws CompilationException {
	    	for ( IASTfunctionDefinition ifd : program.getFunctionDefinitions() ) {
	           result = ifd.getBody().accept(this, result);
	        }
	    	result = program.getBody().accept(this, result);
	        return result;
	    }
	@Override
	public Set<IASTCglobalVariable> visit(IASTunless iast, Set<IASTCglobalVariable> data) throws CompilationException {
		// TODO Auto-generated method stub
		data = iast.getCondition().accept(this, data);
		data= iast.getBody().accept(this, data);
		return data;
	}

}
