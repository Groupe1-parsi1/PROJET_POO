package fr.pantheonsorbonne.cri;

public class Division extends OpBinaire {
	public Division(ExpressionArithmetique left, ExpressionArithmetique right) {
		super(left, right, "/");
	}

	@Override
	protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteN valRight) {
		if(valLeft.getValue() == 0)
			return new ConstanteN(0);
		return new ConstanteQ(valLeft.value, valRight.value).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteQ valRight) {
		ConstanteQ cst = new ConstanteQ(valLeft.getValue() * valRight.getDenum(), valRight.getNum());
		if (cst.getDenum() == 1)
			return new ConstanteN(cst.getNum());
		else
			return new ConstanteQ(valLeft.getValue() * valRight.getDenum(), valRight.getNum()).simplifier();

	}

	@Override
	protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ConstanteN valRight) {
		return new ConstanteQ(valLeft.getNum(), valLeft.getDenum() * valRight.getValue()).simplifier();

	}

	@Override
	protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ConstanteQ valRight) {
		
		return new ConstanteQ(valLeft.getNum() * valRight.getDenum(), valLeft.getDenum() * valRight.getNum())
				.simplifier();
	}

	@Override
	public double calculer() {
		return this.left.calculer() / this.right.calculer();
	}

	@Override
	public ExpressionArithmetique deriver() {
		if(this.left instanceof VariableInconnue && this.right instanceof ConstanteN) {
			ConstanteN tmp = (ConstanteN) this.right;
			return new ConstanteQ(1, tmp.value);
		}
		else if (this.left instanceof VariableInconnue && this.right instanceof ConstanteQ) {
			ConstanteQ tmp = (ConstanteQ) this.right;
			return new ConstanteQ(tmp.denum, tmp.num);
		}
		else {
			ExpressionArithmetique derlef = new Multiplication(this.left.deriver(), this.right).simplifier();
			ExpressionArithmetique derRigh= new Multiplication(this.right.deriver(), this.left).simplifier(); 
	
			ExpressionArithmetique denumDer = new Puissance(this.right, new ConstanteN(2)).simplifier();
			ExpressionArithmetique numDer = new Soustraction(derlef, derRigh).simplifier();
			return new Division(numDer, denumDer);
			
		}
	}
	
	@Override
	public ExpressionArithmetique deriver(int n) {
		ExpressionArithmetique tmp = this.simplifier();
		for(int i = 0; i < n; i++)
			tmp = tmp.deriver().simplifier();
		return tmp;
	}

	@Override
	protected ExpressionArithmetique simplifier(ExpressionArithmetique valLeft, ConstanteN valRight) {
		if(valRight.value == 1)
			return valLeft;
		return this;
	}

	@Override
	protected ExpressionArithmetique simplifier(ExpressionArithmetique valLeft, ConstanteQ valRight) {
		return this;
	}

	@Override
	protected ExpressionArithmetique simplifier(ConstanteN valLeft, ExpressionArithmetique valRight) {
		if (valLeft.value == 0)
			return new ConstanteN(0);
		return this;
	}

	@Override
	protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ExpressionArithmetique valRight) {
		return this;
	}
	
}
