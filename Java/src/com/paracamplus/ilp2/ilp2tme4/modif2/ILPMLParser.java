package com.paracamplus.ilp2.ilp2tme4.modif2;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.parser.ParseException;
import com.paracamplus.ilp2.ilp2tme4.modif2.interfaces.IASTfactory;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp2.ast.ASTfunctionDefinition;
import com.paracamplus.ilp2.ast.ASTprogram;
import com.paracamplus.ilp2.ilp2tme4.modif2.ILPMLListener;
import antlr4.ILPMLGrammar2tme4Lexer;
import antlr4.ILPMLGrammar2tme4Parser;
import com.paracamplus.ilp2.ilp2tme4.modif2.interfaces.IASTvisitor;

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
			
			//ICI
			
			
			IASTvisitor<IASTexpression, Void, EvaluationException> elem1 = new ChangesUnless();
			//tree.node.getBody().accept(elem1, null);
			
			
			//Fin 
			
			
			ILPMLListener extractor = new ILPMLListener((IASTfactory) factory);

			walker.walk(extractor,tree);
	
			return new ASTprogram(tree.node.getFunctionDefinitions(),tree.node.getBody().accept(elem1, null));


			//return tree.node;
		} catch (Exception e) {
			throw new ParseException(e);
		}

	}
}