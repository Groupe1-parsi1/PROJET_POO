package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.ConstanteSymbolique.ConstantesSymboliqueConnues;

class TestSin {

	@Test
	void test() {			
			ConstanteN cst1 = new ConstanteN(30);
	    	ExpressionArithmetique sinus = new Sin(cst1);
	    	assertEquals("(sin(30))",sinus.toString());
			assertEquals("(1/2)",sinus.simplifier().toString());
			
			ConstanteN c0 = new ConstanteN(0);
			ExpressionArithmetique sin0 = new Sin(c0);
			assertEquals("0",sin0.simplifier().toString());
			
			ConstanteN c90 = new ConstanteN(-90);
			ExpressionArithmetique sin90 = new Sin(c90);
			assertEquals("-1",sin90.simplifier().toString());
			
			ConstanteN c30 = new ConstanteN(-30);
			ExpressionArithmetique sin30 = new Sin(c30);
			assertEquals( "(-1/2)",sin30.simplifier().toString());
			
			ConstanteN c150 = new ConstanteN(-150);
			ExpressionArithmetique sin150 = new Sin(c150);
			assertEquals("(-1/2)",sin150.simplifier().toString());
			
			ExpressionArithmetique cosO = new Sin(new ConstanteN(2));
			assertEquals("(sin(2))",cosO.toString());
			assertEquals("(sin(2))",cosO.simplifier().toString());
			
			ConstanteQ cst = new ConstanteQ(2, 4);
	    	ExpressionArithmetique sinus1 = new Sin(cst);
	    	assertEquals("(sin((2/4)))",sinus1.toString());
			assertEquals( "(sin((1/2)))",sinus1.simplifier().toString());
	    	
	    	ConstanteSymbolique pi = new ConstanteSymbolique(ConstantesSymboliqueConnues.PI);
	    	ExpressionArithmetique sinPi = new Sin(pi);
	    	assertEquals("(sin(π))",sinPi.toString());
			assertEquals( "0",sinPi.simplifier().toString());
			
			ConstanteN mipi = new ConstanteN(90);
	    	ExpressionArithmetique sinMipi = new Sin(mipi);
	    	assertEquals("(sin(90))",sinMipi.toString());
			assertEquals( "1",sinMipi.simplifier().toString()); 
				
	    	ConstanteSymbolique ex = new ConstanteSymbolique(ConstantesSymboliqueConnues.EXPONENTIELLE);
	    	ExpressionArithmetique sinEx = new Sin(ex);
	    	assertEquals("(sin(e))",sinEx.toString());
			assertEquals( "(sin(e))",sinEx.simplifier().toString());	
			
			VariableInconnue x = new VariableInconnue("y");
	    	ExpressionArithmetique sinVa = new Sin(x);
	    	assertEquals("(sin(y))",sinVa.toString());
	    	assertEquals( "(sin(y))",sinVa.simplifier().toString());
	    	

	    	ExpressionArithmetique divPi4 = new Division(new ConstanteSymbolique(ConstantesSymboliqueConnues.PI),new ConstanteN(4));
			ExpressionArithmetique sinPi4 = new Sin(divPi4);
			assertEquals("((sqrt(2))/2)",sinPi4.simplifier().toString());
			
			ExpressionArithmetique divPi41 = new Division(new ConstanteSymbolique(ConstantesSymboliqueConnues.PI),new ConstanteN(-4));
			ExpressionArithmetique sinPi41 = new Sin(divPi41);
			assertEquals("((sqrt(2))/-2)",sinPi41.simplifier().toString());
			
			ExpressionArithmetique divPi2 = new Division(new ConstanteSymbolique(ConstantesSymboliqueConnues.PI),new ConstanteN(2));
			ExpressionArithmetique sinPi2 = new Sin(divPi2);
			assertEquals("1",sinPi2.simplifier().toString());
			
			ExpressionArithmetique divPi6 = new Division(new ConstanteSymbolique(ConstantesSymboliqueConnues.PI),new ConstanteN(6));
			ExpressionArithmetique sinPi6 = new Sin(divPi6);
			assertEquals("(1/2)",sinPi6.simplifier().toString());
			
			ExpressionArithmetique divPi61 = new Division(new ConstanteSymbolique(ConstantesSymboliqueConnues.PI),new ConstanteN(-6));
			ExpressionArithmetique sinPi61 = new Sin(divPi61);
			assertEquals("(-1/2)",sinPi61.simplifier().toString());
			
			ExpressionArithmetique divPi3 = new Division(new ConstanteSymbolique(ConstantesSymboliqueConnues.PI),new ConstanteN(3));
			ExpressionArithmetique sinPi3 = new Sin(divPi3);
			assertEquals("((sqrt(3))/2)",sinPi3.simplifier().toString());
			
			ExpressionArithmetique divPi31 = new Division(new ConstanteSymbolique(ConstantesSymboliqueConnues.PI),new ConstanteN(-3));
			ExpressionArithmetique sinPi31 = new Sin(divPi31);
			assertEquals("((sqrt(3))/-2)",sinPi31.simplifier().toString());
			
			
			
			ExpressionArithmetique divPi21 = new Division(new ConstanteSymbolique(ConstantesSymboliqueConnues.PI),new ConstanteN(-2));
			ExpressionArithmetique sinPi21 = new Sin(divPi21);
			assertEquals("-1",sinPi21.simplifier().toString());
			

			
		
	}

}
