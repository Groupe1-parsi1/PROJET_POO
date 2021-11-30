package fr.pantheonsorbonne.cri;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.ConstanteN;
import fr.pantheonsorbonne.cri.ConstanteQ;
import fr.pantheonsorbonne.cri.ExpressionArithmetique;
import fr.pantheonsorbonne.cri.Soustraction;

class TestSoustraction {

	@Test
	void test() {
		ConstanteN cst1 = new ConstanteN(3);
    	ConstanteN cst2 = new ConstanteN(5);
    	ConstanteQ cst3 = new ConstanteQ(5, 2);
    	ConstanteQ cst4 = new ConstanteQ(9, 2);
    	
    	ExpressionArithmetique sous1a = new Soustraction(cst1, cst2);
    	assertEquals("(3-5)",sous1a.toString());
    	assertEquals("-2",sous1a.simplifier().toString());
    	
    	ExpressionArithmetique sous1b = new Soustraction(cst2, cst1);
    	assertEquals("2",sous1b.simplifier().toString());
    	
    	ExpressionArithmetique sous2a = new Soustraction(cst3, cst4);
    	assertEquals("((5/2)-(9/2))",sous2a.toString());
    	assertEquals("-2",sous2a.simplifier().toString());
    	
    	ExpressionArithmetique sous2b = new Soustraction(cst4, cst3);
    	assertEquals("2",sous2b.simplifier().toString());
    	
    	ExpressionArithmetique sous3 = new Soustraction(cst3, cst2);
    	assertEquals("((5/2)-5)",sous3.toString());
    	assertEquals("(-5/2)",sous3.simplifier().toString());
    	
    	ExpressionArithmetique sous4 = new Soustraction(cst2, cst3);
    	assertEquals("(5-(5/2))",sous4.toString());
    	assertEquals("(5/2)",sous4.simplifier().toString());
    	
    	
    	//test q5
    	 ConstanteN sous1 = new ConstanteN(10);
		 ConstanteQ sous2 = new ConstanteQ(1, 2);
		 VariableInconnue sous3a = new VariableInconnue("x");
		 
		 ExpressionArithmetique s1 = new Addition(sous1, sous2);
		 ExpressionArithmetique s2 = new Soustraction(s1, sous3a);
		 assertEquals("((10+(1/2))-x)",s2.toString());
		 assertEquals("((21/2)-x)",s2.simplifier().toString());
		 
		 ExpressionArithmetique s3 = new Soustraction(sous2, sous3a);
		 ExpressionArithmetique s4 = new Soustraction(sous1, s3);
		 assertEquals( "(10-((1/2)-x))",s4.toString());
		 assertEquals("(10-((1/2)-x))",s4.simplifier().toString());
		 
		 ConstanteQ sou1 = new ConstanteQ(4, 7);
		 ConstanteQ sou2 = new ConstanteQ(2, 7);
		 ExpressionArithmetique sou3 = new Soustraction(sou1, sou2);
		 assertEquals("(2/7)",sou3.simplifier().toString());
		 

    	ConstanteN cstan1 = new ConstanteN(3);
    	ConstanteN cstan2 = new ConstanteN(4);
    	ExpressionArithmetique expres = new Soustraction(sous3a, cstan1);
    	ExpressionArithmetique soustrax = new Soustraction(expres, cstan2);
    	assertEquals("((x-3)-4)",soustrax.simplifier().toString());
    	
    	
	}

}
