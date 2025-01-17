package com.paracamplus.ilp2.ilp2tme5.sanslabel.interpreter;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp2.ilp2tme5.sanslabel.interfaces.IASTbreak;
import com.paracamplus.ilp2.ilp2tme5.sanslabel.interfaces.IASTcontinue;
import com.paracamplus.ilp2.ilp2tme5.sanslabel.interfaces.IASTvisitor;
import com.paracamplus.ilp2.interfaces.IASTloop;

public class Interpreter extends com.paracamplus.ilp2.interpreter.Interpreter
		implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {

	public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment, IOperatorEnvironment operatorEnvironment) {
		super(globalVariableEnvironment, operatorEnvironment);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object visit(IASTbreak iast, ILexicalEnvironment data) 
			throws EvaluationException {
		throw new BreakException("break");
		
	}

	@Override
	public Object visit(IASTcontinue iast, ILexicalEnvironment data) throws EvaluationException {
		// TODO Auto-generated method stub
		throw new ContinueException("continue");
	}


    
    @Override
	public Object visit(IASTloop iast, ILexicalEnvironment lexenv) 
            throws EvaluationException {
        while ( true ) {
            Object condition = iast.getCondition().accept(this, lexenv);
            if ( condition instanceof Boolean ) {
                Boolean c = (Boolean) condition;
                if ( ! c ) {
                    break;
                }
            }
            try {
            	iast.getBody().accept(this, lexenv);
            }
            catch(BreakException e) {
            	//Quelque chose s'est mal passé dans le corps 
            	//On arrête l'évalution du corps
            	//On sort donc de la boucle
            	return Boolean.FALSE;
            }
            catch(ContinueException ex){
            	//Quelque chose s
            	continue;
            }
        }
        return Boolean.FALSE;
    }
}
