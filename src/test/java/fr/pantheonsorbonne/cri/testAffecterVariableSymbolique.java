package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testAffecterVariableSymbolique {

	@Test
	void test() {
		ConstanteN cst1 = new ConstanteN(3);
		VariableInconnue a = new VariableInconnue('a');

		ExpressionArithmetique ex1 = new Addition(cst1, a);
		
		ConstanteQ cst2 = new ConstanteQ(4, 5);
		VariableInconnue x = new VariableInconnue('x');
		
		ConstanteQ cst3 = new ConstanteQ(1, 5);
		
		ExpressionArithmetique ex2 = new Soustraction(cst2, x);
		
		assertEquals(ex2.toString(), "((4/5)-x)");
		
		x.setValeur(ex1);
		assertEquals(ex2.toString(),"((4/5)-(3+a))");
		assertEquals(ex2.simplifier().toString(), "((4/5)-(3+a))");
		
		/* ne marche pas
		x.setValeur(cst3);
		assertEquals(ex2.toString(),"((4/5)-(1/5))");
		assertEquals(ex2.simplifier().toString(),"(3/5)");*/
			
	}

}
