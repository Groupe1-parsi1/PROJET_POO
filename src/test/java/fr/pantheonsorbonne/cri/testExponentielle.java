package fr.pantheonsorbonne.cri;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class testExponentielle {

	@Test
	void test() { 
		
		ExpressionArithmetique expZero = new Exponentielle(new ConstanteN(0));
		assertEquals(expZero.toString(), "(exp(0))");
		assertEquals(expZero.simplifier().toString(), "1");
		
		ExpressionArithmetique expO = new Exponentielle(new ConstanteQ(2, 4));
		assertEquals(expO.toString(), "(exp((2/4)))");
		assertEquals(expO.simplifier().toString(), "(exp((1/2)))");
	}

}
