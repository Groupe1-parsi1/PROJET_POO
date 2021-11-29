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
		throw new IllegalArgumentException("Erreur");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		VariableIndex other = (VariableIndex) obj;
		if(this.symbole != null && other.symbole != null)
			return this.symbole.equals(other.symbole) && this.index.equals(other.index);
		else if (this.symbole == null && other.symbole == null){
			if(this.index != null && other.index != null) {
				return (this.index == other.index);
			}
		}
		return false;
	}
}
