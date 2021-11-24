package fr.pantheonsorbonne.cri;

public class Soustraction extends OpBinaire {
    public Soustraction(ExpressionArithmetique leftOp, ExpressionArithmetique rightOp) {
        super(leftOp, rightOp, "-");
    }

    @Override
    protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteN valRight) {
        return new ConstanteN(valLeft.value - valRight.value);
    }

    @Override
    protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ConstanteQ valRight) {
        long num = valLeft.getNum() * valRight.getDenum() - valLeft.getDenum() * valRight.getNum();
        long denum = valLeft.getDenum() * valRight.getDenum();
        return new ConstanteQ(num, denum).simplifier();
    }

    @Override
    protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ConstanteN valRight) {
        
    	long num = valLeft.getNum() - valRight.getValue()*valLeft.getDenum();
    	long denum = valLeft.getDenum(); 
        return new ConstanteQ(num, denum).simplifier();
    }
    
    @Override
    protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteQ valRight) {
    	long num = valLeft.getValue()*valRight.getDenum() - valRight.getNum();
    	long denum = valRight.getDenum();
    	return new ConstanteQ(num, denum).simplifier();
    }
    
		
    @Override
   	public double calculer() {
   		return this.left.calculer() - this.right.calculer();
   	}

	@Override
	public ExpressionArithmetique deriver() {
		return new Soustraction(left.deriver().simplifier(), right.deriver().simplifier()).simplifier();
	}

	@Override
	public ExpressionArithmetique deriver(int n) {
		ExpressionArithmetique tmp = this.simplifier();
		for(int i = 0; i < n; i++)
			tmp = tmp.deriver();
		return tmp;
	}
	
	@Override
    public ExpressionArithmetique simplifier(ExpressionArithmetique ex1, ConstanteN ex2){
		if(ex2.value == 0)
			return ex1;
		return this;	
    }
    
    @Override
    public ExpressionArithmetique simplifier(ExpressionArithmetique ex1, ConstanteQ ex2) {
    		return this;
    }
    
    @Override
    public ExpressionArithmetique simplifier(ConstanteN ex1, ExpressionArithmetique ex2) {
    	return this;
    }
    
    @Override
	protected ExpressionArithmetique simplifier(ConstanteQ ex1, ExpressionArithmetique ex2) {
		return this;
	}
}
