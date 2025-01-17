package com.paracamplus.ilp2.ilp2tme4.solution3;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.paracamplus.ilp1.parser.ParseException;
import com.paracamplus.ilp2.ilp2tme4.solution3.interfaces.IASTfactory;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp2.ast.ASTprogram;
import com.paracamplus.ilp2.ilp2tme4.solution3.ILPMLListener;
import antlr4.ILPMLGrammar2tme4Lexer;
import antlr4.ILPMLGrammar2tme4Parser;

public class ILPMLParser extends com.paracamplus.ilp2.parser.ilpml.ILPMLParser {

	public ILPMLParser(IASTfactory factory) {
		super(factory);
		// TODO Auto-generated constructor stub
	}
	@Override
    public IASTprogram getProgram() throws ParseException {
		try {
			ANTLRInputStream in = new ANTLRInputStream(input.getText());
			// flux de caractères -> analyseur lexical
			ILPMLGrammar2tme4Lexer lexer = new ILPMLGrammar2tme4Lexer(in);
			// analyseur lexical -> flux de tokens
			CommonTokenStream tokens =	new CommonTokenStream(lexer);
			// flux tokens -> analyseur syntaxique
			ILPMLGrammar2tme4Parser parser = new ILPMLGrammar2tme4Parser(tokens);
			// démarage de l'analyse syntaxique
			ILPMLGrammar2tme4Parser.ProgContext tree = parser.prog();		
			// parcours de l'arbre syntaxique et appels du Listener
			ParseTreeWalker walker = new ParseTreeWalker();
						
			ILPMLListener extractor = new ILPMLListener((IASTfactory) factory);
			//tree.node.getBody().accept(elem1, null);

			walker.walk(extractor,tree);
			return tree.node;
			//return new ASTprogram(tree.node.getFunctionDefinitions(),tree.node.getBody().accept(elem1, null));

		} catch (Exception e) {
			throw new ParseException(e);
		}

	}
}