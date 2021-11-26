package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class testProduit {
	
	@Test
	void test1() {
		ExpressionArithmetique index = new VariableInconnue('i');
		VariableIndex alphai = new VariableIndex('α', index);

		ExpressionArithmetique x = new VariableInconnue('x');
		ExpressionArithmetique pow = new Puissance(x, index);

		ExpressionArithmetique multi = new Multiplication(alphai, pow);
		ExpressionArithmetique produit = new Produit(multi, 0, 4);
		assertEquals("((((((1+x)*(α0*(x^0)))*(α1*(x^1)))*(α2*(x^2)))*(α3*(x^3)))*(α4*(x^4)))", produit.simplifier().toString());
	}
	


}

