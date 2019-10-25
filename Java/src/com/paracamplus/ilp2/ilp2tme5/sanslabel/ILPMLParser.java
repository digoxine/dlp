package com.paracamplus.ilp2.ilp2tme5.sanslabel;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.paracamplus.ilp1.parser.ParseException;
import com.paracamplus.ilp2.ilp2tme5.sanslabel.interfaces.IASTfactory;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import antlr4.ILPMLgrammar2tme5Lexer;
import antlr4.ILPMLgrammar2tme5Parser;

public class ILPMLParser extends com.paracamplus.ilp2.parser.ilpml.ILPMLParser {

	public ILPMLParser(IASTfactory factory) {
		super(factory);
		// TODO Auto-generated constructor stub
	}

	public IASTprogram getProgram() throws ParseException{
		try {
			ANTLRInputStream in = new ANTLRInputStream(input.getText());
			ILPMLgrammar2tme5Lexer lexer = new ILPMLgrammar2tme5Lexer(in);
			CommonTokenStream tokens =	new CommonTokenStream(lexer);
			ILPMLgrammar2tme5Parser parser = new ILPMLgrammar2tme5Parser(tokens);
			ILPMLgrammar2tme5Parser.ProgContext tree = parser.prog();
			ParseTreeWalker walker = new ParseTreeWalker();
			ILPMLListener extractor = new ILPMLListener((IASTfactory) factory);
			walker.walk(extractor,tree);
			return tree.node;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		
	}
}
