package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.ConstanteSymbolique.ConstantesSymboliqueConnues;

class testSin {

	@Test
	void test() {			
			ConstanteN cst1 = new ConstanteN(30);
	    	ExpressionArithmetique sinus = new Sin(cst1);
	    	assertEquals(sinus.toString(), "(sin(30))");
			assertEquals(sinus.simplifier().toString(), "(1/2)");
			
			ExpressionArithmetique cosO = new Sin(new ConstanteN(2));
			assertEquals(cosO.toString(), "(sin(2))");
			assertEquals(cosO.simplifier().toString(), "(sin(2))");
			
			ConstanteQ cst = new ConstanteQ(2, 4);
	    	ExpressionArithmetique sinus1 = new Sin(cst);
	    	assertEquals(sinus1.toString(), "(sin((2/4)))");
			assertEquals(sinus1.simplifier().toString(), "(sin((1/2)))");
	    	
	    	ConstanteSymbolique pi = new ConstanteSymbolique(ConstantesSymboliqueConnues.PI);
	    	ExpressionArithmetique sinPi = new Sin(pi);
	    	assertEquals(sinPi.toString(), "(sin(π))");
			assertEquals(sinPi.simplifier().toString(), "0");
			
			ConstanteN mipi = new ConstanteN(90);
	    	ExpressionArithmetique sinMipi = new Sin(mipi);
	    	assertEquals(sinMipi.toString(), "(sin(90))");
			assertEquals(sinMipi.simplifier().toString(), "1"); 
				
	    	ConstanteSymbolique ex = new ConstanteSymbolique(ConstantesSymboliqueConnues.EXPONENTIELLE);
	    	ExpressionArithmetique sinEx = new Sin(ex);
	    	assertEquals(sinEx.toString(), "(sin(e))");
			assertEquals(sinEx.simplifier().toString(), "(sin(e))");	
			
			VariableInconnue x = new VariableInconnue('y');
	    	ExpressionArithmetique sinVa = new Sin(x);
	    	assertEquals(sinVa.toString(), "(sin(y))");
	    	assertEquals(sinVa.simplifier().toString(), "(sin(y))");
	    	
	    
	}

}
