package com.paracamplus.ilp1.ilp1tme2.ex1.comptage;

import com.paracamplus.ilp1.interfaces.IASTfactory;

import antlr4.ILPMLgrammar1tme2Parser.AlternativeContext;
import antlr4.ILPMLgrammar1tme2Parser.BinaryContext;
import antlr4.ILPMLgrammar1tme2Parser.BindingContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstFalseContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstFloatContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstIntegerContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstStringContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstTrueContext;
import antlr4.ILPMLgrammar1tme2Parser.InvocationContext;
import antlr4.ILPMLgrammar1tme2Parser.ProgContext;
import antlr4.ILPMLgrammar1tme2Parser.SequenceContext;
import antlr4.ILPMLgrammar1tme2Parser.UnaryContext;
import antlr4.ILPMLgrammar1tme2Parser.VariableContext;

public class ILPMLListener extends com.paracamplus.ilp1.ilp1tme2.ex1.ILPMLListener	 {

	private static int nbconst = 0;
	public ILPMLListener(IASTfactory factory) {
		super(factory);
		
		
		// TODO Auto-generated constructor stub
	}
	@Override	public void enterConstInteger(ConstIntegerContext ctx) {nbconst++;System.out.println("nb constante :"+nbconst);}
	@Override	public void enterConstFloat(ConstFloatContext ctx) {nbconst++;System.out.println("nb constante :"+nbconst);}
	@Override	public void enterConstFalse(ConstFalseContext ctx) {nbconst++;System.out.println("nb constante :"+nbconst);}
	@Override	public void enterConstTrue(ConstTrueContext ctx) {nbconst++;System.out.println("nb constante :"+nbconst);}
	@Override	public void enterConstString(ConstStringContext ctx) {nbconst++;System.out.println("nb constante :"+nbconst);}
}
