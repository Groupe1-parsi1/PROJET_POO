package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Expression;

import org.junit.jupiter.api.Test;

class TestAfficheExpression {

	@Test
	void test() {
		ConstanteN cst1 = new ConstanteN(9);
		ConstanteN cst2 = new ConstanteN(14);
		ConstanteN cst3 = new ConstanteN(2);
		ConstanteN cst4 = new ConstanteN(11);
		
		ConstanteQ cst5 = new ConstanteQ(11, 14);
		ConstanteQ cst6 = new ConstanteQ(10, 2);
		ConstanteQ cst7 = new ConstanteQ(10, 6);
		
		VariableInconnue var1 = new VariableInconnue("x");
		VariableInconnue var2 = new VariableInconnue("y");
		
		ExpressionArithmetique puiss1 = new Puissance(var1, cst3);
		ExpressionArithmetique divi1 = new Division(cst4, var1);
		ExpressionArithmetique sqrt1 = new Sqrt(cst4);
		
		ExpressionArithmetique ex1 = new Multiplication(cst1, puiss1);
		ExpressionArithmetique ex2 = new Multiplication(cst3, var2);
		ExpressionArithmetique ex3 = new Multiplication(new Multiplication(cst2, var1), var2);
		ExpressionArithmetique ex4 = new Addition(cst3, ex3);
		ExpressionArithmetique ex5 = new Addition(sqrt1, cst7);
		ExpressionArithmetique ex6 = new Multiplication(cst6, ex3);
		
		ExpressionArithmetique res1 = new Division(ex4, ex2);
		ExpressionArithmetique res1fini = new Addition(ex5, res1);
		ExpressionArithmetique res2 = new Soustraction(ex6, ex1);
		ExpressionArithmetique res2fini = new Multiplication(divi1, res2);
		
		ExpressionArithmetique resultat = new Soustraction(res1fini, res2fini);
		
		assertEquals("((((sqrt(11))+(10/6))+((2+((14*x)*y))/(2*y)))-((11/x)*(((10/2)*((14*x)*y))-(9*(x^2)))))",resultat.toString());
	}

}
