package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class testSimplificationNeutre {

	@Test
	void test() {
		VariableInconnue x = new VariableInconnue('x');
		ConstanteN zero = new ConstanteN(0);
		ConstanteN un = new ConstanteN(1);
		ExpressionArithmetique add = new Addition(x, zero);
		ExpressionArithmetique add1 = new Addition(zero, x);
		
		ExpressionArithmetique mul1 = new Multiplication(x, zero);
		ExpressionArithmetique mul2 = new Multiplication(zero, x);
		ExpressionArithmetique mul3 = new Multiplication(x, un);
		ExpressionArithmetique mul4 = new Multiplication(un, x);
		
		ExpressionArithmetique div = new Division(x, un);
		
		ExpressionArithmetique sous = new Soustraction(x, zero);
		
		assertEquals("x", add.simplifier().toString());
		assertEquals("x", add1.simplifier().toString());
		
		assertEquals("0", mul1.simplifier().toString());
		assertEquals("0", mul2.simplifier().toString());
		assertEquals("x", mul3.simplifier().toString());
		assertEquals("x", mul4.simplifier().toString());
		
		assertEquals("x", div.simplifier().toString());
		
		assertEquals("x", sous.simplifier().toString());
		
		
		
		
	}

	
}
