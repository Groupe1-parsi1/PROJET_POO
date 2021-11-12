package fr.pantheonsorbonne.cri;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testMultiplication {

	@Test
	void test() {
		
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
	}

}
