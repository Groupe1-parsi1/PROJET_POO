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
		return null;
	}

	@Override
	public double calculer() {
		throw new RuntimeException("Erreur");
	}

	@Override
	public String toString() {
		return this.ea.simplifier().toString();
	}

}
