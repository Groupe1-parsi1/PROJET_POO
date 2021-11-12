package fr.pantheonsorbonne.cri;

public class VariableInconnue extends ConstanteExpressionArithmetique {

	public char symbole;
	public ExpressionArithmetique valeur = null;

	public VariableInconnue(char symbole) {
		this.symbole = symbole;
	}

	public char getSymbole() {
		return this.symbole;
	}

	public void setValeur(ExpressionArithmetique valeur) {
		this.valeur = valeur;
	}

	public ExpressionArithmetique simplifier() {
		if (this.valeur != null) {
			return this.valeur;
		}
		// return new VariableInconnue(symbol);
		return this;
	}

	@Override
	public String toString() {
		if (valeur == null)
			return "" + getSymbole();
		else
			return valeur.toString();
	}

	@Override
	public double calculer() {
		return 0.0;
	}

}
