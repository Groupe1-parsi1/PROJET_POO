package fr.pantheonsorbonne.cri;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.ConstanteN;

 class testConstanteN {

	@Test
	 void test() {
		ConstanteN  cons = new ConstanteN(6);
		assertEquals(6,cons.value);
		assertEquals( "6",cons.toString());
		assertEquals("6",cons.simplifier().toString());
		
		//test derivation
		assertEquals("0", cons.deriver().toString());
		assertEquals("0", cons.deriver(2).toString());
	} 
}
