package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.ConstanteSymbolique.ConstantesSymboliqueConnues;

class testValeurRemarquable {

	@Test
	void test() {
		
		ExpressionArithmetique ln = new Ln(new ConstanteN(1));
		ExpressionArithmetique addition = new Addition(new ConstanteN(1), ln);
		assertEquals(addition.simplifier().toString(), "1");
		
		ExpressionArithmetique exp = new Exponentielle(new ConstanteN(0));
		ExpressionArithmetique addition1 = new Addition(new ConstanteN(1), exp);
		assertEquals(addition1.simplifier().toString(), "2");
		
		/* ne marche pas
		ConstanteSymbolique pi = new ConstanteSymbolique(ConstantesSymboliqueConnues.PI);
		ExpressionArithmetique sin = new Sin(new ConstanteQ(pi, 2));
		ExpressionArithmetique addition2 = new Addition(new ConstanteN(1), sin);
		assertEquals(addition2.simplifier().toString(), "2");*/
		
		ExpressionArithmetique sqrt = new Sqrt(new ConstanteN(4));
		assertEquals(sqrt.simplifier().toString(), "2");
	} 
}
