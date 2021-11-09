package fr.pantheonsorbonne.cri;

public class Division extends OpBinaire {
	public Division(ExpressionArithmetique left, ExpressionArithmetique right) {
        super(left, right, "/"); 
    }

	@Override
	protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteN valRight) {
		return new ConstanteQ(valLeft.value,valRight.value).simplifier();  
	}

	@Override
	protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteQ valRight) {
		ConstanteQ cst = new ConstanteQ(valLeft.getValue()*valRight.getDenum(), valRight.getNum());
		if(cst.getDenum() == 1)
			return new ConstanteN(cst.getNum());
		else
			return new ConstanteQ(valLeft.getValue()*valRight.getDenum(), valRight.getNum()).simplifier();
			
	}
	
	@Override
	protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ConstanteN valRight) {
		
		return new ConstanteQ(valLeft.getNum(), valLeft.getDenum() *valRight.getValue()).simplifier();
		
	}
	
	@Override
	protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ConstanteQ valRight) {
		return new ConstanteQ(valLeft.getNum()*valRight.getDenum(), valLeft.getDenum()*valRight.getNum()).simplifier();
	}
	
	@Override
	public double calculer() {
		return this.left.calculer() / this.right.calculer();
	}
	
	

}
