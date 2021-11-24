package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testDivision {

	@Test
	void test() {
		ConstanteN cs1 = new ConstanteN(12);
		ConstanteN cs2 = new ConstanteN(2);
		ConstanteQ cs3 = new ConstanteQ(2, 3);
		ConstanteQ cs4 = new ConstanteQ(-4, 5);
		
		ExpressionArithmetique div1 = new Division(cs1, cs2);
		assertEquals("(12/2)",div1.toString());
		assertEquals("6",div1.simplifier().toString());
		
		ExpressionArithmetique div2 = new Division(cs2, cs1);
		assertEquals("(2/12)",div2.toString());
		assertEquals("(1/6)",div2.simplifier().toString());
		
		ExpressionArithmetique div3 = new Division(cs2, cs3);
		assertEquals("(2/(2/3))",div3.toString());
		assertEquals("3",div3.simplifier().toString());
		
		ExpressionArithmetique div4 = new Division(cs3, cs2);
		assertEquals("((2/3)/2)",div4.toString());
		assertEquals("(1/3)",div4.simplifier().toString());
		
		ExpressionArithmetique div5 = new Division(cs3, cs4);
		assertEquals("((2/3)/(-4/5))",div5.toString());
		assertEquals("(5/-6)",div5.simplifier().toString()); 
		
		ConstanteQ cst1 = new ConstanteQ(1, 2);
		ConstanteQ cst2 = new ConstanteQ(2, 1);
		ExpressionArithmetique ex = new Division(cst2, cst1);
		assertEquals("4",ex.simplifier().toString());

		//test q5
		
		 ConstanteN sous1 = new ConstanteN(10);
		 ConstanteQ sous2 = new ConstanteQ(1, 2);
		 VariableInconnue sous3 = new VariableInconnue("x");
		 
		 ExpressionArithmetique divi = new Division(sous1, sous2);
		 ExpressionArithmetique divi1 = new Division(sous3, divi);
		 assertEquals("(x/(10/(1/2)))",divi1.toString());
		 assertEquals("(x/20)", divi1.simplifier().toString());
		 
		 ConstanteQ sous4 = new ConstanteQ(10, 2);
		 ConstanteQ sous5 = new ConstanteQ(10, 6);
		 ExpressionArithmetique ex1 = new Division(sous4, sous5);
		 ExpressionArithmetique ex2 = new Division(ex1, sous3);
		 assertEquals("(((10/2)/(10/6))/x)",ex2.toString());
		 assertEquals("(3/x)",ex2.simplifier().toString());
		 
		 ExpressionArithmetique divi3 = new Division(sous1, sous3);
		 ExpressionArithmetique divi4 = new Division(divi3, sous2);
		 assertEquals("((10/x)/(1/2))",divi4.toString());
		 assertEquals("((10/x)/(1/2))",divi4.simplifier().toString());
		
	}

}
