package fr.pantheonsorbonne.cri;

public class Produit implements ExpressionArithmetique {
	private ExpressionArithmetique ea;
	private int inf;
	private int sup;

	public Produit(ExpressionArithmetique ea, int inf, int sup) {
		this.ea = ea;
		this.inf = inf;
		this.sup = sup;
	}

	@Override
	public ExpressionArithmetique simplifier() {
		ExpressionArithmetique res;
		res = null;
		if (ea instanceof Multiplication) {
			Multiplication tmp = (Multiplication) ea;
			if (tmp.left instanceof VariableIndex && tmp.right instanceof Puissance) {
				VariableIndex var = (VariableIndex) tmp.left;
				Puissance pui = (Puissance) tmp.right;
				res = new Addition(new ConstanteN(1), pui.left);
				for (int i = inf; i <= sup; i++) {
					ConstanteN cst = new ConstanteN(i);
					VariableIndex varInd = new VariableIndex('α', cst);
					ExpressionArithmetique multi = new Multiplication(varInd, new Puissance(pui.left, cst));
					res = new Multiplication(res, multi);

				}
			}

		}
		return res;
	}

	@Override
	public String toString() {
		return this.ea.simplifier().toString();
	}

	@Override
	public ExpressionArithmetique deriver() {
		throw new RuntimeException("Erreur");
	}

	@Override
	public ExpressionArithmetique deriver(int n) {
		throw new RuntimeException("Erreur");
	}

	@Override
	public double calculer() {
		throw new RuntimeException("Erreur");
	}

}
