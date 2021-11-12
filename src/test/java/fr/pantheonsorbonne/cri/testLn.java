package fr.pantheonsorbonne.cri;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testLn {

	@Test
	void test() {
		
		ExpressionArithmetique lnUn = new Ln(new ConstanteN(1));
		assertEquals("(ln(1))",lnUn.toString());
		assertEquals("0",lnUn.simplifier().toString());
		
		ExpressionArithmetique lnE = new Ln(ConstanteSymbolique.E);
		assertEquals("(ln(e))", lnE.toString());
		assertEquals("1", lnE.simplifier().toString());
		
		ExpressionArithmetique lnO = new Ln(new ConstanteQ(2, 4));
		assertEquals("(ln((2/4)))",lnO.toString());
		assertEquals("(ln((1/2)))",lnO.simplifier().toString());
	}

}
