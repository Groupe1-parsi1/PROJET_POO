package fr.pantheonsorbonne.cri;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.ConstanteN;

public class testConstanteN {

	@Test
	public void test() {
		ConstanteN  cons = new ConstanteN(6);
		assertEquals(cons.value, 6);
		assertEquals(cons.toString(), "6");
		assertEquals(cons.simplifier().toString(), "6");
	} 
}
