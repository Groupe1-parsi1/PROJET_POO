package fr.pantheonsorbonne.cri;

public class ConstanteN extends ConstanteExpressionArithmetique {

    protected long value;

    public ConstanteN(long value) {
        this.value = value;
    }

	@Override
    public String toString() {
        return Long.toString(value);
	}

    public long getValue() {
    	return this.value;
    }
    @Override
   	public double calculer() {
   		return this.value;
   	}
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (value ^ (value >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConstanteN other = (ConstanteN) obj;
		return value == other.value;
	}
    
	@Override
	public ExpressionArithmetique deriver() {
		
		return new ConstanteN(0);
	}

	@Override
	public ExpressionArithmetique deriver(int n) {
		
		return new ConstanteN(0);
	}

}
