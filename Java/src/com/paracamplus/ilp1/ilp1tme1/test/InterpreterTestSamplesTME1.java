package com.paracamplus.ilp1.ilp1tme1.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.paracamplus.ilp1.ilp1tme1.interpreter.FileInterpreter;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.test.InterpreterRunner;
import com.paracamplus.ilp1.interpreter.test.InterpreterTest;
import com.paracamplus.ilp1.parser.ParseException;

@RunWith(Parameterized.class)
public class InterpreterTestSamplesTME1 extends InterpreterTest {

	protected static String[] samplesDirName = { "SamplesTME1" }; 
    protected static String pattern = ".*";
    
	public InterpreterTestSamplesTME1(File file) {
		super(file);
		// TODO Auto-generated constructor stub
	}
	 
    @Parameters(name = "{0}")
    public static Collection<File[]> data() throws Exception {
    	return InterpreterRunner.getFileList(samplesDirName, pattern);
    } 
}
