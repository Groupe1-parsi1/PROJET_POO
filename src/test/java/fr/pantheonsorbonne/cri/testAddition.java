package fr.pantheonsorbonne.cri;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testAddition {

	@Test 
	void test() {
		
		ExpressionArithmetique addNN = new Addition(new ConstanteN(2), new ConstanteN(8));
		assertEquals(addNN.toString(), "(2+8)");
		assertEquals(addNN.simplifier().toString(), "10");
		
		ExpressionArithmetique addQQ = new Addition(new ConstanteQ(2, 7), new ConstanteQ(4, 7));
		assertEquals(addQQ.toString(), "((2/7)+(4/7))");
		assertEquals(addQQ.simplifier().toString(), "(6/7)");
		
		ExpressionArithmetique addNQ = new Addition(new ConstanteN(2), new ConstanteQ(4, 7));
		assertEquals(addNQ.toString(), "(2+(4/7))");
		assertEquals(addNQ.simplifier().toString(), "(18/7)");
		
		ExpressionArithmetique addQN = new Addition(new ConstanteQ(4, 7), new ConstanteN(2));
		assertEquals(addQN.toString(), "((4/7)+2)");
		assertEquals(addQN.simplifier().toString(), "(18/7)");
		
		ExpressionArithmetique addON = new Addition(ConstanteSymbolique.PI, new ConstanteN(5));
		assertEquals(addON.toString(), "(π+5)");
		assertEquals(addON.simplifier().toString(), "(π+5)");
		
		//TEST Q5
		 ConstanteN cst1 = new ConstanteN(10);
		 ConstanteQ cst2 = new ConstanteQ(1, 2);
		 VariableInconnue cst3 = new VariableInconnue('x');
		 
		 ExpressionArithmetique add1 = new Addition(cst1, cst2);
		 ExpressionArithmetique add2 = new Addition(add1, cst3);
		 assertEquals(add2.toString(), "((10+(1/2))+x)");
		 assertEquals(add2.simplifier().toString(), "((21/2)+x)");
		 
		 ExpressionArithmetique add3 = new Addition(cst2, cst3);
		 ExpressionArithmetique add4 = new Addition(cst1, add3);
		 assertEquals(add4.toString(), "(10+((1/2)+x))");
		 assertEquals(add4.simplifier().toString(), "(10+((1/2)+x))");
		 
	}
 
}
