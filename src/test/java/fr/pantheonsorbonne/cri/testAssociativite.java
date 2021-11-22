package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class testAssociativite {
	@Test
	void testAssociativiteAddition() {
		ConstanteN cst = new ConstanteN(2);
		ConstanteN cst1 = new ConstanteN(3);
		ConstanteQ cstq = new ConstanteQ(1, 2);
		ConstanteQ cstq1 = new ConstanteQ(1, 3);
		
		VariableInconnue x = new VariableInconnue('x');
		
		ExpressionArithmetique ex1n = new Addition(cst, x); // 2+ x
		ExpressionArithmetique ex1q = new Addition(cstq, x); // 1/2 + x
		
		ExpressionArithmetique nex1 = new Addition(x, cst); // x + 2
		ExpressionArithmetique qex1 = new Addition(x, cstq); // x + 1/2
		
		ExpressionArithmetique somme1 = new Addition(ex1n, cst1); // 2+x     + 3
		ExpressionArithmetique somme2 = new Addition(ex1q, cst1); // 1/2+x   + 3
		ExpressionArithmetique somme3 = new Addition(nex1, cst1); // x+2     + 3
		ExpressionArithmetique somme4 = new Addition(qex1, cst1); // x+1/2   + 3
		
		ExpressionArithmetique somme5 = new Addition(cst1, ex1n); // 3 + 2+x
		ExpressionArithmetique somme6 = new Addition(cst1, ex1q); // 3 + 1/2+x
		ExpressionArithmetique somme7 = new Addition(cst1, nex1); // 3 + x+2
		ExpressionArithmetique somme8 = new Addition(cst1, qex1); // 3 + x+1/2
		
		ExpressionArithmetique somme11 = new Addition(ex1n, cstq1); // 2+x     + 1/3
		ExpressionArithmetique somme21 = new Addition(ex1q, cstq1); // 1/2+x   + 1/3
		ExpressionArithmetique somme31 = new Addition(nex1, cstq1); // x+2     + 1/3
		ExpressionArithmetique somme41 = new Addition(qex1, cstq1); // x+1/2   + 1/3
		
		ExpressionArithmetique somme51 = new Addition(cstq1, ex1n); // 1/3 + 2+x
		ExpressionArithmetique somme61 = new Addition(cstq1, ex1q); // 1/3 + 1/2+x
		ExpressionArithmetique somme71 = new Addition(cstq1, nex1); // 1/3 + x+2
		ExpressionArithmetique somme81 = new Addition(cstq1, qex1); // 1/3 + x+1/2
		
		assertEquals("(x+5)", somme1.simplifier().toString());
		assertEquals("(x+(7/2))", somme2.simplifier().toString());
		assertEquals("(x+5)", somme3.simplifier().toString());
		assertEquals("(x+(7/2))", somme4.simplifier().toString());
		assertEquals("(x+5)", somme5.simplifier().toString());
		assertEquals("(x+(7/2))", somme6.simplifier().toString());
		assertEquals("(x+5)", somme7.simplifier().toString());
		assertEquals("(x+(7/2))", somme8.simplifier().toString());
		
		assertEquals("(x+(7/3))", somme11.simplifier().toString());
		assertEquals("(x+(5/6))", somme21.simplifier().toString());
		assertEquals("(x+(7/3))", somme31.simplifier().toString());
		assertEquals("(x+(5/6))", somme41.simplifier().toString());
		assertEquals("(x+(7/3))", somme51.simplifier().toString());
		assertEquals("(x+(5/6))", somme61.simplifier().toString());
		assertEquals("(x+(7/3))", somme71.simplifier().toString());
		assertEquals("(x+(5/6))", somme81.simplifier().toString());
	}
	
	@Test
	void testAssociativiteMulti() {
		ConstanteN cst = new ConstanteN(2);
		ConstanteN cst1 = new ConstanteN(3);
		ConstanteQ cstq = new ConstanteQ(1, 2);
		ConstanteQ cstq1 = new ConstanteQ(1, 3);
		
		VariableInconnue x = new VariableInconnue('x');
		
		ExpressionArithmetique ex1 = new Multiplication(cst, x); //2x
		ExpressionArithmetique ex2 = new Multiplication(cstq, x); // 1/2 x
		
		ExpressionArithmetique ex3 = new Multiplication(x, cst); //x 2
		ExpressionArithmetique ex4 = new Multiplication(x, cstq); //x 1/2
		
		ExpressionArithmetique mul1 = new Multiplication(ex1, cst1);   //2x * 3
		ExpressionArithmetique mul2 = new Multiplication(ex1, cstq1); // 2X * 1/3
		ExpressionArithmetique mul21 = new Multiplication(ex2, cst1);    //  1/2x * 3
		ExpressionArithmetique mul12 = new Multiplication(ex2, cstq1);//  1/2x * 1/3
				
 		ExpressionArithmetique mul3 = new Multiplication(ex3, cst1); //x2 * 3
		ExpressionArithmetique mul4 = new Multiplication(ex3, cstq1); //x2 * 1/3
		ExpressionArithmetique mul31 =  new Multiplication(ex4, cst1); //x 1/2 *3
		ExpressionArithmetique mul41 = new Multiplication(ex4, cstq1); // x 1/2 * 1/3
		
		ExpressionArithmetique mul5 = new Multiplication(cst1, ex1); //3 * 2x
		ExpressionArithmetique mul6 = new Multiplication(cst1, ex2);// 3 * 1/2x
		ExpressionArithmetique mul7 = new Multiplication(cstq1, ex1); //1/3 * 2x
		ExpressionArithmetique mul8 = new Multiplication(cstq1, ex2); //1/3 * 1/2x
		
		ExpressionArithmetique mul51 = new Multiplication(cst1, ex3); //3 * x2
		ExpressionArithmetique mul61 = new Multiplication(cst1, ex4); // 3 * x 1/2
		ExpressionArithmetique mul71 = new Multiplication(cstq1,  ex3); //  1/3 * x2
		ExpressionArithmetique mul81 = new Multiplication(cstq1, ex4); //1/3 * x 1/2
		
		assertEquals("(6*x)",mul1.simplifier().toString());
		assertEquals("((2/3)*x)",mul2.simplifier().toString());
		assertEquals("((3/2)*x)",mul21.simplifier().toString());
		assertEquals("((1/6)*x)",mul12.simplifier().toString());
		assertEquals("(6*x)",mul3.simplifier().toString());
		assertEquals("((2/3)*x)",mul4.simplifier().toString());
		assertEquals("((3/2)*x)",mul31.simplifier().toString());
		assertEquals("((1/6)*x)",mul41.simplifier().toString());
		
		assertEquals("(6*x)",mul5.simplifier().toString());
		assertEquals("((3/2)*x)",mul6.simplifier().toString());
		assertEquals("((2/3)*x)",mul7.simplifier().toString());
		assertEquals("((1/6)*x)",mul8.simplifier().toString());
		assertEquals("(6*x)",mul51.simplifier().toString());
		assertEquals("((3/2)*x)",mul61.simplifier().toString());
		assertEquals("((2/3)*x)",mul71.simplifier().toString());
		assertEquals("((1/6)*x)",mul81.simplifier().toString());

		

		
	}

}
