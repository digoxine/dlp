package com.paracamplus.ilp1.ilp1tme2.ex1.comptage;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.paracamplus.ilp1.ilp1tme2.ex1.comptage.ILPMLListener;
import com.paracamplus.ilp1.interfaces.IASTfactory;
import com.paracamplus.ilp1.interfaces.IASTprogram;
import com.paracamplus.ilp1.interfaces.IASTvisitor;
import com.paracamplus.ilp1.parser.ParseException;

import antlr4.ILPMLgrammar1tme2Lexer;
import antlr4.ILPMLgrammar1tme2Parser;

import com.paracamplus.ilp1.ilp1tme2.ex2.CountConstants;
import com.paracamplus.ilp1.interpreter.GlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.OperatorEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
public class ILPMLParser extends com.paracamplus.ilp1.ilp1tme2.ex1.ILPMLParser{

    public ILPMLParser(IASTfactory factory) {
		super(factory);
		// TODO Auto-generated constructor stub
	}

	public IASTprogram getProgram() throws ParseException {
		try {
			ANTLRInputStream in = new ANTLRInputStream(input.getText());
			// flux de caractères -> analyseur lexical
			ILPMLgrammar1tme2Lexer lexer = new ILPMLgrammar1tme2Lexer(in);
			// analyseur lexical -> flux de tokens
			CommonTokenStream tokens =	new CommonTokenStream(lexer);
			// flux tokens -> analyseur syntaxique
			ILPMLgrammar1tme2Parser parser =	new ILPMLgrammar1tme2Parser(tokens);
			// démarage de l'analyse syntaxique
			ILPMLgrammar1tme2Parser.ProgContext tree = parser.prog();	
			//appel du visiteur de CountConstants
			IOperatorEnvironment iop = new OperatorEnvironment();
			IGlobalVariableEnvironment glop= new GlobalVariableEnvironment();
			IASTvisitor vis ;
			vis = new CountConstants(glop,iop);
			tree.accept((ParseTreeVisitor<? extends IASTvisitor>) vis);
			// parcours de l'arbre syntaxique et appels du Listener
			ParseTreeWalker walker = new ParseTreeWalker();
			ILPMLListener extractor = new com.paracamplus.ilp1.ilp1tme2.ex1.comptage.ILPMLListener(factory);
			walker.walk(extractor, tree);	
			return tree.node;
		} catch (Exception e) {
			throw new ParseException(e);
		}
    }
}
