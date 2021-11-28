package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSqrt {

	@Test
	void test() {
		ConstanteN cst1 = new ConstanteN(9);
		ExpressionArithmetique scst1 = new Sqrt(cst1);
		assertEquals("3",scst1.simplifier().toString());
		assertEquals("(sqrt(9))",scst1.toString());
		
		ConstanteN cst2 = new ConstanteN(10);
		ExpressionArithmetique scst2 = new Sqrt(cst2);
		assertEquals("(sqrt(10))",scst2.toString());
		assertEquals("(sqrt(10))",scst2.simplifier().toString());
		
		ConstanteQ cst3 = new ConstanteQ(9,16);
		ExpressionArithmetique scst3 = new Sqrt(cst3);
		assertEquals("(sqrt((9/16)))",scst3.toString());
		assertEquals("(3/4)",scst3.simplifier().toString());
		
		ConstanteQ cst4 = new ConstanteQ(10, 12);
		ExpressionArithmetique scst4 = new Sqrt(cst4);
		assertEquals("(sqrt((10/12)))",scst4.toString());
		assertEquals("(sqrt((5/6)))",scst4.simplifier().toString());
		
		VariableInconnue var = new VariableInconnue("x");
		ExpressionArithmetique svar = new Sqrt(var);
		assertEquals( "(sqrt(x))",svar.toString());
		assertEquals("(sqrt(x))",svar.simplifier().toString());
		
		
	}
	
	@Test
	void testDerivation() {
		ConstanteN cst = new ConstanteN(3);
		ConstanteQ cstq = new ConstanteQ(3, 5);
		VariableInconnue x = new VariableInconnue("x");
		
		ExpressionArithmetique mul = new Multiplication(cst, x);
		
		ExpressionArithmetique sqrt1 = new Sqrt(cst);
		ExpressionArithmetique sqrt2 = new Sqrt(cstq);
		ExpressionArithmetique sqrt3 = new Sqrt(x);
		ExpressionArithmetique sqrt4 = new Sqrt(mul);
		
		assertEquals("0", sqrt1.deriver().toString());
		
		assertEquals("0", sqrt2.deriver().toString());
		
		assertEquals("(1/(2*(sqrt(x))))",sqrt3.deriver().toString());
		
		assertEquals("(3/(2*(sqrt((3*x)))))", sqrt4.deriver().toString());
	}

}

