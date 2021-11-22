package fr.pantheonsorbonne.cri;

public class Sin extends OpUnaire {

	public Sin(ExpressionArithmetique op) {
		super(op, "sin");
	}

	@Override
	public ExpressionArithmetique simplifier() {
		 ExpressionArithmetique val = this.value.simplifier();
	        if (val instanceof ConstanteSymbolique) {
	            ConstanteSymbolique sinu = (ConstanteSymbolique) val;
	            if (sinu.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI)
	                return new ConstanteN(0);  
	        }
	        if (val instanceof ConstanteN) {
	            ConstanteN value = (ConstanteN) val;
	            if (value.value == 0)
	                return new ConstanteN(0);
	            else if (value.value == 90)
	            	return new ConstanteN(1);
	            else if (value.value == -90)
	            	return new ConstanteN(-1);
	            else if (value.value == 30 || value.value == 150)
	            	return new ConstanteQ(1, 2);
	            else if (value.value == -30 || value.value == -150)
	            	return new ConstanteQ(-1, 2);
	        }
	        if(val instanceof Division) {
	        	Division div = (Division) val;
	        	if(div.left instanceof ConstanteSymbolique) {
	        		ConstanteSymbolique piLeft = (ConstanteSymbolique)div.left;
	        		if(div.right instanceof ConstanteN) {
	        			ConstanteN cstRight = (ConstanteN) div.right;
	        			if(piLeft.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI && cstRight.value == 2)
	        				return new ConstanteN(1);
	        			else if(piLeft.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI && cstRight.value == -2)
	        				return new ConstanteN(-1);
	        			else if(piLeft.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI && cstRight.value == 6)
	        				return new ConstanteQ(1,2);
	        			else if(piLeft.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI && cstRight.value == -6)
	        				return new ConstanteQ(-1, 2);
	        			else if(piLeft.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI && cstRight.value == 3)
	        				return new Division(new Sqrt(new ConstanteN(3)),new ConstanteN(2));
	        			else if(piLeft.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI && cstRight.value == 4)
	        				return new Division(new Sqrt(new ConstanteN(2)),new ConstanteN(2));
	        			else if(piLeft.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI && cstRight.value == -3)
	        				return new Division(new Sqrt(new ConstanteN(3)),new ConstanteN(-2));
	        			else if(piLeft.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI && cstRight.value == -4)
	        				return new Division(new Sqrt(new ConstanteN(2)),new ConstanteN(-2)); 
	        				
	        		}
	        	}
	        }
	        return new Sin(val);
	}
	
	@Override
	public double calculer() {
		return Math.sin(this.value.calculer());
	}

	@Override
	public ExpressionArithmetique deriver() {
		return new Multiplication(value.deriver(), new Cos(value));
	}

}
