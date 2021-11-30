package fr.pantheonsorbonne.cri;

public class ConstanteQ extends ConstanteExpressionArithmetique {

	protected long num;
	protected long denum;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (denum ^ (denum >>> 32));
		result = prime * result + (int) (num ^ (num >>> 32));
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
		ConstanteQ other = (ConstanteQ) obj;
		ConstanteQ cstOtherSimp = (ConstanteQ) other.simplifier();
		ConstanteQ thisSimp = (ConstanteQ) this.simplifier();
		return (thisSimp.denum == cstOtherSimp.denum && thisSimp.num == cstOtherSimp.num) ;
	}

	@Override
	public ExpressionArithmetique deriver() {
		return new ConstanteN(0);
	}
	
	@Override
	public ExpressionArithmetique deriver(int n) {
		return new ConstanteN(0);
	}
}
