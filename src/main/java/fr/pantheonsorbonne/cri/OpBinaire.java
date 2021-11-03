package fr.pantheonsorbonne.cri;

import static fr.pantheonsorbonne.cri.Utils.*;

public abstract class OpBinaire implements ExpressionArithmetique {

	protected ExpressionArithmetique right;
	protected ExpressionArithmetique left;
	protected String symbol;

	public OpBinaire(ExpressionArithmetique leftOp, ExpressionArithmetique rightOp, String symbol) {
		left = leftOp;
		right = rightOp;
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "(" + left.toString() + this.symbol + right.toString() + ")";
	}

	@Override
	public ExpressionArithmetique simplifier() {
		this.left = this.left.simplifier();
		this.right = this.right.simplifier();
		if (this.left instanceof ConstanteN && this.right instanceof ConstanteN) {
			return simplifier(toN(this.left), toN(this.right));
		} else if (this.left instanceof ConstanteQ && this.right instanceof ConstanteQ) {
			return simplifier(toQ(this.left), toQ(this.right));
		} else if (this.left instanceof ConstanteN && this.right instanceof ConstanteQ) {
			return simplifier(toN(this.left), toQ(this.right));
		} else if (this.left instanceof ConstanteQ && this.right instanceof ConstanteN) {
			return simplifier(toQ(this.left), toN(this.right));
		} 
		return this;
	}

	protected ExpressionArithmetique simplifier(ConstanteQ toQ, ConstanteN toN) {
		return simplifier(toN(this.right), toQ(this.left));
	}
	

	abstract protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteN valRight);

	abstract protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ConstanteQ valRight);

	protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteQ valRight) {
		return simplifier(new ConstanteQ(valLeft.value, 1), valRight); 
	}
	
	@Override
	public boolean equals(Object ea) {
		if(this == ea)
			return true;
		if(ea == null)
			return false;
		if(!(this.getClass() == ea.getClass()))
			return false;
		OpBinaire tmp = (OpBinaire)ea;
		ExpressionArithmetique tm1left = this.left.simplifier();
		ExpressionArithmetique tm1right = this.right.simplifier();
		if(tm1left.toString().equals(tmp.left.simplifier().toString()) 
				&& tm1right.toString().equals(tmp.right.simplifier().toString())
				&& this.symbol.equals(tmp.symbol)) 
			return true;
		return false;
			
	}
}
