/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.ilp2tme4.solution3.compiler;


import com.paracamplus.ilp1.compiler.AssignDestination;
import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.compiler.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp2.ilp2tme4.solution3.compiler.interfaces.IASTCvisitor;
import com.paracamplus.ilp2.ilp2tme4.solution3.interfaces.IASTunless;
import com.paracamplus.ilp1.interfaces.IASTvariable;


public class Compiler extends com.paracamplus.ilp2.compiler.Compiler
implements IASTCvisitor<Void, Compiler.Context, CompilationException>{
    
 
    public Compiler(IOperatorEnvironment ioe, IGlobalVariableEnvironment igve) {
		super(ioe, igve);
	}
    public Void visit(IASTunless iast, Context context) throws CompilationException{
    	IASTvariable tmp1 = context.newTemporaryVariable();
        emit("{ \n");
        emit("  ILP_Object " + tmp1.getMangledName() + ";1 \n");
        System.out.println("dans le visit compiler");
        Context c = context.redirect(new AssignDestination(tmp1));
        iast.getCondition().accept(this, c);
        emit("  if ( ILP_isEquivalentToFalse(");
        emit(tmp1.getMangledName());
        emit(" ) ) {\n");
        iast.getBody().accept(this, context);
    
        emit("\n  }\n}\n");
        return null;
    }
	@Override
	public Void visit(com.paracamplus.ilp2.ilp2tme4.solution3.compiler.interfaces.IASTunless iast, Context data)
			throws CompilationException {
    	IASTvariable tmp1 = context.newTemporaryVariable();
        emit("{ \n");
        emit("  ILP_Object " + tmp1.getMangledName() + ";1 \n");
        System.out.println("dans le visit compiler");
        Context c = context.redirect(new AssignDestination(tmp1));
        iast.getCondition().accept(this, c);
        emit("  if ( ILP_isEquivalentToFalse(");
        emit(tmp1.getMangledName());
        emit(" ) ) {\n");
        iast.getBody().accept(this, context);
    
        emit("\n  }\n}\n");
        return null;
	}
}
    //
