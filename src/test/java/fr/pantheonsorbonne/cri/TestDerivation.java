package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDerivation {

	@Test
	void test() {
		//addition
		ConstanteN cstN1 = new ConstanteN(9);
		ConstanteN cstN2 = new ConstanteN(14);
		ConstanteQ cstQ = new ConstanteQ(-2, 3);
		assertEquals("0", cstN1.deriver().toString());
		
		VariableInconnue x = new VariableInconnue("x");
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
		
		assertEquals("0", cst1.deriver().toString());
		assertEquals("0", cst1.deriver(2).toString());
		
		assertEquals("0", cstQ.deriver().toString());
		assertEquals("0", cstQ.deriver(2).toString());
			
		
	}
	
	@Test
	void TestDerivationOrdreN() {
		ConstanteN cst1 = new ConstanteN(3);
		ConstanteN cst2 = new ConstanteN(4);
		ConstanteN cst = new ConstanteN(2);
		
		VariableInconnue x = new VariableInconnue("x");
		
		assertEquals("0", x.deriver(3).toString());
		
		ExpressionArithmetique pui = new Puissance(x, cst1); //x^3
		ExpressionArithmetique pui2 = new Puissance(x, cst); // x^2
		ExpressionArithmetique pui3 = new Multiplication(cst1, pui2);
		ExpressionArithmetique ex = new Addition(pui, pui3);
		ExpressionArithmetique exSous = new Soustraction(pui, pui3);
		
		assertEquals("((6*x)+6)", ex.deriver(2).toString());
		assertEquals("6", ex.deriver(3).toString());
		
		assertEquals("((6*x)-6)", exSous.deriver(2).toString());
		assertEquals("6", exSous.deriver(3).toString());
		
		ExpressionArithmetique exCos = new Cos(pui);
		assertEquals("((-3*(x^2))*(sin((x^3))))", exCos.deriver().toString());
		assertEquals("(((-6*x)*(sin((x^3))))+((-3*(x^2))*((3*(x^2))*(cos((x^3))))))", exCos.deriver(2).toString());
		
		
		ExpressionArithmetique exSin = new Sin(pui);
		assertEquals("((3*(x^2))*(cos((x^3))))", exSin.deriver().toString());
		assertEquals("(((6*x)*(cos((x^3))))+((3*(x^2))*((-3*(x^2))*(sin((x^3))))))", exSin.deriver(2).toString());
		
		ExpressionArithmetique exLn = new Ln(pui);
		assertEquals("((3*(x^2))/(x^3))", exLn.deriver().toString());
		assertEquals("((((6*x)*(x^3))-((3*(x^2))*(3*(x^2))))/((x^3)^2))", exLn.deriver(2).toString());
		
		ExpressionArithmetique exExpo = new Exponentielle(pui);
		assertEquals("((3*(x^2))*(exp((x^3))))", exExpo.deriver().toString());
		assertEquals("(((6*x)*(exp((x^3))))+((3*(x^2))*((3*(x^2))*(exp((x^3))))))", exExpo.deriver(2).toString());
		
		ExpressionArithmetique exSqrt = new Sqrt(pui);
		assertEquals("((3*(x^2))/(2*(sqrt((x^3)))))", exSqrt.deriver().toString());
		assertEquals("((((6*x)*(2*(sqrt((x^3)))))-((2*((3*(x^2))/(2*(sqrt((x^3))))))*(3*(x^2))))/((2*(sqrt((x^3))))^2))", exSqrt.deriver(2).toString());
	}
	
	@Test
	void testDerivationOrdreNPuissance() {
		ConstanteN cst1 = new ConstanteN(3);
		ConstanteN cst2 = new ConstanteN(5);
		
		ConstanteQ cstq = new ConstanteQ(3, 7);
		ConstanteQ cstq1 = new ConstanteQ(5, 3);
		
		VariableInconnue x = new VariableInconnue("x");
		
		ExpressionArithmetique puis1 = new Puissance(x, cst1); // x^3
		ExpressionArithmetique puiss = new Puissance(puis1, cst2);
		ExpressionArithmetique puis4 = new Puissance(x, new ConstanteN(2));
		ExpressionArithmetique puis2 = new Puissance(x, cstq); // x^3/7
		
		ExpressionArithmetique mul = new Multiplication(cst2, x); //5x
		ExpressionArithmetique puis3 = new Puissance(mul, cst1);
		ExpressionArithmetique mul1 = new Multiplication(cstq1, puis3); //5/3 * (5x)^3
		
		assertEquals("(3*(x^2))", puis1.deriver().toString());
		assertEquals("((3/7)*(x^(-4/7)))", puis2.deriver().toString());
		assertEquals("(3*((5*x)^2))", puis3.deriver().toString());
		assertEquals("(5*((5*x)^2))", mul1.deriver().toString());
		assertEquals("(2*x)", puis4.deriver().toString());
		assertEquals("(50*x)", mul1.deriver(2).toString());
		assertEquals("(20*((x^3)^3))", puiss.deriver(2).toString());
	}
	
	@Test
	void testDerivationOrdreNDivision() {
		VariableInconnue x = new VariableInconnue("x");
		ConstanteN cst = new ConstanteN(3);
		ConstanteQ cstq = new ConstanteQ(3, 4);
		ExpressionArithmetique div1 = new Division(x, cst);
		ExpressionArithmetique div2 = new Division(x, cstq);
		ExpressionArithmetique div3 = new Division(div1, cstq);
		
		assertEquals("(1/3)", div1.deriver().toString());
		assertEquals("(4/3)", div2.deriver().toString());
		assertEquals("0", div3.deriver(2).toString());
	}
	
	@Test
	void test15() {
		ConstanteN deux = new ConstanteN(2);
		ConstanteN trois = new ConstanteN(3);
		ConstanteN quatre = new ConstanteN(4);
		ConstanteN cinq = new ConstanteN(5);
		ConstanteN dix = new ConstanteN(10);
		
		VariableInconnue x = new VariableInconnue("x");
		
		ExpressionArithmetique mul1 = new Multiplication(cinq, new Puissance(x, quatre));
		ExpressionArithmetique mul2 = new Multiplication(quatre, new Puissance(x, trois));
		ExpressionArithmetique mul3 = new Multiplication(trois, new Puissance(x, deux));
		ExpressionArithmetique mul4 = new Multiplication(cinq, x);
		ExpressionArithmetique expo = new Exponentielle(new Multiplication(new ConstanteN(-3), x));
		
		ExpressionArithmetique ad1 = new Addition(mul1, mul2);
		ExpressionArithmetique ad2 = new Addition(ad1, mul3);
		ExpressionArithmetique ad3 = new Addition(ad2, mul4);
		ExpressionArithmetique ad4 = new Addition(ad3, new ConstanteN(10));
		//ExpressionArithmetique ad5 = new Addition(ad4, new ConstanteN(10));
		ExpressionArithmetique ad5 = new Addition(ad4, expo);
		
		
		assertEquals("((((((5*(x^4))+(4*(x^3)))+(3*(x^2)))+(5*x))+10)+(exp((-3*x))))", ad5.toString());
		assertEquals("(((120*x)+24)+(-27*(exp((-3*x)))))",ad5.deriver(3).toString());
		
	}

}
