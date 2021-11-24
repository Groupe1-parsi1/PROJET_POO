package fr.pantheonsorbonne.cri;

public interface ExpressionArithmetique {

	String toString();
	ExpressionArithmetique simplifier();
	ExpressionArithmetique deriver();
	
	ExpressionArithmetique deriver(int n);
	public double calculer();

}
