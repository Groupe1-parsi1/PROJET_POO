package fr.pantheonsorbonne.cri;

public class Somme implements ExpressionArithmetique {
	private ExpressionArithmetique ea;
	private int inf;
	private int sup;

	public Somme(ExpressionArithmetique ea, int inf, int sup) {
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
					res = new Addition(res, multi);

				}
			}

		}
		return res;
	}

//	public ExpressionArithmetique supporter() {
//		return 
//	}

	@Override
	public double calculer() {
		throw new RuntimeException("Erreur");
	}

	@Override
	public String toString() {
		return this.ea.simplifier().toString();
	}

//	public static void main(String[] args) {
//		ExpressionArithmetique i = new VariableInconnue('i');
//		ExpressionArithmetique x = new VariableInconnue('x');
//		VariableIndex varin = new VariableIndex('a', i);
//		ExpressionArithmetique ex = new Multiplication(varin, x);
//		System.out.println(ex.toString());
//
//	}

	@Override
	public ExpressionArithmetique deriver() {
		return null;
	}

	@Override
	public ExpressionArithmetique deriver(int n) {
		return null;
	}

}
