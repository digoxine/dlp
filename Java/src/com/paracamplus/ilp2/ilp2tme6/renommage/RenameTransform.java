package com.paracamplus.ilp2.ilp2tme6.renommage;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.normalizer.INormalizationEnvironment;
import com.paracamplus.ilp1.compiler.normalizer.NoSuchLocalVariableException;
import com.paracamplus.ilp1.compiler.normalizer.NormalizationEnvironment;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp2.ilp2tme6.CopyTransform;
import com.paracamplus.ilp2.interfaces.IASTfactory;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTprogram;

public class RenameTransform extends CopyTransform<INormalizationEnvironment> {
	public RenameTransform(IASTfactory fact) {
		super(fact);
		// TODO Auto-generated constructor stub
	}

	private static int cpt =0;
	
	@Override
	public IASTexpression visit(IASTvariable iast, INormalizationEnvironment data ) throws CompilationException{
		try {
			return data.renaming(iast);
		} catch(NoSuchLocalVariableException e) {
			return iast;
		}
	}	
	
	@Override
	public IASTexpression visit(IASTblock iast, INormalizationEnvironment data) throws CompilationException {
		INormalizationEnvironment newEnv = data;
		IASTbinding[] bin = iast.getBindings();
		IASTbinding[] res = new IASTbinding[iast.getBindings().length];
		for (int i =0; i<bin.length;i++) {
			IASTvariable newv = factory.newVariable(bin[i].getVariable().getMangledName()+"_"+cpt++);
			res[i] = factory.newBinding(newv, 
					bin[i].getInitialisation().accept(this, data));
			newEnv = newEnv.extend(bin[i].getVariable(), newv);
		}
		return factory.newBlock(res, iast.getBody().accept(this, newEnv));
	}
	
	public IASTprogram visit(IASTprogram iast, INormalizationEnvironment data) throws CompilationException{
		IASTfunctionDefinition[] functions = new IASTfunctionDefinition[iast.getFunctionDefinitions().length];
		IASTfunctionDefinition[] fun = iast.getFunctionDefinitions();
		for(int i=0;i<iast.getFunctionDefinitions().length;i++) {
			INormalizationEnvironment localEnv = data;
			// Créer un nouveaux tableau des variables (paramètres) de la fonction
			IASTvariable[] oldVars = fun[i].getVariables();
			IASTvariable[] newVars = new IASTvariable[oldVars.length];
			for (int j=0 ; j<oldVars.length;j++) {
				//Pour chacun de mes arguments je donne a mes arguments le contexte precedent
				//mais en plus de ca je mets a jour le nouvel environnement
				
				newVars[j] = factory.newVariable(oldVars[j].getMangledName()+"_"+cpt++);
				localEnv = localEnv.extend(oldVars[j], newVars[j]);
				
			}
			//On parcourt récursivement la fonction 
			functions[i] = factory.newFunctionDefinition(fun[i].getFunctionVariable(), newVars, fun[i].getBody().accept(this, localEnv));
			// Itérer sur les variables de la fonction
			  // - créer une nouvelle variable
			  // - stocker nouvelle variable dans l'environment
			  // - stocker nouvelle variable dans le nouveau tableau de variables
			
			functions[i] = factory.newFunctionDefinition(fun[i].getFunctionVariable(), fun[i].getVariables(), fun[i].getBody().accept(this, data));
			
		}
		assert(data == NormalizationEnvironment.EMPTY);
		return factory.newProgram(functions, iast.getBody().accept(this, data));
	}
}