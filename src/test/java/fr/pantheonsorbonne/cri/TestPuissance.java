package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPuissance {

	@Test
	void test() {
		Puissance p = new Puissance(new ConstanteN(2), new ConstanteN(3));
		assertEquals("(2^3)",p.toString());
		assertEquals("8",p.simplifier().toString());
		
		Puissance p1 = new Puissance (new ConstanteQ(2, 3), new ConstanteN(3));
		assertEquals("((2/3)^3)",p1.toString());
		assertEquals( "(8/27)",p1.simplifier().toString());
		
		Puissance p2 = new Puissance (new ConstanteQ(2, 3), new ConstanteQ(3, 4));
		assertEquals("((2/3)^(3/4))",p2.toString());
		assertEquals("((2/3)^(3/4))",p2.simplifier().toString());
		
		Puissance p3 = new Puissance (new ConstanteN(2), new ConstanteQ(3, 4));
		assertEquals("(2^(3/4))",p3.toString());
		assertEquals("(2^(3/4))",p3.simplifier().toString());
	}
	
	@Test
	void testDerivation() {
		ConstanteN cst1 = new ConstanteN(3);
		ConstanteN cst2 = new ConstanteN(5);
		
		ConstanteQ cstq = new ConstanteQ(3, 7);
		ConstanteQ cstq1 = new ConstanteQ(5, 3);
		
		VariableInconnue x = new VariableInconnue("x");
		
		ExpressionArithmetique puis1 = new Puissance(x, cst1); // x^3
		ExpressionArithmetique puis4 = new Puissance(x, new ConstanteN(2));
		ExpressionArithmetique puis2 = new Puissance(x, cstq); // x^3/7
		
		ExpressionArithmetique mul = new Multiplication(cst2, x); //5x
		ExpressionArithmetique puis3 = new Puissance(mul, cst1);
		ExpressionArithmetique mul1 = new Multiplication(cstq1, puis3); //5/3 * (5x)^3
		
		assertEquals("(3*(x^2))", puis1.deriver().toString());
		assertEquals("((3/7)*(x^(-4/7)))", puis2.deriver().toString());
		assertEquals("(3*((5*x)^2))", puis3.deriver().toString());
		assertEquals("(5*((5*x)^2))", mul1.deriver().toString());
		assertEquals("(2*x)", puis4.deriver().toString());
	}

}
