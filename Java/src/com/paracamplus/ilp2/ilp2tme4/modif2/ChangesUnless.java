package com.paracamplus.ilp2.ilp2tme4.modif2;

import com.paracamplus.ilp1.ast.ASTalternative;
import com.paracamplus.ilp1.ast.ASTbinaryOperation;
import com.paracamplus.ilp1.ast.ASTblock;
import com.paracamplus.ilp1.ast.ASTboolean;
import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.ast.ASTfloat;
import com.paracamplus.ilp1.ast.ASTinteger;
import com.paracamplus.ilp1.ast.ASTinvocation;
import com.paracamplus.ilp1.ast.ASToperator;
import com.paracamplus.ilp1.ast.ASTsequence;
import com.paracamplus.ilp1.ast.ASTstring;
import com.paracamplus.ilp1.ast.ASTunaryOperation;
import com.paracamplus.ilp1.ast.ASTvariable;
import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTbinaryOperation;
import com.paracamplus.ilp1.interfaces.IASTboolean;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfloat;
import com.paracamplus.ilp1.interfaces.IASTinteger;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTstring;
import com.paracamplus.ilp1.interfaces.IASTunaryOperation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp2.ast.ASTassignment;
import com.paracamplus.ilp2.ast.ASTloop;
import com.paracamplus.ilp2.ilp2tme4.modif2.interfaces.IASTunless;
import com.paracamplus.ilp2.ilp2tme4.modif2.interfaces.IASTvisitor;
import com.paracamplus.ilp2.interfaces.IASTassignment;
import com.paracamplus.ilp2.interfaces.IASTloop;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;

public class ChangesUnless implements IASTvisitor<IASTexpression, Void ,EvaluationException> {

	@Override
	public IASTexpression visit(IASTassignment iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return new ASTassignment(iast.getVariable(),iast.getExpression().accept(this, data));
	}

	@Override
	public IASTexpression visit(IASTloop iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return new ASTloop(iast.getCondition(),iast.getBody().accept(this, data));
	}

	@Override
	public IASTexpression visit(IASTalternative iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return new ASTalternative(iast.getCondition(),iast.getConsequence().accept(this, data),iast.getAlternant().accept(this, data));
	}

	@Override
	public IASTexpression visit(IASTbinaryOperation iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return new ASTbinaryOperation(iast.getOperator(), iast.getLeftOperand().accept(this, data), iast.getRightOperand().accept(this, data));
	}

	@Override
	public IASTexpression visit(IASTblock iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		IASTbinding[] bindings = new IASTbinding [iast.getBindings().length];
		int i=0;
		for(IASTbinding elem : iast.getBindings()) {
			bindings[i] = new ASTblock.ASTbinding(elem.getVariable(),elem.getInitialisation().accept(this, data));
			i++;
			
		}
		return new ASTblock(bindings,iast.getBody().accept(this, data));
	}

	@Override
	public IASTexpression visit(IASTboolean iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return new ASTboolean(iast.getDescription());
	}

	@Override
	public IASTexpression visit(IASTfloat iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return new ASTfloat(iast.getDescription());
	}

	@Override
	public IASTexpression visit(IASTinteger iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return new ASTinteger(iast.getDescription());
	}

	@Override
	public IASTexpression visit(IASTinvocation iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return new ASTinvocation(iast.getFunction().accept(this, data),iast.getArguments());
	}

	@Override
	public IASTexpression visit(IASTsequence iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		IASTexpression [] expressions = new ASTexpression[iast.getExpressions().length];
		int i=0;
		for(IASTexpression elem : iast.getExpressions()) {
			expressions[i]=elem.accept(this, data);
			i++;
		}
		return new ASTsequence(expressions);
	}

	@Override
	public IASTexpression visit(IASTstring iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return new ASTstring(iast.getDescription());
	}

	@Override
	public IASTexpression visit(IASTunaryOperation iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return new ASTunaryOperation(iast.getOperator(),iast.getOperand().accept(this, data));
	}

	@Override
	public IASTexpression visit(IASTvariable iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return new ASTvariable(iast.getName());
	}

	@Override
	public IASTexpression visit(IASTunless iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return new ASTalternative(new ASTunaryOperation(new ASToperator("!"),iast.getCondition()),iast.getBody().accept(this, data),null);
	}

		
}
