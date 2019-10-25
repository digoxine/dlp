package com.paracamplus.ilp2.ilp2tme5.sanslabel.compiler;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Set;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.NoDestination;
import com.paracamplus.ilp1.compiler.interfaces.IASTCglobalVariable;
import com.paracamplus.ilp1.compiler.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.compiler.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp2.ilp2tme5.sanslabel.compiler.FreeVariableCollector;
import com.paracamplus.ilp2.ilp2tme5.sanslabel.compiler.GlobalVariableCollector;
import com.paracamplus.ilp2.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp2.ilp2tme5.sanslabel.compiler.interfaces.IASTCvisitor;
import com.paracamplus.ilp2.ilp2tme5.sanslabel.compiler.normalizer.INormalizationFactory;
import com.paracamplus.ilp2.ilp2tme5.sanslabel.compiler.normalizer.NormalizationFactory;
import com.paracamplus.ilp2.ilp2tme5.sanslabel.interfaces.IASTbreak;
import com.paracamplus.ilp2.ilp2tme5.sanslabel.interfaces.IASTcontinue;

public class Compiler extends com.paracamplus.ilp2.compiler.Compiler implements IASTCvisitor<Void, Compiler.Context, CompilationException> {

	public Compiler(IOperatorEnvironment ioe, IGlobalVariableEnvironment igve) {
		super(ioe, igve);
		// TODO Auto-generated constructor stub
	}

	public IASTCprogram normalize(IASTprogram program) throws CompilationException{
		INormalizationFactory nf = new NormalizationFactory();
		com.paracamplus.ilp2.ilp2tme5.sanslabel.compiler.normalizer.Normalizer normalizer = new com.paracamplus.ilp2.ilp2tme5.sanslabel.compiler.normalizer.Normalizer(nf);
		IASTCprogram newprogram = normalizer.transform(program);
		return newprogram;
		
	}
    public String compile(IASTprogram program) 
            throws CompilationException {
        
        IASTCprogram newprogram = normalize(program);
        newprogram = ((IASTCprogram) optimizer.transform(newprogram));

        GlobalVariableCollector gvc = new GlobalVariableCollector();
        Set<IASTCglobalVariable> gvs = gvc.analyze(newprogram);
        newprogram.setGlobalVariables(gvs);
        
        FreeVariableCollector fvc = new FreeVariableCollector(newprogram);
        newprogram = (fvc.analyze());
      
        Context context = new Context(NoDestination.NO_DESTINATION);
        StringWriter sw = new StringWriter();
        try {
            out = new BufferedWriter(sw);
            visit(newprogram, context);
            out.flush();
        } catch (IOException exc) {
            throw new CompilationException(exc);
        }
        return sw.toString();
    }

	@Override
	public Void visit(IASTbreak iast, Context data) throws CompilationException {
		// TODO Auto-generated method stub
		emit("break;\n");
		return null;
	}

	@Override
	public Void visit(IASTcontinue iast, Context data) throws CompilationException {
		// TODO Auto-generated method stub
		emit("continue;\n");
		
		return null;
	}

}
