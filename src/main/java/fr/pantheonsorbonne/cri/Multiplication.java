package fr.pantheonsorbonne.cri;

public class Multiplication extends OpBinaire {

    public Multiplication(ExpressionArithmetique left, ExpressionArithmetique right) {
        super(left, right, "*");
    }


    @Override
    protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteN valRight) {
    	if(valLeft.value == 0 || valRight.value == 0)
    		return new ConstanteN(0);
        return new ConstanteN(valLeft.value * valRight.value);
    }

    @Override
    protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ConstanteQ valRight) {
    	if(valLeft.num == 0 || valRight.num == 0)
    		return new ConstanteN(0);
        return new ConstanteQ(valLeft.getNum() * valRight.getNum(), valLeft.getDenum() * valRight.getDenum()).simplifier();
    }

    @Override
    protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteQ valRight) {
    	if(valLeft.value == 0 || valRight.num == 0)
    		return new ConstanteN(0);
        return new ConstanteQ(valLeft.value * valRight.getNum(), valRight.getDenum());
    }
    
    @Override
   	public double calculer() {
   		return this.left.calculer() * this.right.calculer();

   	}


	@Override
	public ExpressionArithmetique deriver() {
		if((this.left instanceof ConstanteN && this.right instanceof VariableInconnue) || 
			(this.left instanceof ConstanteQ && this.right instanceof VariableInconnue)	)
			return this.left;
		else if ((this.right instanceof ConstanteN && this.left instanceof VariableInconnue) ||
				(this.right instanceof ConstanteQ && this.left instanceof VariableInconnue))
			return this.right;
		else {
			
			ExpressionArithmetique derLef = new Multiplication(this.left.deriver(), this.right).simplifier();
			ExpressionArithmetique derRigh = new Multiplication(this.left,this.right.deriver().simplifier()).simplifier();
	
			ExpressionArithmetique res = new Addition(derLef, derRigh).simplifier();
			Addition tmp = (Addition) res;
			if(tmp.left instanceof ConstanteN) {
				ConstanteN tmp1 = (ConstanteN) tmp.left;
				if(tmp1.value == 0)
					return tmp.right;
			}else if(tmp.left instanceof ConstanteQ) {
				ConstanteQ tmp1 = (ConstanteQ) tmp.left; 
				if(tmp1.num == 0)
					return tmp.right;
			}else if(tmp.right instanceof ConstanteN) {
				ConstanteN tmp1 = (ConstanteN) tmp.right;
				if(tmp1.value == 0)
					return tmp.left;
			}else if(tmp.right instanceof ConstanteQ) {
				ConstanteQ tmp1 = (ConstanteQ) tmp.right;
				if(tmp1.num == 0)
					return tmp.left;
			}
			return res;
		
		}
	}
	
	@Override
	public ExpressionArithmetique deriver(int n) {
		ExpressionArithmetique tmp = this.simplifier();
		for(int i = 0; i < n; i++)
			tmp = tmp.deriver();
		return tmp;
	}
	
	
	@Override
	protected ExpressionArithmetique simplifier(ExpressionArithmetique valLeft, ConstanteN valRight) {
		if(valRight.value == 0)
			return new ConstanteN(0);
		if(valRight.value == 1)
			return valLeft;
		if(valLeft instanceof Multiplication) {
			Multiplication mul = (Multiplication) valLeft.simplifier();
			if(mul.right instanceof ConstanteN)
				return new Multiplication(new Multiplication(valRight, mul.right).simplifier(), mul.left);
			else if(mul.right instanceof ConstanteQ)
				return new Multiplication(new Multiplication(valRight, mul.right).simplifier(), mul.left);
			else if((mul.left instanceof ConstanteN) || (mul.left instanceof ConstanteQ))
				return new Multiplication(new Multiplication(valRight, mul.left).simplifier(), mul.right);
		}
		return this;
	}

	@Override
	protected ExpressionArithmetique simplifier(ExpressionArithmetique valLeft, ConstanteQ valRight) {
		if(valLeft instanceof Multiplication) {
			Multiplication mul = (Multiplication) valLeft.simplifier();
			if(mul.right instanceof ConstanteN)
				return new Multiplication(new Multiplication(valRight, mul.right).simplifier(), mul.left);
			else if(mul.right instanceof ConstanteQ)
				return new Multiplication(new Multiplication(valRight, mul.right).simplifier(), mul.left);
			else if((mul.left instanceof ConstanteN ) || (mul.left instanceof ConstanteQ)) {
				return new Multiplication(new Multiplication(valRight, mul.left).simplifier(), mul.right);
			}
		}
		return this;
	}


	@Override
	protected ExpressionArithmetique simplifier(ConstanteN valLeft, ExpressionArithmetique valRight) {
		if(valLeft.value == 0)
			return new ConstanteN(0);
		if(valLeft.value == 1)
			return valRight;
		if(valRight instanceof Multiplication) {
			Multiplication mul = (Multiplication) valRight.simplifier();
			if(mul.right instanceof ConstanteN)
				return new Multiplication(new Multiplication(valLeft, mul.right).simplifier(), mul.left);
			else if(mul.right instanceof ConstanteQ)
				return new Multiplication(new Multiplication(valLeft, mul.right).simplifier(), mul.left);
			else if(mul.left instanceof ConstanteN)
				return new Multiplication(new Multiplication(mul.left, valLeft).simplifier(), mul.right);
			else if(mul.left instanceof ConstanteQ )
				return new Multiplication(new Multiplication(mul.left, valLeft).simplifier(), mul.right);
			else
				return new Multiplication(valLeft, valRight.simplifier());
		}
		return this;
	}


	@Override
	protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ExpressionArithmetique valRight) {
		if(valRight instanceof Multiplication) {
			Multiplication mul = (Multiplication) valRight.simplifier();
			if(mul.right instanceof ConstanteN)
				return new Multiplication(new Multiplication(valLeft, mul.right).simplifier(), mul.left);
			else if( mul.right instanceof ConstanteQ)
				return new Multiplication(new Multiplication(valLeft, mul.right).simplifier(), mul.left);
			else if(mul.left instanceof ConstanteN)
				return new Multiplication(new Multiplication(mul.left, valLeft).simplifier(), mul.right);
			else if(mul.left instanceof ConstanteQ)
				return new Multiplication(new Multiplication(mul.left, valLeft).simplifier(), mul.right);
		}
		return this;
	}
}
