package fr.pantheonsorbonne.cri;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.ConstanteSymbolique.ConstantesSymboliqueConnues;

class TestCos {

	@Test
	void test() {
		
		ConstanteN cst1 = new ConstanteN(30);
    	ExpressionArithmetique cosinus = new Cos(cst1);
    	assertEquals("(cos(30))",cosinus.toString());
		assertEquals("(cos(30))",cosinus.simplifier().toString());
		ConstanteN cst2 = new ConstanteN(-120);
    	ExpressionArithmetique testcos = new Cos(cst2);
    	assertEquals("(cos(-120))",testcos.toString());
		assertEquals("(-1/2)",testcos.simplifier().toString());
		ExpressionArithmetique cosO = new Cos(new ConstanteN(2));
		assertEquals("(cos(2))",cosO.toString());
		assertEquals("(cos(2))",cosO.simplifier().toString());
		
		ConstanteQ cst = new ConstanteQ(2, 4);
    	ExpressionArithmetique cosinus1 = new Cos(cst);
    	assertEquals("(cos((2/4)))",cosinus1.toString());
		assertEquals( "(cos((1/2)))",cosinus1.simplifier().toString());
    	
    	ConstanteSymbolique pi = new ConstanteSymbolique(ConstantesSymboliqueConnues.PI);
    	ExpressionArithmetique cosPi = new Cos(pi);
    	assertEquals("(cos(π))",cosPi.toString());
		assertEquals("-1",cosPi.simplifier().toString());
		
		ExpressionArithmetique divPi2 = new Division(new ConstanteSymbolique(ConstantesSymboliqueConnues.PI),new ConstanteN(2));
		ExpressionArithmetique cosPi2 = new Cos(divPi2);
		assertEquals("0",cosPi2.simplifier().toString());
		
		ExpressionArithmetique divPi21 = new Division(new ConstanteSymbolique(ConstantesSymboliqueConnues.PI),new ConstanteN(-2));
		ExpressionArithmetique cosPi21 = new Cos(divPi21);
		assertEquals( "0",cosPi21.simplifier().toString());
		
		ExpressionArithmetique divPi3 = new Division(new ConstanteSymbolique(ConstantesSymboliqueConnues.PI),new ConstanteN(3));
		ExpressionArithmetique cosPi3 = new Cos(divPi3);
		assertEquals("(1/2)",cosPi3.simplifier().toString());
		
		ExpressionArithmetique divPi31 = new Division(new ConstanteSymbolique(ConstantesSymboliqueConnues.PI),new ConstanteN(-3));
		ExpressionArithmetique cosPi31 = new Cos(divPi31);
		assertEquals("(1/2)",cosPi31.simplifier().toString());
		
		ExpressionArithmetique divPi4 = new Division(new ConstanteSymbolique(ConstantesSymboliqueConnues.PI),new ConstanteN(4));
		ExpressionArithmetique cosPi4 = new Cos(divPi4);
		assertEquals("((sqrt(2))/2)",cosPi4.simplifier().toString());
		
		ExpressionArithmetique divPi41 = new Division(new ConstanteSymbolique(ConstantesSymboliqueConnues.PI),new ConstanteN(-4));
		ExpressionArithmetique cosPi41 = new Cos(divPi41);
		assertEquals("((sqrt(2))/2)",cosPi41.simplifier().toString());
		
		ExpressionArithmetique divPi6 = new Division(new ConstanteSymbolique(ConstantesSymboliqueConnues.PI),new ConstanteN(6));
		ExpressionArithmetique cosPi6 = new Cos(divPi6);
		assertEquals("((sqrt(3))/2)",cosPi6.simplifier().toString());
		
		ExpressionArithmetique divPi61 = new Division(new ConstanteSymbolique(ConstantesSymboliqueConnues.PI),new ConstanteN(-6));
		ExpressionArithmetique cosPi61 = new Cos(divPi61);
		assertEquals("((sqrt(3))/2)",cosPi61.simplifier().toString());
    	
		}
	
	@Test
	void test2() {
		ConstanteN mipi = new ConstanteN(90);
    	ExpressionArithmetique cosMipi = new Cos(mipi);
    	assertEquals("(cos(90))",cosMipi.toString());
		assertEquals("0",cosMipi.simplifier().toString()); 
			
    	ConstanteSymbolique ex = new ConstanteSymbolique(ConstantesSymboliqueConnues.EXPONENTIELLE);
    	ExpressionArithmetique cosEx = new Cos(ex);
    	assertEquals( "(cos(e))",cosEx.toString());
		assertEquals( "(cos(e))",cosEx.simplifier().toString());	
		
		VariableInconnue x = new VariableInconnue("y");
    	ExpressionArithmetique cosVa = new Cos(x);
    	assertEquals("(cos(y))",cosVa.toString());
    	assertEquals("(cos(y))",cosVa.simplifier().toString());
    	
    	ConstanteN cos0 = new ConstanteN(0);
    	ExpressionArithmetique exCos = new Cos(cos0);
    	assertEquals("1",exCos.simplifier().toString());
    	
    	ConstanteN cos60 = new ConstanteN(60);
    	ExpressionArithmetique exCos60 = new Cos(cos60);
    	assertEquals("(1/2)",exCos60.simplifier().toString());
    	
    	ConstanteN cos601 = new ConstanteN(-60);
    	ExpressionArithmetique exCos601 = new Cos(cos601);
    	assertEquals("(1/2)",exCos601.simplifier().toString());
	}
	@Test
	void test1() {
		ConstanteN mipi = new ConstanteN(90);
    	ExpressionArithmetique cosMipi = new Cos(mipi);
    	assertEquals("(cos(90))",cosMipi.toString());
		assertEquals("0",cosMipi.simplifier().toString()); 
			
    	ConstanteSymbolique ex = new ConstanteSymbolique(ConstantesSymboliqueConnues.EXPONENTIELLE);
    	ExpressionArithmetique cosEx = new Cos(ex);
    	assertEquals( "(cos(e))",cosEx.toString());
		assertEquals( "(cos(e))",cosEx.simplifier().toString());	
		
		VariableInconnue x = new VariableInconnue("y");
    	ExpressionArithmetique cosVa = new Cos(x);
    	assertEquals("(cos(y))",cosVa.toString());
    	assertEquals("(cos(y))",cosVa.simplifier().toString());
    	
    	ConstanteN cos0 = new ConstanteN(0);
    	ExpressionArithmetique exCos = new Cos(cos0);
    	assertEquals("1",exCos.simplifier().toString());
    	
    	ConstanteN cos60 = new ConstanteN(60);
    	ExpressionArithmetique exCos60 = new Cos(cos60);
    	assertEquals("(1/2)",exCos60.simplifier().toString());
    	
    	ConstanteN cos601 = new ConstanteN(-60);
    	ExpressionArithmetique exCos601 = new Cos(cos601);
    	assertEquals("(1/2)",exCos601.simplifier().toString());
	}
}
