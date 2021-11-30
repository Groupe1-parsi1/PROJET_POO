package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestVariableIndex {

	@Test
	void test1() {
		ExpressionArithmetique index = new VariableInconnue("i");
		VariableIndex a = new VariableIndex("α", index);
		assertEquals("αi", a.simplifier().toString());
		assertEquals("i", a.getIndex().toString());
		
		VariableIndex b = new VariableIndex("α", index);
		VariableIndex c = new VariableIndex("a", index);
		ConstanteN n = new ConstanteN(0);
		
		assertNotEquals(b, n);
		assertNotEquals(null, a);
		assertEquals(a, b);
		assertNotEquals(a, c);
		
		//assertEquals(a, a);
		
		assertEquals(a.hashCode(), b.hashCode());
		
		
		VariableIndex var = new VariableIndex(null, index);
		VariableIndex var1 = new VariableIndex(null, index);
		assertNotEquals(var, a);
		assertEquals(var, var1);
		
	}

}
