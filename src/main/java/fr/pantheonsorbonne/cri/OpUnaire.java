package fr.pantheonsorbonne.cri;

public abstract class OpUnaire implements ExpressionArithmetique {

    protected ExpressionArithmetique value;
    protected String operationName;

    protected OpUnaire(ExpressionArithmetique op, String operationName) {
        this.operationName = operationName;
        this.value = op;
    }
    
    @Override
    public String toString() {
        return "(" + this.operationName + "(" + value.toString() + "))"; 
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpUnaire other = (OpUnaire) obj;
		if (operationName == null) {
			if (other.operationName != null)
				return false;
		} else if (!operationName.equals(other.operationName))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
