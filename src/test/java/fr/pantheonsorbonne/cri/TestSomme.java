package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSomme {

	@Test
	void test1() {
		ConstanteN cst = new ConstanteN(1);
		VariableInconnue x = new VariableInconnue("x");
		ExpressionArithmetique index = new VariableInconnue("i");
		VariableIndex alphai = new VariableIndex("α", index);
		
		ExpressionArithmetique pow = new Puissance(x, index);
		ExpressionArithmetique multi = new Multiplication(alphai, pow);
		ExpressionArithmetique somme = new Somme(multi, 0, 4);
		
		ExpressionArithmetique add = new Addition(cst, x);
		ExpressionArithmetique ex = new Addition(add, somme);
		
		assertEquals("((1+x)+(((((0+α0)+(α1*x))+(α2*(x^2)))+(α3*(x^3)))+(α4*(x^4))))", ex.simplifier().toString());
	

		VariableInconnue i = new VariableInconnue("i");
		VariableIndex alphai1 = new VariableIndex(null, i);
		
		ExpressionArithmetique somm = new Somme(alphai1, 2, 100);
		assertEquals("5049", somm.simplifier().toString());
	}
}
