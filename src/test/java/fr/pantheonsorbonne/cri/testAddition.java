package fr.pantheonsorbonne.cri;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testAddition {

	@Test 
	void test() {
		
		ExpressionArithmetique addNN = new Addition(new ConstanteN(2), new ConstanteN(8));
		assertEquals("(2+8)",addNN.toString());
		assertEquals("10",addNN.simplifier().toString());
		
		ExpressionArithmetique addQQ = new Addition(new ConstanteQ(2, 7), new ConstanteQ(4, 7));
		assertEquals("((2/7)+(4/7))",addQQ.toString());
		assertEquals("(6/7)",addQQ.simplifier().toString());
		
		ExpressionArithmetique addNQ = new Addition(new ConstanteN(2), new ConstanteQ(4, 7));
		assertEquals("(2+(4/7))",addNQ.toString());
		assertEquals("(18/7)",addNQ.simplifier().toString());
		
		ExpressionArithmetique addQN = new Addition(new ConstanteQ(4, 7), new ConstanteN(2));
		assertEquals("((4/7)+2)",addQN.toString());
		assertEquals("(18/7)",addQN.simplifier().toString());
		
		ExpressionArithmetique addON = new Addition(ConstanteSymbolique.PI, new ConstanteN(5));
		assertEquals("(π+5)",addON.toString());
		assertEquals("(π+5)",addON.simplifier().toString());
		
		//TEST Q5
		 ConstanteN cst1 = new ConstanteN(10);
		 ConstanteQ cst2 = new ConstanteQ(1, 2);
		 VariableInconnue cst3 = new VariableInconnue('x');
		 
		 ExpressionArithmetique add1 = new Addition(cst1, cst2);
		 ExpressionArithmetique add2 = new Addition(add1, cst3);
		 assertEquals("((10+(1/2))+x)",add2.toString());
		 assertEquals("((21/2)+x)",add2.simplifier().toString());
		 
		 ExpressionArithmetique add3 = new Addition(cst2, cst3);
		 ExpressionArithmetique add4 = new Addition(cst1, add3);
		 assertEquals("(10+((1/2)+x))",add4.toString());
		 assertEquals("(x+(21/2))",add4.simplifier().toString());
		
	}
 
}
