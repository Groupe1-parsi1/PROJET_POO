package fr.pantheonsorbonne.cri;

public class Produit implements ExpressionArithmetique {

	private ExpressionArithmetique ea;
	private long inf;
	private long sup;

	public Produit(ExpressionArithmetique ea, long inf, long sup) {
		this.ea = ea;
		this.inf = inf;
		this.sup = sup;
	}
	
	@Override
	public ExpressionArithmetique simplifier() {
		ExpressionArithmetique res;
		res = new ConstanteN(1);
		if (ea instanceof Multiplication) {
			Multiplication tmp = (Multiplication) ea;
			if (tmp.left instanceof VariableIndex && tmp.right instanceof Puissance) {
				Puissance pui = (Puissance) tmp.right;
				for (long i = inf; i <= sup; i++) {
					ConstanteN cst = new ConstanteN(i);
					VariableIndex varInd = new VariableIndex("α", cst);
					ExpressionArithmetique multi = new Multiplication(varInd, new Puissance(pui.left, cst)).simplifier();
					res = new Multiplication(res, multi);

				}
			}
		}else if(ea instanceof VariableIndex) {
			VariableIndex varTmp = (VariableIndex) ea;
			if(varTmp.symbole == null) {
				{	
					for(long i = inf; i <= sup; i++) {
						ConstanteN tmp = new ConstanteN(i);
						res = new Multiplication(res, tmp).simplifier();
					}
				}
			}
		}
		return res;
	}


	@Override
	public double calculer() {
		throw new IllegalArgumentException("Erreur");
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

