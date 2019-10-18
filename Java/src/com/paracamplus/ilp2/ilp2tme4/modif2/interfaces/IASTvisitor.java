package com.paracamplus.ilp2.ilp2tme4.modif2.interfaces;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

public interface IASTvisitor<Result, Data, Anomaly extends Throwable> extends com.paracamplus.ilp2.interfaces.IASTvisitor<Result, Data, EvaluationException> {
	Result visit(IASTunless iast, Data data) throws Anomaly;
}
