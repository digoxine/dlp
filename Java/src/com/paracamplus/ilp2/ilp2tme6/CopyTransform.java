package com.paracamplus.ilp2.ilp2tme6;
import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTbinaryOperation;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTboolean;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfloat;
import com.paracamplus.ilp1.interfaces.IASTinteger;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTstring;
import com.paracamplus.ilp1.interfaces.IASTunaryOperation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp2.interfaces.IASTassignment;
import com.paracamplus.ilp2.interfaces.IASTfactory;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTloop;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp2.interfaces.IASTvisitor;

public class CopyTransform<Data> implements IASTvisitor<IASTexpression, Data, CompilationException> {
	public CopyTransform(IASTfactory fact) {
		this.factory = fact;
	}
	protected IASTfactory factory;
	@Override
	public IASTexpression visit(IASTalternative iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return factory.newAlternative(iast.getCondition().accept(this, data), iast.getConsequence().accept(this,data), iast.isTernary()?iast.getAlternant().accept(this,data):null);
	}

	@Override
	public IASTexpression visit(IASTbinaryOperation iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return factory.newBinaryOperation(iast.getOperator(),iast.getLeftOperand().accept(this, data),iast.getRightOperand().accept(this, data));
	}

	@Override
	public IASTexpression visit(IASTblock iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return factory.newBlock(iast.getBindings().clone(), iast.getBody().accept(this, data));
	}

	@Override
	public IASTexpression visit(IASTboolean iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return factory.newBooleanConstant(iast.getDescription());
	}

	@Override
	public IASTexpression visit(IASTfloat iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return factory.newFloatConstant(iast.getDescription());
	}

	@Override
	public IASTexpression visit(IASTinteger iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return factory.newIntegerConstant(iast.getDescription());
	}

	@Override
	public IASTexpression visit(IASTinvocation iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		
		IASTexpression[] arguments = new IASTexpression[iast.getArguments().length];
		IASTexpression[] arg = iast.getArguments();
		for (int i=0; i<iast.getArguments().length;i++) {
			arguments[i] = arg[i].accept(this, data);
		}
		return factory.newInvocation( iast.getFunction().accept(this, data), arguments);
	}

	@Override
	public IASTexpression visit(IASTsequence iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return factory.newSequence(iast.getExpressions().clone());
	}

	@Override
	public IASTexpression visit(IASTstring iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return iast;
	}

	@Override
	public IASTexpression visit(IASTunaryOperation iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return factory.newUnaryOperation(iast.getOperator(), iast.getOperand().accept(this, data));
	}

	@Override
	public IASTexpression visit(IASTvariable iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return iast;
	}

	@Override
	public IASTexpression visit(IASTassignment iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return factory.newAssignment((IASTvariable) iast.getVariable(), iast.getExpression().accept(this, data));
	}

	@Override
	public IASTexpression visit(IASTloop iast, Data data) throws CompilationException {
		return factory.newLoop(iast.getCondition().accept(this, data), iast.getBody().accept(this, data));
	}
	
	// visit program
	public IASTprogram visit(IASTprogram iast, Data data) throws CompilationException{
		IASTfunctionDefinition[] functions = new IASTfunctionDefinition[iast.getFunctionDefinitions().length];
		IASTfunctionDefinition[] fun = iast.getFunctionDefinitions();
		for(int i=0;i<iast.getFunctionDefinitions().length;i++) {
			functions[i] = factory.newFunctionDefinition(fun[i].getFunctionVariable(), fun[i].getVariables().clone(), fun[i].getBody().accept(this, data));
		}
		return factory.newProgram(functions, iast.getBody().accept(this, data));
		
	}
	
}
