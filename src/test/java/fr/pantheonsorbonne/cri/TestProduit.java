package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

 class TestProduit {

	@Test
	void test1() {
		ConstanteN cst = new ConstanteN(1);
		VariableInconnue x = new VariableInconnue("x");
		ExpressionArithmetique index = new VariableInconnue("i");
		VariableIndex alphai = new VariableIndex("α", index);
		
		ExpressionArithmetique pow = new Puissance(x, index);
		ExpressionArithmetique multi = new Multiplication(alphai, pow);
		ExpressionArithmetique somme = new Produit(multi, 0, 4);
		
		ExpressionArithmetique add = new Addition(cst, x);
		ExpressionArithmetique ex = new Addition(add, somme);
		
		assertEquals("((1+x)+(((((1*α0)*(α1*x))*(α2*(x^2)))*(α3*(x^3)))*(α4*(x^4))))", ex.simplifier().toString());
		
		VariableInconnue i = new VariableInconnue("i");
		VariableIndex alphai1 = new VariableIndex(null, i);
		
		ExpressionArithmetique somm = new Produit(alphai1, 1, 5);
		assertEquals("120", somm.simplifier().toString());
	
	}
}