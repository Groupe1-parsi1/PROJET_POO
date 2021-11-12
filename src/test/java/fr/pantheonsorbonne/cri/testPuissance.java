package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testPuissance {

	@Test
	void test() {
		Puissance p = new Puissance(new ConstanteN(2), new ConstanteN(3));
		assertEquals("(2^3)",p.toString());
		assertEquals("8",p.simplifier().toString());
		
		Puissance p1 = new Puissance (new ConstanteQ(2, 3), new ConstanteN(3));
		assertEquals("((2/3)^3)",p1.toString());
		assertEquals( "(8/27)",p1.simplifier().toString());
		
		Puissance p2 = new Puissance (new ConstanteQ(2, 3), new ConstanteQ(3, 4));
		assertEquals("((2/3)^(3/4))",p2.toString());
		assertEquals("((2/3)^(3/4))",p2.simplifier().toString());
		
		Puissance p3 = new Puissance (new ConstanteN(2), new ConstanteQ(3, 4));
		assertEquals("(2^(3/4))",p3.toString());
		assertEquals("(2^(3/4))",p3.simplifier().toString());
	}

}
