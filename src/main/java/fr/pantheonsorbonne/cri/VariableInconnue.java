package fr.pantheonsorbonne.cri;

public class VariableInconnue extends ConstanteExpressionArithmetique {

	protected char symbole;
	protected ExpressionArithmetique valeur = null;

	public VariableInconnue(char symbole) {
		this.symbole = symbole;
	}

	public char getSymbole() {
		return this.symbole;
	}

	public void setValeur(ExpressionArithmetique valeur) {
		this.valeur = valeur;
	}
	
	
	@Override
	public ExpressionArithmetique simplifier() {
		if (this.valeur != null) {
			return this.valeur;
		}
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
	    public boolean equals(Object ea) {
		 if(this == ea) 
				return true;
			if(ea == null)
				return false;
			if((this.getClass() != ea.getClass())) 
				return false;
			VariableInconnue x = (VariableInconnue)ea;
			if(this.symbole == x.symbole)
				return true;
			return false;
	 }

	@Override
	public double calculer() {
		return 0.0;
	}

	@Override
	public ExpressionArithmetique deriver() {
		
		return new ConstanteN(1);
	}
	@Override
	public ExpressionArithmetique deriver(int n) {
		ExpressionArithmetique tmp = this.simplifier();
		for(int i = 0; i < n; i++)
			tmp = tmp.deriver();
		return tmp;
	}
}
