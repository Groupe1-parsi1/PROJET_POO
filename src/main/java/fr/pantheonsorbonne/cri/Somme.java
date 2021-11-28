package fr.pantheonsorbonne.cri;

public class Somme implements ExpressionArithmetique {

	private ExpressionArithmetique ea;
	private long inf;
	private long sup;

	public Somme(ExpressionArithmetique ea, long inf, long sup) {
		this.ea = ea;
		this.inf = inf;
		this.sup = sup;
	}
	
	@Override
	public ExpressionArithmetique simplifier() {
		ExpressionArithmetique res;
		res = new ConstanteN(0);
		if (ea instanceof Multiplication) {
			Multiplication tmp = (Multiplication) ea;
			if (tmp.left instanceof VariableIndex && tmp.right instanceof Puissance) {
				Puissance pui = (Puissance) tmp.right;
				for (long i = inf; i <= sup; i++) {
					ConstanteN cst = new ConstanteN(i);
					VariableIndex varInd = new VariableIndex("α", cst);
					ExpressionArithmetique multi = new Multiplication(varInd, new Puissance(pui.left, cst)).simplifier();
					res = new Addition(res, multi);

				}
			}
		}
		return res;
	}


	@Override
	public double calculer() {
		throw new RuntimeException("Erreur");
	}

	@Override
	public String toString() {
		return this.ea.simplifier().toString();
	}


	@Override
	public ExpressionArithmetique deriver() {
		return null;
	}
	
	@Override
	public ExpressionArithmetique deriver(int n) {
		return null;
	}
}

