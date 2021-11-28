package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class TestDistributivite {
	@Test
	void test() {
			
			ConstanteN un = new ConstanteN(1);// 1
			ConstanteN deux = new ConstanteN(2);// 2
			VariableInconnue x = new VariableInconnue("x"); // x
			ConstanteQ unDemi = new ConstanteQ(1, 2);// 1/2

			// Distributivité addition

			ExpressionArithmetique add = new Addition(x, unDemi); // (x+1/2)

			Multiplication mult = new Multiplication(deux, add); // 2*(x+1/2)
			ExpressionArithmetique add1 = new Addition(new Multiplication(deux, x), un); // 2x + 1
			assertEquals("((2*x)+1)", mult.distribuer1(mult.left, (Addition) mult.right).toString());
			
			Multiplication mult1 = new Multiplication(add, deux); // (x+1/2)*2
			ExpressionArithmetique add2 = new Addition(new Multiplication(deux, x), un); // 2x + 1
			assertEquals("((x*2)+1)", mult1.distribuer2((Addition) mult1.left, mult1.right).toString());


			// Distributivité soustraction
			
			ExpressionArithmetique sous = new Soustraction(x, unDemi); // (x-1/2)
			
			Multiplication mult2 = new Multiplication(deux, sous); // 2*(x-1/2)
			ExpressionArithmetique sous1 = new Soustraction(new Multiplication(deux, x), un); // 2x - 1
			assertEquals("((2*x)-1)", mult2.distribuer3(mult2.left, (Soustraction) mult2.right).toString());

			Multiplication mult3 = new Multiplication(sous, deux); // (x-1/2)*2
			ExpressionArithmetique sous2 = new Soustraction(new Multiplication(deux, x), un); // 2x - 1
			assertEquals("((x*2)-1)", mult3.distribuer4((Soustraction) mult3.left, mult3.right).toString());

	}

}
