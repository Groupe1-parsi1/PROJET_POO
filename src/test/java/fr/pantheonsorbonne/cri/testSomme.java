package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class testSomme {

	@Test
	void test1() {
		ExpressionArithmetique index = new VariableInconnue('i');
		VariableIndex alphai = new VariableIndex('α', index);

		ExpressionArithmetique x = new VariableInconnue('x');
		ExpressionArithmetique pow = new Puissance(x, index);

		ExpressionArithmetique multi = new Multiplication(alphai, pow);
		ExpressionArithmetique somme = new Somme(multi, 0, 4);
		System.out.println(somme.toString());
//		assertEquals("(α0 + (α1 * x) + (α2 * (x^2)) + (α3 * (x^3)) + (α4 * (x^4)))", somme.simplifier().toString());
	}
}
