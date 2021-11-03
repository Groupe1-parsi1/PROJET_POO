package fr.pantheonsorbonne.cri;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



public class testConstanteQ {

	@Test
	public void test() {
		ConstanteQ  cons = new ConstanteQ(6, 8);
		assertEquals(cons.getNum(), 6);
		assertEquals(cons.getDenum(), 8);
		assertEquals(cons.toString(), "(6/8)");
		assertEquals(cons.simplifier().toString(), "(3/4)");
		
		ConstanteQ  cons1 = new ConstanteQ(4, 2);
		assertEquals(cons1.simplifier().toString(), "2");
		
		ConstanteQ  cons2 = new ConstanteQ(1, 3);
		assertEquals(cons2.simplifier().toString(), "(1/3)");
		
		assertFalse(cons.equals(cons2));
	}

}
