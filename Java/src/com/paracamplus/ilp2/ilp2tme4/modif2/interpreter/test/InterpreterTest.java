package com.paracamplus.ilp2.ilp2tme4.modif2.interpreter.test;

import java.io.File;
import java.io.StringWriter;
import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import com.paracamplus.ilp1.interpreter.GlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.OperatorEnvironment;
import com.paracamplus.ilp1.interpreter.OperatorStuff;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp1.interpreter.test.InterpreterRunner;
import com.paracamplus.ilp1.parser.xml.IXMLParser;
import com.paracamplus.ilp2.ilp2tme4.modif2.ast.ASTfactory;
import com.paracamplus.ilp2.ilp2tme4.modif2.interfaces.IASTfactory;
import com.paracamplus.ilp2.ilp2tme3.vecteurs.interpreter.GlobalVariableStuff;
import com.paracamplus.ilp2.interpreter.Interpreter;
import com.paracamplus.ilp2.ilp2tme4.modif2.ILPMLParser;
import com.paracamplus.ilp2.parser.xml.XMLParser;

public class InterpreterTest extends com.paracamplus.ilp2.ilp2tme3.vecteurs.interpreter.test.InterpreterTest {
    public InterpreterTest(File file) {
		super(file);
	}


	protected static String[] samplesDirName = { "SamplesTME3","SamplesTME4"};
	 
    protected static String pattern = ".*";
    
    public void configureRunner(InterpreterRunner run) throws EvaluationException {
    	// configuration du parseur
        IASTfactory factory = new ASTfactory();
        IXMLParser xmlparser = new XMLParser(factory);
        xmlparser.setGrammar(new File(XMLgrammarFile));
        run.setXMLParser(xmlparser);
        run.setILPMLParser(new ILPMLParser(factory));

        // configuration de l'interprète
        StringWriter stdout = new StringWriter();
        run.setStdout(stdout);
        IGlobalVariableEnvironment gve = new GlobalVariableEnvironment();
        GlobalVariableStuff.fillGlobalVariables(gve, stdout);
        IOperatorEnvironment oe = new OperatorEnvironment();
        OperatorStuff.fillUnaryOperators(oe);
        OperatorStuff.fillBinaryOperators(oe);
        Interpreter interpreter = new Interpreter(gve, oe);        
        run.setInterpreter(interpreter);
    }

    @Parameters(name = "{0}")
    public static Collection<File[]> data() throws Exception {
    	return InterpreterRunner.getFileList(samplesDirName, pattern);
    }   
}
