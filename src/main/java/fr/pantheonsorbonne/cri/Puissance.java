package fr.pantheonsorbonne.cri;

public class Puissance extends OpBinaire {

	public Puissance(ExpressionArithmetique leftOp, ExpressionArithmetique rightOp) {
		super(leftOp, rightOp, "^");
	}

	@Override
	protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteN valRight) {
		double left = valLeft.value;
		double right = valRight.value;
		double res = Math.pow(left, right);
		long resultat = (long) res;
		return new ConstanteN(resultat);
	}

	@Override
	protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ConstanteQ valRight) {
		return new Puissance(valLeft, valRight);
	}
	
	@Override
	protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ConstanteN valRight) {
		long num = valLeft.getNum();
		long denum = valLeft.getDenum();
		long right =  valRight.value;
		long resNum = (long) Math.pow(num, right);
		long resDenum = (long) Math.pow(denum, right);
		
		long resvalLeft =  resNum;
		long resvalRight =  resDenum;
		
		return new ConstanteQ(resvalLeft, resvalRight);
	}
	
	@Override
	protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteQ valRight) {
		return new Puissance(valLeft, valRight);
	}
	
	@Override
	public double calculer() {
		return Math.pow(this.left.calculer(), this.right.calculer());
	}

	@Override
	public ExpressionArithmetique deriver() {
		if(this.right instanceof ConstanteN) {
			ConstanteN tmp = (ConstanteN) this.right;
			ConstanteN right1 = new ConstanteN(tmp.value - 1);
			if(right1.value == 1)
				return new Multiplication(tmp.simplifier(), this.left);
			
			return new Multiplication(tmp.simplifier(), new Puissance((this.left.simplifier()), right1).simplifier()).simplifier();
		}
		else if (this.right instanceof ConstanteQ) {
			ConstanteQ tmp = (ConstanteQ) this.right.simplifier();
			ExpressionArithmetique sous = new Soustraction(tmp, new ConstanteN(1)).simplifier();

			return new Multiplication(tmp.simplifier(), new Puissance(this.left.simplifier(),sous).simplifier()).simplifier();
		}
		else 
			return new Multiplication(new Multiplication(left.deriver().simplifier(), this.simplifier()), new Ln(this)).simplifier();

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
		if (valRight.value == 0)
			return new ConstanteN(1);
		else if (valRight.value == 1)
			return valLeft.simplifier();
		return new Puissance(valLeft.simplifier(), valRight);
	}

	@Override
	protected ExpressionArithmetique simplifier(ExpressionArithmetique valLeft, ConstanteQ valRight) {
		return this;
	}

	@Override
	protected ExpressionArithmetique simplifier(ConstanteN valLeft, ExpressionArithmetique valRight) {
		return this;
	}

	@Override
	protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ExpressionArithmetique valRight) {
		return this;
	}

	
}
