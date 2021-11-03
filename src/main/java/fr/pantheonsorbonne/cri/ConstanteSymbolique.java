package fr.pantheonsorbonne.cri;


public class ConstanteSymbolique extends ConstanteExpressionArithmetique {

	public static ExpressionArithmetique PI = new ConstanteSymbolique(ConstantesSymboliqueConnues.PI);

	public static ExpressionArithmetique E = new ConstanteSymbolique(ConstantesSymboliqueConnues.EXPONENTIELLE);

	public ConstanteSymbolique(ConstantesSymboliqueConnues constanteConnue) {
		this.constant = constanteConnue;
	}

	ConstantesSymboliqueConnues constant; 
 
	public enum ConstantesSymboliqueConnues {
		PI("π", 3.1415), EXPONENTIELLE("e", 2.7111);

		String strRepresentation;
		double valeur;

		ConstantesSymboliqueConnues(String strRepresentation, double valeur) {
			this.strRepresentation = strRepresentation;
			this.valeur = valeur;
		}

		public String getStrPresentation() {
			return this.strRepresentation;
		}
		
		public double getValeur() {
			return this.valeur; 
		}
	}	

	@Override
	public String toString() {
		return this.constant.getStrPresentation();
	}
	
	@Override
	public double calculer() {
		return this.constant.getValeur();
	}


}
