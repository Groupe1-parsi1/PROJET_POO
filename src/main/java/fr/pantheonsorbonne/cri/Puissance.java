package fr.pantheonsorbonne.cri;

public class Puissance extends OpBinaire {

	public Puissance(ExpressionArithmetique leftOp, ExpressionArithmetique rightOp) {
		super(leftOp, rightOp, "^");
	}

	@Override
	protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteN valRight) {
		double left = (double) valLeft.value;
		double right = (double) valRight.value;
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
		double num = (double) valLeft.getNum();
		double denum = (double) valLeft.getDenum();
		double right = (double) valRight.value;
		double resNum = Math.pow(num, right);
		double resDenum = Math.pow(denum, right);
		
		long resvalLeft = (long) resNum;
		long resvalRight = (long) resDenum;
		
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


}
