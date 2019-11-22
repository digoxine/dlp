package com.paracamplus.ilp2.ilp2tme6.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import com.paracamplus.ilp1.interfaces.IASTexpression;

import com.paracamplus.ilp1.parser.ParseException;
import com.paracamplus.ilp2.ast.ASTprogram;
import com.paracamplus.ilp2.ilp2tme6.CopyTransform;
import com.paracamplus.ilp2.ilp2tme6.renommage.RenameTransform;
import com.paracamplus.ilp2.interfaces.IASTfactory;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp2.interfaces.IASTvisitor;
import com.paracamplus.ilp2.parser.ilpml.ILPMLListener;
import com.paracamplus.ilp2.parser.ilpml.ILPMLParser;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

import antlr4.ILPMLgrammar2Lexer;
import antlr4.ILPMLgrammar2Parser;

public class ILPMLOptimizingParser extends ILPMLParser {

	public ILPMLOptimizingParser(IASTfactory factory) {
		super(factory);
		// TODO Auto-generated constructor stub
	}
	
	public IASTprogram getProgram() throws ParseException {
		try {
			IASTprogram program = super.getProgram();

			RenameTransform visitor1 = new RenameTransform((IASTfactory) factory);
			
			program = visitor1.visit(program, null);
			return program;
			
		} catch (Exception e) {
			throw new ParseException(e);
		}
	}

}
