package fr.pantheonsorbonne.cri;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



public class testConstanteQ {

	@Test
	public void test() {
		ConstanteQ  cons = new ConstanteQ(6, 8);
		assertEquals(6,cons.getNum());
		assertEquals(8,cons.getDenum());
		assertEquals("(6/8)",cons.toString());
		assertEquals("(3/4)",cons.simplifier().toString());
		
		ConstanteQ  cons1 = new ConstanteQ(4, 2);
		assertEquals("2",cons1.simplifier().toString());
		
		ConstanteQ  cons2 = new ConstanteQ(1, 3);
		assertEquals("(1/3)",cons2.simplifier().toString());
		
		assertFalse(cons.equals(cons2));
	}

}
