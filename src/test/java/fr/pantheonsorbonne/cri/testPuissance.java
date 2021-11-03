package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testPuissance {

	@Test
	void test() {
		Puissance p = new Puissance(new ConstanteN(2), new ConstanteN(3));
		assertEquals(p.toString(),"(2^3)");
		assertEquals(p.simplifier().toString(), "8");
		
		Puissance p1 = new Puissance (new ConstanteQ(2, 3), new ConstanteN(3));
		assertEquals(p1.toString(), "((2/3)^3)");
		assertEquals(p1.simplifier().toString(), "(8/27)");
		
		Puissance p2 = new Puissance (new ConstanteQ(2, 3), new ConstanteQ(3, 4));
		assertEquals(p2.toString(), "((2/3)^(3/4))");
		assertEquals(p2.simplifier().toString(), "((2/3)^(3/4))");
		
		Puissance p3 = new Puissance (new ConstanteN(2), new ConstanteQ(3, 4));
		assertEquals(p3.toString(), "(2^(3/4))");
		assertEquals(p3.simplifier().toString(), "(2^(3/4))");
	}

}
