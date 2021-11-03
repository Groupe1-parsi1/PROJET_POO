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
		assertEquals(div1.toString(), "(12/2)");
		assertEquals(div1.simplifier().toString(), "6");
		
		ExpressionArithmetique div2 = new Division(cs2, cs1);
		assertEquals(div2.toString(), "(2/12)");
		assertEquals(div2.simplifier().toString(), "(1/6)");
		
		ExpressionArithmetique div3 = new Division(cs2, cs3);
		assertEquals(div3.toString(), "(2/(2/3))");
		assertEquals(div3.simplifier().toString(), "3");
		
		ExpressionArithmetique div4 = new Division(cs3, cs2);
		assertEquals(div4.toString(), "((2/3)/2)");
		assertEquals(div4.simplifier().toString(), "(1/3)");
		
		ExpressionArithmetique div5 = new Division(cs3, cs4);
		assertEquals(div5.toString(), "((2/3)/(-4/5))");
		assertEquals(div5.simplifier().toString(), "(5/-6)"); 
		
		ConstanteQ cst1 = new ConstanteQ(1, 2);
		ConstanteQ cst2 = new ConstanteQ(2, 1);
		ExpressionArithmetique ex = new Division(cst2, cst1);
		assertEquals(ex.simplifier().toString(), "4");

		//test q5
		
		 ConstanteN sous1 = new ConstanteN(10);
		 ConstanteQ sous2 = new ConstanteQ(1, 2);
		 VariableInconnue sous3 = new VariableInconnue('x');
		 
		 ExpressionArithmetique divi = new Division(sous1, sous2);
		 ExpressionArithmetique divi1 = new Division(sous3, divi);
		 assertEquals(divi1.toString(),"(x/(10/(1/2)))");
		 assertEquals(divi1.simplifier().toString(), "(x/20)");
		 
		 ConstanteQ sous4 = new ConstanteQ(10, 2);
		 ConstanteQ sous5 = new ConstanteQ(10, 6);
		 ExpressionArithmetique ex1 = new Division(sous4, sous5);
		 ExpressionArithmetique ex2 = new Division(ex1, sous3);
		 assertEquals(ex2.toString(),"(((10/2)/(10/6))/x)");
		 assertEquals(ex2.simplifier().toString(),"(3/x)");
		 
		 ExpressionArithmetique divi3 = new Division(sous1, sous3);
		 ExpressionArithmetique divi4 = new Division(divi3, sous2);
		 assertEquals(divi4.toString(),"((10/x)/(1/2))");
		 assertEquals(divi4.simplifier().toString(),"((10/x)/(1/2))");
		 
		 
		
	}

}
