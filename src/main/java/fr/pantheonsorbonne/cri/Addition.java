package fr.pantheonsorbonne.cri;


public class Addition extends OpBinaire {

    public Addition(ExpressionArithmetique left, ExpressionArithmetique right) {
        super(left, right, "+");
    }


    @Override
    protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteN valRight) {

        return new ConstanteN(valLeft.value + valRight.value);
    }
    @Override
    protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ConstanteN valRight) {

    	 return simplifier(new ConstanteQ(valRight.value, 1), valLeft);
    }
    

    @Override
    protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ConstanteQ valRight) {

        long num = valLeft.getNum() * valRight.getDenum() + valLeft.getDenum() * valRight.getNum();
        long denum = valLeft.getDenum() * valRight.getDenum();
        return new ConstanteQ(num, denum).simplifier(); 
    }

    @Override

    protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteQ valRight) {
        return simplifier(new ConstanteQ(valLeft.value, 1), valRight);
    }
    
    @Override
    public ExpressionArithmetique simplifier(ExpressionArithmetique ex1, ConstanteN ex2) {
    	if(ex1 instanceof Addition) {
    		Addition tmp = (Addition) ex1.simplifier();
    		if(tmp.left instanceof ConstanteN)
    			return new Addition(tmp.right,new Addition(tmp.left, ex2).simplifier());
    		else if (tmp.left instanceof ConstanteQ )
    			return new Addition(tmp.right, new Addition(tmp.left, ex2).simplifier());
    		else if(tmp.right instanceof ConstanteN)
    			return new Addition(tmp.left,new Addition(ex2, tmp.right).simplifier());
    		else if( tmp.right instanceof ConstanteQ)
    			 return new Addition(tmp.left, new Addition(ex2, tmp.right).simplifier());
    	}
    
    	return this;
    	
    }
    
    @Override
    public ExpressionArithmetique simplifier(ExpressionArithmetique ex1, ConstanteQ ex2) {
    	if(ex1 instanceof Addition) {
    		Addition tmp = (Addition) ex1.simplifier();
    		if(tmp.left instanceof ConstanteN)
    			return new Addition(tmp.right,new Addition(tmp.left, ex2).simplifier());
    		else if (tmp.left instanceof ConstanteQ)
    			return new Addition(tmp.right, new Addition(tmp.left, ex2).simplifier());
    		else if (tmp.right instanceof ConstanteN)
    			return new Addition(tmp.left, new Addition(tmp.right, ex2).simplifier());
    		else if (tmp.right instanceof ConstanteQ)
    			return new Addition(tmp.left, new Addition(tmp.right, ex2).simplifier());
    	}
    		return this;
    }
    
    @Override
    public ExpressionArithmetique simplifier(ConstanteN ex1, ExpressionArithmetique ex2) {
    	if(ex2 instanceof Addition) {
    		Addition tmp = (Addition) ex2.simplifier();
    		if(tmp.right instanceof ConstanteN)
    			return new Addition(tmp.left, new Addition(ex1, tmp.right).simplifier());
    		else if ( tmp.right instanceof ConstanteQ)
    			return new Addition(tmp.left, new Addition(tmp.right, ex1).simplifier());
    		else if (tmp.left instanceof ConstanteN)
    			return new Addition(tmp.right, new Addition(tmp.left, ex1).simplifier());
    		else if (tmp.left instanceof ConstanteQ)
    			return new Addition(tmp.right, new Addition(tmp.left, ex1).simplifier());
    	}
    	return this;
    }
    
    @Override
	protected ExpressionArithmetique simplifier(ConstanteQ ex1, ExpressionArithmetique ex2) {
		if(ex2 instanceof Addition) {
			Addition tmp = (Addition) ex2.simplifier();
			if(tmp.right instanceof ConstanteN)
				return new Addition(tmp.left, new Addition(ex1, tmp.right).simplifier());
			else if( tmp.right instanceof ConstanteQ)
				return new Addition(tmp.left, new Addition(ex1, tmp.right).simplifier());
			else if(tmp.left instanceof ConstanteN )
				return new Addition(tmp.right, new Addition(ex1, tmp.left).simplifier());
			else if(tmp.left instanceof ConstanteQ)
				return new Addition(tmp.right, new Addition(ex1, tmp.left).simplifier());
		}
		return this;
	}
    
    
    @Override
	public double calculer() {
		return this.left.calculer() + this.right.calculer();
	}

	@Override
	public ExpressionArithmetique deriver() {
		return new Addition(this.left.deriver(), this.right.deriver()).simplifier();  
	}


	@Override
	public ExpressionArithmetique deriver(int n) {
		ExpressionArithmetique tmp = this.simplifier();
		for(int i = 0; i < n; i++) {
			tmp = tmp.deriver();
		}
		return tmp;
	}
	
}
