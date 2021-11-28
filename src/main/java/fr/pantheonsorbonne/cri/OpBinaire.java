package fr.pantheonsorbonne.cri;

import static fr.pantheonsorbonne.cri.Utils.*;


public abstract class OpBinaire implements ExpressionArithmetique {

	protected ExpressionArithmetique right;
	protected ExpressionArithmetique left;
	protected String symbol;

	protected OpBinaire(ExpressionArithmetique leftOp, ExpressionArithmetique rightOp, String symbol) {
		left = leftOp;
		right = rightOp;
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "(" + this.left.toString() + this.symbol + this.right.toString() + ")";
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
		} else if(this.left instanceof ExpressionArithmetique && this.right instanceof ConstanteN) {
			ConstanteN cst = (ConstanteN) this.right;
			return simplifier(this.left, cst);
		}else if(this.left instanceof ExpressionArithmetique && this.right instanceof ConstanteQ) {
			ConstanteQ cst = (ConstanteQ) this.right;
			return simplifier(this.left, cst);
		}else if(this.left instanceof ConstanteN && this.right instanceof ExpressionArithmetique) {
			ConstanteN cst = (ConstanteN) this.left;
			return simplifier(cst, this.right);
		}else if(this.left instanceof ConstanteQ && this.right instanceof ExpressionArithmetique) {
			ConstanteQ cst = (ConstanteQ) this.left;
			return simplifier(cst, this.right);
		}
		return this;
	}
	

	protected ExpressionArithmetique simplifier(ConstanteQ toQ, ConstanteN toN) {
		return simplifier(toN(this.right), toQ(this.left));
	}
	
	protected abstract ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteN valRight);

	protected abstract ExpressionArithmetique simplifier(ConstanteQ valLeft, ConstanteQ valRight);

	protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteQ valRight) {
		return simplifier(new ConstanteQ(valLeft.value, 1), valRight); 
	}
	
	
	protected abstract ExpressionArithmetique simplifier(ExpressionArithmetique valLeft, ConstanteN valRight);
	protected abstract ExpressionArithmetique simplifier(ExpressionArithmetique valLeft, ConstanteQ valRight);
	protected abstract ExpressionArithmetique simplifier(ConstanteN valLeft, ExpressionArithmetique valRight);
	protected abstract ExpressionArithmetique simplifier(ConstanteQ valLeft, ExpressionArithmetique valRight);


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpBinaire other = (OpBinaire) obj;
		if(this.left.simplifier().equals(other.left.simplifier()) && 
				this.right.simplifier().equals(other.right.simplifier()) && 
				this.symbol.equals(other.symbol)) {
					return true;
		}else if(this.right.simplifier().equals(other.left.simplifier()) &&
				this.left.simplifier().equals(other.right.simplifier())&&
				this.symbol.equals(other.symbol))
					return true;
		return false;
	}	
	
	
}
 