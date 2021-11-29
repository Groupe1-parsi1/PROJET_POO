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
		
		assertNotEquals(null, a);
		assertEquals(a, b);
		assertNotEquals(a, c);
		
		VariableIndex var = new VariableIndex(null, index);
		assertNotEquals(var, a);
		
	}

}
