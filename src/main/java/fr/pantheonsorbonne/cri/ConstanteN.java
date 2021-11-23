package fr.pantheonsorbonne.cri;

public class ConstanteN extends ConstanteExpressionArithmetique {

    public long value;

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
    public boolean equals(Object ea) {
    	if(this == ea) 
			return true;
		if(ea == null)
			return false;
		if((this.getClass() != ea.getClass())) 
			return false;
		ConstanteN tmp = (ConstanteN) ea;
		if(this.value == tmp.value)
			return true;
		return false;
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
