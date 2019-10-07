package com.paracamplus.ilp1.ilp1tme1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.paracamplus.ilp1.ast.ASTboolean;
import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.ast.ASTfloat;
import com.paracamplus.ilp1.ast.ASTinteger;
import com.paracamplus.ilp1.ilp1tme1.sequence.ASTsequence;
import com.paracamplus.ilp1.ilp1tme1.sequence.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

public class GetAllButLastInstructionsTest {

	@Test
	public void test() throws EvaluationException {
		IASTexpression[] tab = new ASTexpression[3]; 
		tab[0] = new ASTfloat("8.7");
		tab[1] = new ASTboolean("true");
		tab[2] = new ASTinteger("7");
		IASTsequence ast = new ASTsequence(tab);
		IASTexpression[] tab3 = ast.getAllButLastInstructions();
	/**	for(int i =0;i<tab.length-2;i++) {
			assertEquals(tab[i], tab3[i]);
		} **/
		assertEquals(tab[0], tab3[0]);
		assertEquals(tab[1], tab3[1]);
	}

}
