package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testVariableIndex {

	@Test
	void test1() {
		ExpressionArithmetique index = new VariableInconnue("i");
		VariableIndex a = new VariableIndex("α", index);
		assertEquals("αi", a.simplifier().toString());
		assertEquals("i", a.getIndex().toString());
		
	}

}
