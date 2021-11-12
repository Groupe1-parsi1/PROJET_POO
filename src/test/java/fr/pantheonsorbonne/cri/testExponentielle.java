package fr.pantheonsorbonne.cri;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class testExponentielle {

	@Test
	void test() { 
		
		ExpressionArithmetique expZero = new Exponentielle(new ConstanteN(0));
		assertEquals("(exp(0))",expZero.toString());
		assertEquals("1",expZero.simplifier().toString());
		
		ExpressionArithmetique expO = new Exponentielle(new ConstanteQ(2, 4));
		assertEquals("(exp((2/4)))",expO.toString());
		assertEquals("(exp((1/2)))",expO.simplifier().toString());
	}

}
