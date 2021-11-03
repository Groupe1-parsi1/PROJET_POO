package fr.pantheonsorbonne.cri;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class testConstanteSymbolique {

    @Test
    public void test() {
        assertEquals(ConstanteSymbolique.ConstantesSymboliqueConnues.PI.getStrPresentation(), "π");
        assertEquals(ConstanteSymbolique.ConstantesSymboliqueConnues.EXPONENTIELLE.getStrPresentation(), "e");
        assertEquals(new ConstanteSymbolique(ConstanteSymbolique.ConstantesSymboliqueConnues.PI).simplifier().toString(), "π");
        assertEquals(new ConstanteSymbolique(ConstanteSymbolique.ConstantesSymboliqueConnues.EXPONENTIELLE).simplifier().toString(), "e");
    }

}
