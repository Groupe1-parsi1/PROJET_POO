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
		assertEquals(mulNN.toString(), "(2*8)");
		assertEquals(mulNN.simplifier().toString(), "16");
		
		ExpressionArithmetique mulQQ = new Multiplication(new ConstanteQ(2, 7), new ConstanteQ(4, 7));
		assertEquals(mulQQ.toString(), "((2/7)*(4/7))");
		assertEquals(mulQQ.simplifier().toString(), "(8/49)");
		
		ExpressionArithmetique mulNQ = new Multiplication(new ConstanteN(2), new ConstanteQ(4, 7));
		assertEquals(mulNQ.toString(), "(2*(4/7))");
		assertEquals(mulNQ.simplifier().toString(), "(8/7)");
		
		ExpressionArithmetique mulQN = new Multiplication(new ConstanteQ(4, 7), new ConstanteN(2));
		assertEquals(mulQN.toString(), "((4/7)*2)");
		assertEquals(mulQN.simplifier().toString(), "(8/7)");
		
		ExpressionArithmetique mulON = new Multiplication(ConstanteSymbolique.PI, new ConstanteN(5));
		assertEquals(mulON.toString(), "(π*5)");
		assertEquals(mulON.simplifier().toString(), "(π*5)");
	}

}
