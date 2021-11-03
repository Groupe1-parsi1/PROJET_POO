package fr.pantheonsorbonne.cri;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testLn {

	@Test
	void test() {
		
		ExpressionArithmetique lnUn = new Ln(new ConstanteN(1));
		assertEquals(lnUn.toString(), "(ln(1))");
		assertEquals(lnUn.simplifier().toString(), "0");
		
		ExpressionArithmetique lnE = new Ln(ConstanteSymbolique.E);
		assertEquals(lnE.toString(), "(ln(e))");
		assertEquals(lnE.simplifier().toString(), "1");
		
		ExpressionArithmetique lnO = new Ln(new ConstanteQ(2, 4));
		assertEquals(lnO.toString(), "(ln((2/4)))");
		assertEquals(lnO.simplifier().toString(), "(ln((1/2)))");
	}

}
