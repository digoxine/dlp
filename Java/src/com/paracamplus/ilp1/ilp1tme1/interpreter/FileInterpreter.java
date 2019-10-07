package com.paracamplus.ilp1.ilp1tme1.interpreter;

import java.io.File;
import java.io.IOException;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.test.InterpreterTest;
import com.paracamplus.ilp1.parser.ParseException;

public class FileInterpreter extends InterpreterTest {

	public FileInterpreter(File file) {
		super(file);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f2 = new File(args[0]);
		FileInterpreter f = new FileInterpreter(f2);
		try {
			f.processFile();
		} catch (ParseException | IOException | EvaluationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
