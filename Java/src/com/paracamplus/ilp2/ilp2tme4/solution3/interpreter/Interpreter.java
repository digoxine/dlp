package com.paracamplus.ilp2.ilp2tme4.solution3.interpreter;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp2.ilp2tme4.solution3.interfaces.IASTunless;
import com.paracamplus.ilp2.ilp2tme4.solution3.interfaces.IASTvisitor;

public class Interpreter extends com.paracamplus.ilp2.interpreter.Interpreter
implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException>{

	public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment, IOperatorEnvironment operatorEnvironment) {
		super(globalVariableEnvironment, operatorEnvironment);
		// TODO Auto-generated constructor stub
	}
    private static Object whatever = "whatever";

	@Override
	public Object visit(IASTunless iast, ILexicalEnvironment data) throws EvaluationException {
		// TODO Auto-generated method stub
		Object c = iast.getCondition().accept(this, data);
		if(c!=null && c instanceof Boolean) {
			Boolean b = (Boolean) c;
			if(!b.booleanValue())
				return iast.getBody().accept(this, data);
			else {
				return whatever;
			}
		}
		else {
			return iast.getBody().accept(this, data);
		}
	}

}
