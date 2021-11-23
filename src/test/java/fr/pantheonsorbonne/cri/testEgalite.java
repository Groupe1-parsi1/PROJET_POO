package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testEgalite {

	@Test
	void test() {
		 ConstanteN n1 = new ConstanteN(2);
		 ConstanteN n11 = new ConstanteN(2);
		 ConstanteN n2 = new ConstanteN(3);
	     ConstanteN n3 = new ConstanteN(5);
	     ConstanteQ q1 = new ConstanteQ(2, 4);
	     ConstanteQ q2 = new ConstanteQ(1, 2);
	     VariableInconnue x = new VariableInconnue('x');
	     VariableInconnue y = new VariableInconnue('x');
	     
	     assertTrue(x.equals(y));
	     assertTrue(x.equals(x));
	     
	     assertFalse(n1.equals(q1));
	     assertFalse(n1.equals(null));
	     
	     
	     ExpressionArithmetique ex3 = new Addition(q1, x); 
	     ExpressionArithmetique ex5 = new Addition(q2, x);
	     
	     ExpressionArithmetique ex4 = new Addition(new Addition(q1, n1),x);
	     ExpressionArithmetique ex6 = new Addition(new Addition(q2, n11), x);
	     
	     ExpressionArithmetique ex31 = new Addition(new Addition(n1, n2), x);
	     ExpressionArithmetique ex41 = new Addition(n3, x); 
	     
	     assertTrue(ex31.equals(ex41));
	     assertTrue(ex3.equals(ex5));
	     assertTrue(ex4.equals(ex6));
	     assertTrue(n1.equals(n11));
	     
	     assertFalse(ex31.equals(n1));
	     assertFalse(ex31.equals(null));
	    
	     
	     
	     
	     ConstanteQ cst1 = new ConstanteQ(1, 2);
	     ConstanteQ cst2 = new ConstanteQ(1, 2);
	     ConstanteN cst3 = new ConstanteN(3);
	     ExpressionArithmetique ex1 = new Cos(cst1); 
	     ExpressionArithmetique ex2 = new Cos(cst2);
	     assertTrue(ex1.equals(ex2)); 
	     assertFalse(ex1.equals(cst3));
	     
	     assertFalse(x.equals(cst1));
	     assertFalse(x.equals(null));
	     
	     ExpressionArithmetique exUni = new Sqrt(n1);
	     ExpressionArithmetique exUni1 = new Sqrt(n11);
	     ExpressionArithmetique exUni2 = new Sqrt(q1);
	     
	     assertTrue(exUni.equals(exUni1));
	     
	     assertFalse(exUni.equals(null));
	     assertFalse(exUni.equals(exUni2));
	     
	    
	}

}
