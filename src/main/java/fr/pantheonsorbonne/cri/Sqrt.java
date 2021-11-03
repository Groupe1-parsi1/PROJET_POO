package fr.pantheonsorbonne.cri;

public class Sqrt extends OpUnaire {

	public Sqrt(ExpressionArithmetique op) {
		super(op, "sqrt");
	}
	
	@Override
	public ExpressionArithmetique simplifier() {
		ExpressionArithmetique valeur = this.value.simplifier(); 
		if(valeur instanceof ConstanteN) {
			ConstanteN tmp = (ConstanteN) valeur;
			long val;
			if(check_square_num(tmp.getValue())) {
				val = (long)Math.sqrt(tmp.value);
				return new ConstanteN(val);
			}
		}
		else if (valeur instanceof ConstanteQ) {
			ConstanteQ tmp = (ConstanteQ) valeur;
			long num = tmp.getNum();
			long denum = tmp.getDenum();
			if(check_square_num(num) && check_square_num(denum)) {
				long valNum = (long)Math.sqrt(num);
				long valDenum = (long)Math.sqrt(denum);
				return new ConstanteQ(valNum, valDenum);
			}
		}
		return new Sqrt(valeur); 
	}
	
	public static boolean check_square_num(long nb) {
		long tmp = (long)Math.sqrt(nb);
		if(tmp*tmp == nb)
			return true;
		return false;
	}
	
	@Override
	public double calculer() {
		return Math.sqrt(this.value.calculer());
	}
}
