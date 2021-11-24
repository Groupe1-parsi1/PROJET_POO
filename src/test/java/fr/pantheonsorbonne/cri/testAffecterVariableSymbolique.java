package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class testAffecterVariableSymbolique {

	@Test
	void test1() {
		ConstanteN cst1 = new ConstanteN(3);
		ConstanteN cst2 = new ConstanteN(7);
		VariableInconnue x = new VariableInconnue("x");
		
		ExpressionArithmetique ex = new Addition(cst1, x);
		
		x.setValeur(cst2);
		assertEquals("10", ex.simplifier().toString());
	}
	
	@Test
	void test1a() {
		ConstanteQ cst1 = new ConstanteQ(5, 9);
		ConstanteQ cst2 = new ConstanteQ(2, 9);
		VariableInconnue a = new VariableInconnue("a");
		VariableInconnue x = new VariableInconnue("x");
		
		assertEquals("a", a.toString());
		
		ExpressionArithmetique ex = new Soustraction(cst1, a);
		ExpressionArithmetique ex1 = new Addition(x, ex);
		
		x.setValeur(cst2);
		assertEquals("((2/9)+((5/9)-a))",ex1.simplifier().toString());
	}
	
	@Test
	void test2() {
		ConstanteN cst1 = new ConstanteN(5);
	
		VariableInconnue x = new VariableInconnue("x");
		
		ExpressionArithmetique ex = new Addition(cst1, x);
		
		x.setValeur(null);
		assertEquals("(5+x)", ex.simplifier().toString());
	}
		

}
