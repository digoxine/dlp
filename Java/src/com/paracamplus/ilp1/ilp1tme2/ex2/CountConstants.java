package com.paracamplus.ilp1.ilp1tme2.ex2;

import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTbinaryOperation;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTboolean;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfloat;
import com.paracamplus.ilp1.interfaces.IASTinteger;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interfaces.IASToperator;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTstring;
import com.paracamplus.ilp1.interfaces.IASTunaryOperation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interfaces.IASTvisitor;
import com.paracamplus.ilp1.interpreter.LexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperator;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.parser.ParseException;
import com.paracamplus.ilp1.interpreter.Interpreter;;

public class CountConstants extends Interpreter implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {

	public CountConstants(IGlobalVariableEnvironment globalVariableEnvironment,
			IOperatorEnvironment operatorEnvironment) {
		super(globalVariableEnvironment, operatorEnvironment);
		// TODO Auto-generated constructor stub
	}
  @Override 
  public Object visit(IASTboolean iast, ILexicalEnvironment data) {
	  return new Integer(1);
  }
  
  @Override
  public Object visit(IASTinteger iast, ILexicalEnvironment data) {
	  return new Integer(1);
  }
  
  
  @Override
	public Object visit(IASTfloat iast, ILexicalEnvironment lexenv) 
          throws EvaluationException {
      return new Integer(1);
  }
  
  @Override
	public Object visit(IASTstring iast, ILexicalEnvironment lexenv) 
          throws EvaluationException {
      return new Integer(1);
  }
}
