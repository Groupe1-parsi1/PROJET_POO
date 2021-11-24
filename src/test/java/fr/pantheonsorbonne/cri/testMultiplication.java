package fr.pantheonsorbonne.cri;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testMultiplication {

	@Test
	void test1() {
		
		ExpressionArithmetique mulNN = new Multiplication(new ConstanteN(2), new ConstanteN(8));
		assertEquals("(2*8)",mulNN.toString());
		assertEquals("16", mulNN.simplifier().toString()); 
		
		
		ExpressionArithmetique mulQQ = new Multiplication(new ConstanteQ(2, 7), new ConstanteQ(4, 7));
		assertEquals("((2/7)*(4/7))",mulQQ.toString());
		assertEquals("(8/49)",mulQQ.simplifier().toString());
		
		ExpressionArithmetique mulNQ = new Multiplication(new ConstanteN(2), new ConstanteQ(4, 7));
		assertEquals("(2*(4/7))",mulNQ.toString());
		assertEquals("(8/7)",mulNQ.simplifier().toString());
		
		ExpressionArithmetique mulQN = new Multiplication(new ConstanteQ(4, 7), new ConstanteN(2));
		assertEquals("((4/7)*2)",mulQN.toString());
		assertEquals("(8/7)",mulQN.simplifier().toString());
		
		ExpressionArithmetique mulON = new Multiplication(ConstanteSymbolique.PI, new ConstanteN(5));
		assertEquals("(π*5)",mulON.toString());
		assertEquals("(π*5)",mulON.simplifier().toString());
		
		ExpressionArithmetique mul1 = new Multiplication(new ConstanteN(0), new ConstanteN(3));
		ExpressionArithmetique mul2 = new Multiplication(new ConstanteN(3), new ConstanteN(0));
		assertEquals("0",mul1.simplifier().toString());
		assertEquals("0",mul2.simplifier().toString());
	}
	
	@Test
	void testDerivation() {
		ConstanteN cst = new ConstanteN(3);
		
		ConstanteQ cstq = new ConstanteQ(3, 7);
		VariableInconnue x = new VariableInconnue("x");
		
		ExpressionArithmetique ex = new Multiplication(cst, x);
		ExpressionArithmetique mul = new Multiplication(x, cst);
		ExpressionArithmetique ex1 = new Multiplication(cstq, x);
		ExpressionArithmetique mul1 = new Multiplication(x, cstq);
		
		assertEquals("3", ex.deriver().toString());
		assertEquals("3", mul.deriver().toString());
		assertEquals("(3/7)", ex1.deriver().toString());
		assertEquals("(3/7)", mul1.deriver().toString());
		
	}
	

}
