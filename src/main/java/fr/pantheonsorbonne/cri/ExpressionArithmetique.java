package fr.pantheonsorbonne.cri;

public interface ExpressionArithmetique {

	String toString();
	ExpressionArithmetique simplifier();
	
	public double calculer();

}
