package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.ConstanteSymbolique.ConstantesSymboliqueConnues;

class testCalcul {

	@Test
	void test() {
		ExpressionArithmetique cal = new Addition(new ConstanteN(1), new ConstanteQ(3, 4));
		assertEquals("(1+(3/4))",cal.toString());
		assertEquals(1.7500, cal.calculer(),1e-4);
		
		ExpressionArithmetique cal1 = new Multiplication(new ConstanteN(1), new ConstanteQ(6, 9));
		assertEquals("(1*(6/9))",cal1.toString());
		assertEquals(0.6666, cal1.calculer(),1e-4);
		
		
		ConstanteSymbolique pi = new ConstanteSymbolique(ConstantesSymboliqueConnues.PI);
		ExpressionArithmetique cal2 = new Addition(new ConstanteN(1), pi);
		assertEquals("(1+π)",cal2.toString());
		assertEquals(4.1415, cal2.calculer(),1e-4);
		
		ExpressionArithmetique cal3 = new Division(new ConstanteN(1), new ConstanteN(6));
		assertEquals("(1/6)",cal3.toString());
		assertEquals(0.1666, cal3.calculer(),1e-4);
		
    	ExpressionArithmetique sinus = new Sin(new ConstanteN(90)); 
    	assertEquals("(sin(90))",sinus.toString());
    	assertEquals(0.8939, sinus.calculer(),1e-4);

    	ExpressionArithmetique cosinus = new Cos(new ConstanteN(30));
    	assertEquals("(cos(30))",cosinus.toString());
    	assertEquals(0.1542, cosinus.calculer(),1e-4);
    	
    	Puissance pow = new Puissance (new ConstanteN(2), new ConstanteQ(3, 4));
		assertEquals("(2^(3/4))",pow.toString());
		assertEquals(1.6817, pow.calculer(),1e-4);
		
		ExpressionArithmetique exp = new Exponentielle(new ConstanteN(1));
		assertEquals("(exp(1))",exp.toString());
		assertEquals(2.7182, exp.calculer(),1e-4);
		
		ExpressionArithmetique ln = new Ln(new ConstanteN(2));
		assertEquals("(ln(2))",ln.toString());
		assertEquals(0.6931, ln.calculer(),1e-4);
		
		ExpressionArithmetique sqrt = new Sqrt(new ConstanteN(3));
		assertEquals("(sqrt(3))",sqrt.toString());
		assertEquals(1.7320, sqrt.calculer(),1e-4);
		

	}

}
