package fr.pantheonsorbonne.cri;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.ConstanteSymbolique.ConstantesSymboliqueConnues;

class testCos {

	@Test
	void test() {
		
		ConstanteN cst1 = new ConstanteN(30);
    	ExpressionArithmetique cosinus = new Cos(cst1);
    	assertEquals(cosinus.toString(), "(cos(30))");
		assertEquals(cosinus.simplifier().toString(), "(cos(30))");
		
		ConstanteN cst2 = new ConstanteN(-120);
    	ExpressionArithmetique testcos = new Cos(cst2);
    	assertEquals(testcos.toString(), "(cos(-120))");
		assertEquals(testcos.simplifier().toString(), "(-1/2)");
		
		ExpressionArithmetique cosO = new Cos(new ConstanteN(2));
		assertEquals(cosO.toString(), "(cos(2))");
		assertEquals(cosO.simplifier().toString(), "(cos(2))");
		
		ConstanteQ cst = new ConstanteQ(2, 4);
    	ExpressionArithmetique cosinus1 = new Cos(cst);
    	assertEquals(cosinus1.toString(), "(cos((2/4)))");
		assertEquals(cosinus1.simplifier().toString(), "(cos((1/2)))");
    	
    	ConstanteSymbolique pi = new ConstanteSymbolique(ConstantesSymboliqueConnues.PI);
    	ExpressionArithmetique cosPi = new Cos(pi);
    	assertEquals(cosPi.toString(), "(cos(π))");
		assertEquals(cosPi.simplifier().toString(), "-1");
		
		ConstanteN mipi = new ConstanteN(90);
    	ExpressionArithmetique cosMipi = new Cos(mipi);
    	assertEquals(cosMipi.toString(), "(cos(90))");
		assertEquals(cosMipi.simplifier().toString(), "0"); 
			
    	ConstanteSymbolique ex = new ConstanteSymbolique(ConstantesSymboliqueConnues.EXPONENTIELLE);
    	ExpressionArithmetique cosEx = new Cos(ex);
    	assertEquals(cosEx.toString(), "(cos(e))");
		assertEquals(cosEx.simplifier().toString(), "(cos(e))");	
		
		VariableInconnue x = new VariableInconnue('y');
    	ExpressionArithmetique cosVa = new Cos(x);
    	assertEquals(cosVa.toString(), "(cos(y))");
    	assertEquals(cosVa.simplifier().toString(), "(cos(y))");
    	
		} 

	void testEquals() {
		ConstanteQ cst1 = new ConstanteQ(1, 2);
    	ConstanteQ cst2 = new ConstanteQ(1, 2);
    	ConstanteN cst3 = new ConstanteN(3);
    	ExpressionArithmetique ex1 = new Cos(cst1); 
    	ExpressionArithmetique ex2 = new Cos(cst2);
    	assertEquals(ex1.equals(ex2), "true"); 
    	assertEquals(ex1.equals(cst3), "false");
	}
}
