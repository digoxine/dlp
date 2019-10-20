package com.paracamplus.ilp2.ilp2tme4.solution3;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.parser.ParseException;
import com.paracamplus.ilp2.ilp2tme4.solution3.interfaces.IASTfactory;

import java.io.File;
import java.io.StringReader;
import java.util.List;
import java.util.Vector;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import com.paracamplus.ilp1.interfaces.IAST;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp1.interfaces.IASToperator;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.tools.Input;
import com.thaiopensource.validate.ValidationDriver;
public class XMLParser extends com.paracamplus.ilp2.parser.xml.XMLParser {

	public XMLParser(IASTfactory factory) {
		super(factory);
		// TODO Auto-generated constructor stub
		addMethod("unless",XMLParser.class);
	}
	
	public IASTexpression unless(Element e) throws ParseException{
		IAST iastc = findThenParseChildContent(e, "condition");
		IASTexpression condition = narrowToIASTexpression(iastc);
		IASTexpression[] iaste = findThenParseChildAsExpressions(e,"body");
		IASTexpression body = getFactory().newSequence(iaste);
		return ((IASTfactory) getFactory()).newUnless(body,condition);
		
	}
	
}
