package fr.pantheonsorbonne.cri;

public class VariableIndex extends VariableInconnue {

private ExpressionArithmetique index;
	
	public VariableIndex(String symbole, ExpressionArithmetique index) {
		super(symbole);
		this.index = index;
	}
	
	public ExpressionArithmetique getIndex() {
		return this.index;
	}
	
	@Override
	public String toString() {
		return this.symbole + this.index.toString();
	}

	@Override
	public ExpressionArithmetique simplifier() {
		return this;
			
	}
	
	@Override
	public double calculer() {
		throw new RuntimeException("Erreur");
	}

}
