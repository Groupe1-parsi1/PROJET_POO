package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testDerivation {

	@Test
	void test() {
		//addition
		ConstanteN cstN1 = new ConstanteN(9);
		ConstanteN cstN2 = new ConstanteN(14);
		ConstanteQ cstQ = new ConstanteQ(-2, 3);
		assertEquals("0", cstN1.deriver().toString());
		
		VariableInconnue x = new VariableInconnue('x');
		ExpressionArithmetique exSom = new Addition(cstN1, x);
		assertEquals("1", x.deriver().toString());
		assertEquals("1", exSom.deriver().toString());
		
		//soustraction
		ExpressionArithmetique exSous = new Soustraction(x, cstN2);
		assertEquals("1", exSous.deriver().toString());
		
		//multiplication
		ExpressionArithmetique exMul = new Multiplication(cstN1, x);
		assertEquals("9", exMul.deriver().toString());
		
		ExpressionArithmetique exMul1 = new Multiplication(cstN2, x);
		ExpressionArithmetique somMul = new Addition(exMul, exMul1);
		ExpressionArithmetique sousMul = new Soustraction(exMul1, exMul);
		assertEquals("23", somMul.deriver().toString());
		assertEquals("5", sousMul.deriver().toString());
		
		//Division
		ExpressionArithmetique div = new Division(x, cstN1);
		assertEquals("(1/9)", div.deriver().toString());
		
		ExpressionArithmetique div1 = new Division(cstN1, x);
		assertEquals("(9/x)", div1.toString());
		assertEquals("(-9/(x^2))", div1.deriver().toString());
		
		ExpressionArithmetique div2 = new Division(cstQ, x);
		assertEquals("((2/3)/(x^2))", div2.deriver().toString());
		
		//test Derivation polynom
		ConstanteN cst = new ConstanteN(4);
		ConstanteN cst1 = new ConstanteN(-6);
		
		ExpressionArithmetique puiss = new Puissance(x, cst);
		ExpressionArithmetique cst1x = new Multiplication(cst1, puiss);
		Exponentielle expo = new Exponentielle(cst1x); //e (-6x^4)
		
		
		ExpressionArithmetique puis = new Puissance(x, cst); // x ^ 4
		ExpressionArithmetique mulDer = new Multiplication(cst1, puis); //-6x^4
		
		ExpressionArithmetique puis1 = new Puissance(x, cstN1);
		ExpressionArithmetique mulDer1 = new Multiplication(cstQ, puis1); // -2/3 x^9
		
		ExpressionArithmetique s1 = new Addition(mulDer, mulDer1);
		ExpressionArithmetique s2 = new Addition(s1, expo);
		
		assertEquals("(((-6*(x^4))+((-2/3)*(x^9)))+(exp((-6*(x^4)))))", s2.toString());
		assertEquals("(((-24*(x^3))+(-6*(x^8)))+((-24*(x^3))*(exp((-6*(x^4))))))", s2.deriver().toString());
			
		
	}

}
