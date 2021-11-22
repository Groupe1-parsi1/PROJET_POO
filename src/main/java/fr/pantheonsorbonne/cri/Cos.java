package fr.pantheonsorbonne.cri;

public class Cos extends OpUnaire {

    public Cos(ExpressionArithmetique op) {
        super(op, "cos");
    }
   
    @Override
    public ExpressionArithmetique simplifier() {
        ExpressionArithmetique val = this.value.simplifier();
        if (val instanceof ConstanteSymbolique) {
            ConstanteSymbolique cons = (ConstanteSymbolique) val;
            if (cons.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI)
                return new ConstanteN(-1);
        }
        if (val instanceof ConstanteN) {
            ConstanteN value = (ConstanteN) val;
            if (value.value == 90 || value.value == -90)
                return new ConstanteN(0);
            else if (value.value == 0)
            	return new ConstanteN(1);
            else if(value.value == 60 || value.value == -60)
            	return new ConstanteQ(1, 2);
            else if(value.value == 120 || value.value == -120)
            	return new ConstanteQ(-1, 2);
        }
        if(val instanceof Division) {
        	Division div = (Division) val;
        	if(div.left instanceof ConstanteSymbolique) {
        		ConstanteSymbolique piLeft = (ConstanteSymbolique)div.left;
        		if(div.right instanceof ConstanteN) {
        			ConstanteN cstRight = (ConstanteN) div.right;
        			if(piLeft.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI && cstRight.value == 2)
        				return new ConstanteN(0);
        			else if(piLeft.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI && cstRight.value == -2)
        				return new ConstanteN(0);
        			else if(piLeft.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI && cstRight.value == 6)
        				return new Division(new Sqrt(new ConstanteN(3)),new ConstanteN(2));
        			else if(piLeft.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI && cstRight.value == -6)
        				return new Division(new Sqrt(new ConstanteN(3)),new ConstanteN(2));
        			else if(piLeft.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI && cstRight.value == 3)
        				return new ConstanteQ(1, 2);
        			else if(piLeft.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI && cstRight.value == 4)
        				return new Division(new Sqrt(new ConstanteN(2)),new ConstanteN(2));
        			else if(piLeft.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI && cstRight.value == -3)
        				return new ConstanteQ(1, 2);
        			else if(piLeft.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI && cstRight.value == -4)
        				return new Division(new Sqrt(new ConstanteN(2)),new ConstanteN(2)); 
        				
        		}
        	}
        }
        return new Cos(val);
    }
    
    @Override
   	public double calculer() {
   		return Math.cos(this.value.calculer());
   	}

	@Override
	public ExpressionArithmetique deriver() {
		
		return new Multiplication(new Multiplication(new ConstanteN(-1),this.value.deriver()),new Sin(value));

	}
}
