package com.paracamplus.ilp2.ilp2tme4.solution3.compiler.normalizer;
import com.paracamplus.ilp1.interfaces.IASTexpression;

public interface INormalizationFactory extends com.paracamplus.ilp2.compiler.normalizer.INormalizationFactory {
	IASTexpression newUnless(IASTexpression condition, IASTexpression body);
}
