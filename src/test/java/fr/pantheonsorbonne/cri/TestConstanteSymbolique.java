package fr.pantheonsorbonne.cri;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.ConstanteSymbolique.ConstantesSymboliqueConnues;

 class TestConstanteSymbolique {

    @Test
    void test() {
        assertEquals("π",ConstanteSymbolique.ConstantesSymboliqueConnues.PI.getStrPresentation());
        assertEquals( "e",ConstanteSymbolique.ConstantesSymboliqueConnues.EXPONENTIELLE.getStrPresentation());
        assertEquals("π",new ConstanteSymbolique(ConstanteSymbolique.ConstantesSymboliqueConnues.PI).simplifier().toString());
        assertEquals("e",new ConstanteSymbolique(ConstanteSymbolique.ConstantesSymboliqueConnues.EXPONENTIELLE).simplifier().toString());
        
        ConstanteSymbolique pi = new ConstanteSymbolique(ConstantesSymboliqueConnues.PI);
        assertEquals("0", pi.deriver().toString());
        assertEquals("0", pi.deriver(2).toString());
    }

}
 