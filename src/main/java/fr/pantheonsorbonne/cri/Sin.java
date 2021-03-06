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
	            return simplifier(value);
	        }
	        if(val instanceof Division) {
	        	Division div = (Division) val;
	        	if(div.left instanceof ConstanteSymbolique) {
	        		ConstanteSymbolique piLeft = (ConstanteSymbolique)div.left;
	        		if(div.right instanceof ConstanteN) {
	        			ConstanteN cstRight = (ConstanteN) div.right;
	        			if(piLeft.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI) {
	        				if(cstRight.value == 2) {
	        					return new ConstanteN(1);
	        				} else if (cstRight.value == -2) {
	        					return new ConstanteN(-1);
	        				} else if(cstRight.value == 6) {
	        					return new ConstanteQ(1,2);
	        				} else if (cstRight.value == -6) {
	        					return new ConstanteQ(-1, 2);
	        				} else if (cstRight.value == 3) {
	        					return new Division(new Sqrt(new ConstanteN(3)),new ConstanteN(2));
	        				} else if (cstRight.value == 4) {
	        					return new Division(new Sqrt(new ConstanteN(2)),new ConstanteN(2));
	        				} else if (cstRight.value == -3) {
	        					return new Division(new Sqrt(new ConstanteN(3)),new ConstanteN(-2));
	        				} else if(cstRight.value == -4) {
	        					return new Division(new Sqrt(new ConstanteN(2)),new ConstanteN(-2));
	        				}
	        			}
	        				
	        		}
	        	}
	        }
	        return new Sin(val);
	}
	
	public ExpressionArithmetique simplifier(ConstanteN value) {
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
		return this;
	}
	
	@Override
	public double calculer() {
		return Math.sin(this.value.calculer());
	}

	@Override
	public ExpressionArithmetique deriver() {
		return new Multiplication(value.deriver().simplifier(), new Cos(value)).simplifier();
	}
	
	@Override
	public ExpressionArithmetique deriver(int n) {
		ExpressionArithmetique tmp = this.simplifier();
		for(int i = 0; i < n; i++)
			tmp = tmp.deriver();
		return tmp;
	}

}
