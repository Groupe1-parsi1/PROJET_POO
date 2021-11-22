package fr.pantheonsorbonne.cri;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class testExponentielle {

	@Test
	void test() { 
		
		ExpressionArithmetique expZero = new Exponentielle(new ConstanteN(0));
		assertEquals("(exp(0))",expZero.toString());
		assertEquals("1",expZero.simplifier().toString());
		
		ExpressionArithmetique expO = new Exponentielle(new ConstanteQ(2, 4));
		assertEquals("(exp((2/4)))",expO.toString());
		assertEquals("(exp((1/2)))",expO.simplifier().toString());
	}
	
	@Test
	void testDerivation() {
		VariableInconnue x = new VariableInconnue('x');
		ConstanteQ cstq = new ConstanteQ(3, 5);
		
		ExpressionArithmetique ex1 = new Multiplication(cstq, x);
		
		ExpressionArithmetique ex = new Exponentielle(x);
		ExpressionArithmetique ex3 = new Exponentielle(ex1);
		
		assertEquals("(exp(x))", ex.deriver().toString());
		assertEquals("((3/5)*(exp(((3/5)*x))))", ex3.deriver().toString());
	}

}
