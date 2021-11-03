package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testSqrt {

	@Test
	void test() {
		ConstanteN cst1 = new ConstanteN(9);
		ExpressionArithmetique scst1 = new Sqrt(cst1);
		assertEquals(scst1.simplifier().toString(), "3");
		assertEquals(scst1.toString(),"(sqrt(9))");
		
		ConstanteN cst2 = new ConstanteN(10);
		ExpressionArithmetique scst2 = new Sqrt(cst2);
		assertEquals(scst2.toString(), "(sqrt(10))");
		assertEquals(scst2.simplifier().toString(), "(sqrt(10))");
		
		ConstanteQ cst3 = new ConstanteQ(9,16);
		ExpressionArithmetique scst3 = new Sqrt(cst3);
		assertEquals(scst3.toString(), "(sqrt((9/16)))");
		assertEquals(scst3.simplifier().toString(), "(3/4)");
		
		ConstanteQ cst4 = new ConstanteQ(10, 12);
		ExpressionArithmetique scst4 = new Sqrt(cst4);
		assertEquals(scst4.toString(), "(sqrt((10/12)))");
		assertEquals(scst4.simplifier().toString(), "(sqrt((5/6)))");
		
		VariableInconnue var = new VariableInconnue('x');
		ExpressionArithmetique svar = new Sqrt(var);
		assertEquals(svar.toString(), "(sqrt(x))");
		assertEquals(svar.simplifier().toString(), "(sqrt(x))");
		
		
	}

}

