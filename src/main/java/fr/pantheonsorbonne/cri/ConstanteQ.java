package fr.pantheonsorbonne.cri;

public class ConstanteQ extends ConstanteExpressionArithmetique {

	long num;
	long denum;

	public ConstanteQ(long num, long denum) {
		this.num = num;
		this.denum = denum;
	}

	private static long pgcd(long n1, long n2) {

		while (n1 != n2) {
			if (n1 > n2)
				n1 -= n2;
			else
				n2 -= n1;
		}
		return n2;
	}

	@Override
	public String toString() {
		return "(" + getNum() + "/" + getDenum() + ")";
	}

	@Override
	public ExpressionArithmetique simplifier() {
		long pgcd = pgcd(Math.abs(this.num), Math.abs(this.denum));
		if (getDenum() / pgcd == 1) {
			return new ConstanteN(getNum() / pgcd);
		} else if (pgcd == 1) {
			return super.simplifier();
		} else {
			return new ConstanteQ(getNum() / pgcd, getDenum() / pgcd);
		}
	}

	public long getNum() {
		return num;
	}

	public long getDenum() {
		return denum;
	}
	
	 @Override
		public double calculer() {
			return (double) this.num / this.denum;
		}
}
