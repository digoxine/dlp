package com.paracamplus.ilp2.ilp2tme3.vecteurs.interpreter;

import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;


import org.stringtemplate.v4.compiler.STParser.compoundElement_return;

import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.primitive.Newline;
import com.paracamplus.ilp1.interpreter.primitive.Print;
import com.paracamplus.ilp2.ilp2tme3.interpreter.Primitive.Sinus;
import com.paracamplus.ilp2.ilp2tme3.vecteurs.interpreter.primitive.makeVector;
import com.paracamplus.ilp2.ilp2tme3.vecteurs.interpreter.primitive.vectorGet;
import com.paracamplus.ilp2.ilp2tme3.vecteurs.interpreter.primitive.vectorLength;

public class GlobalVariableStuff extends com.paracamplus.ilp2.ilp2tme3.interpreter.GlobalVariableStuff{
	public static void fillGlobalVariables (
            IGlobalVariableEnvironment env,
            Writer out ) {
        env.addGlobalVariableValue("pi", new BigDecimal("3.1415926535"));
        env.addGlobalVariableValue(new Print(out));
        env.addGlobalVariableValue(new Newline(out));
        env.addGlobalVariableValue(new Sinus());
        env.addGlobalVariableValue(new makeVector<BigInteger>());
        env.addGlobalVariableValue(new makeVector<BigDecimal>());
        env.addGlobalVariableValue(new vectorGet<BigInteger>());
        env.addGlobalVariableValue(new vectorGet<BigDecimal>());
        env.addGlobalVariableValue(new vectorLength<BigInteger>());
        env.addGlobalVariableValue(new vectorLength<BigDecimal>());
    }
}
