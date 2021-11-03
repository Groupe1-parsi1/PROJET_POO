package fr.pantheonsorbonne.cri;

public class VariableInconnue extends ConstanteExpressionArithmetique {
	
	public char x;
	public 	ExpressionArithmetique valeur = null;
	
	public VariableInconnue(char x) {
		this.x = x;
	}
	
	public char getX() {
		return this.x;
	}
	
	public void setValeur(ExpressionArithmetique valeur){
		this.valeur = valeur;
	}
	

	
	@Override
	public String toString() {
		if(valeur == null)
			return ""+ getX();
		else
			return  valeur.toString();
	}

	@Override
	public double calculer() {
		return 0.0;
	}
	
	
	
}
