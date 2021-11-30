package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestEgalite {

	@Test
	void test() {
		 ConstanteN n1 = new ConstanteN(2);
		 ConstanteN n11 = new ConstanteN(2);
		 ConstanteN n2 = new ConstanteN(3);
	     ConstanteN n3 = new ConstanteN(5);
	     ConstanteQ q1 = new ConstanteQ(2, 4);
	     ConstanteQ q2 = new ConstanteQ(1, 2);
	     VariableInconnue x = new VariableInconnue("x");
	     VariableInconnue y = new VariableInconnue("x");
	     
	     assertEquals(x, y);
	    
	    // assertNotEquals(n1, q1);
	    
	     assertNotEquals(null,n1);  
	     
	     ExpressionArithmetique ex3 = new Addition(q1, x); 
	     ExpressionArithmetique ex5 = new Addition(q2, x);
	     
	     ExpressionArithmetique ex4 = new Addition(new Addition(q1, n1),x);
	     ExpressionArithmetique ex6 = new Addition(new Addition(q2, n11), x);
	     
	     ExpressionArithmetique ex31 = new Addition(new Addition(n1, n2), x);
	     ExpressionArithmetique ex41 = new Addition(n3, x); 

	     assertEquals(ex31, ex41);
	
	     assertEquals(ex3, ex5);
	     assertEquals(ex4, ex6);
	
	     assertEquals(n1, n11);
	   
	     assertNotEquals(ex31, n1);
	     assertNotEquals(null,ex31);
	     
	     assertEquals(n1.hashCode(), n11.hashCode());
	     assertNotEquals(ex31.hashCode(), n1.hashCode());
	     
	     
	     ConstanteQ cst1 = new ConstanteQ(1, 2);
	     ConstanteQ cst2 = new ConstanteQ(1, 2);
	     ConstanteN cst3 = new ConstanteN(3);
	     ExpressionArithmetique ex1 = new Cos(cst1); 
	     ExpressionArithmetique ex2 = new Cos(cst2);
	    
	     assertEquals(ex1, ex2);	    
	     assertNotEquals(ex1, cst3);
	   
	     //assertNotEquals(x, cst1);
	   
	     assertNotEquals(null,x);
	     
	     ExpressionArithmetique exUni = new Sqrt(n1);
	     ExpressionArithmetique exUni1 = new Sqrt(n11);
	     ExpressionArithmetique exUni2 = new Sqrt(q1);
	     
	     assertEquals(exUni, exUni1);
	 
	     assertNotEquals(null,exUni);
	
	     assertNotEquals(exUni, exUni2);
	     
	     assertEquals(exUni1.hashCode(), exUni1.hashCode());
	     assertNotEquals(exUni1.hashCode(), exUni2.hashCode());
	     
	    
	}


}
