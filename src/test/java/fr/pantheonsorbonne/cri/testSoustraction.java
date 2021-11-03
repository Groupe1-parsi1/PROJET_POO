package fr.pantheonsorbonne.cri;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.ConstanteN;
import fr.pantheonsorbonne.cri.ConstanteQ;
import fr.pantheonsorbonne.cri.ExpressionArithmetique;
import fr.pantheonsorbonne.cri.Soustraction;

class testSoustraction {

	@Test
	void test() {
		ConstanteN cst1 = new ConstanteN(3);
    	ConstanteN cst2 = new ConstanteN(5);
    	ConstanteQ cst3 = new ConstanteQ(5, 2);
    	ConstanteQ cst4 = new ConstanteQ(9, 2);
    	
    	ExpressionArithmetique sous1a = new Soustraction(cst1, cst2);
    	assertEquals(sous1a.toString(),"(3-5)");
    	assertEquals(sous1a.simplifier().toString(), "-2");
    	
    	ExpressionArithmetique sous1b = new Soustraction(cst2, cst1);
    	assertEquals(sous1b.simplifier().toString(), "2");
    	
    	ExpressionArithmetique sous2a = new Soustraction(cst3, cst4);
    	assertEquals(sous2a.toString(), "((5/2)-(9/2))");
    	assertEquals(sous2a.simplifier().toString(), "-2");
    	
    	ExpressionArithmetique sous2b = new Soustraction(cst4, cst3);
    	assertEquals(sous2b.simplifier().toString(), "2");
    	
    	ExpressionArithmetique sous3 = new Soustraction(cst3, cst2);
    	assertEquals(sous3.toString(), "((5/2)-5)");
    	assertEquals(sous3.simplifier().toString(), "(-5/2)");
    	
    	ExpressionArithmetique sous4 = new Soustraction(cst2, cst3);
    	assertEquals(sous4.toString(), "(5-(5/2))");
    	assertEquals(sous4.simplifier().toString(), "(5/2)");
    	
    	//test q5
    	 ConstanteN sous1 = new ConstanteN(10);
		 ConstanteQ sous2 = new ConstanteQ(1, 2);
		 VariableInconnue sous3a = new VariableInconnue('x');
		 
		 ExpressionArithmetique s1 = new Addition(sous1, sous2);
		 ExpressionArithmetique s2 = new Soustraction(s1, sous3a);
		 assertEquals(s2.toString(), "((10+(1/2))-x)");
		 assertEquals(s2.simplifier().toString(), "((21/2)-x)");
		 
		 ExpressionArithmetique s3 = new Soustraction(sous2, sous3a);
		 ExpressionArithmetique s4 = new Soustraction(sous1, s3);
		 assertEquals(s4.toString(), "(10-((1/2)-x))");
		 assertEquals(s4.simplifier().toString(), "(10-((1/2)-x))");

    	
    	
    	
	}

}
