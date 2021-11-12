package fr.pantheonsorbonne.cri;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class testConstanteSymbolique {

    @Test
    public void test() {
        assertEquals("π",ConstanteSymbolique.ConstantesSymboliqueConnues.PI.getStrPresentation());
        assertEquals( "e",ConstanteSymbolique.ConstantesSymboliqueConnues.EXPONENTIELLE.getStrPresentation());
        assertEquals("π",new ConstanteSymbolique(ConstanteSymbolique.ConstantesSymboliqueConnues.PI).simplifier().toString());
        assertEquals("e",new ConstanteSymbolique(ConstanteSymbolique.ConstantesSymboliqueConnues.EXPONENTIELLE).simplifier().toString());
    }

}
 