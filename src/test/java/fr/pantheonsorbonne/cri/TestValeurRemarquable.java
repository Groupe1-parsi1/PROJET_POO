package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.ConstanteSymbolique.ConstantesSymboliqueConnues;

class TestValeurRemarquable {

	@Test
	void test() {
		
		ExpressionArithmetique ln = new Ln(new ConstanteN(1));
		ExpressionArithmetique addition = new Addition(new ConstanteN(1), ln);
		assertEquals("1",addition.simplifier().toString(), "1");
		
		ExpressionArithmetique exp = new Exponentielle(new ConstanteN(0));
		ExpressionArithmetique addition1 = new Addition(new ConstanteN(1), exp);
		assertEquals( "2",addition1.simplifier().toString());
		
	 	ConstanteSymbolique pi = new ConstanteSymbolique(ConstantesSymboliqueConnues.PI);
	 	ExpressionArithmetique division = new Division(pi, new ConstanteN(2));
		ExpressionArithmetique sin = new Sin(division);
		ExpressionArithmetique addition2 = new Addition(new ConstanteN(1), sin);
		assertEquals(2, addition2.calculer(),1e-0);
		 
		ExpressionArithmetique sqrt = new Sqrt(new ConstanteN(4));
		assertEquals("2",sqrt.simplifier().toString());
		
	} 
}
	