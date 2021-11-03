package fr.pantheonsorbonne.cri;

public class ConstanteN extends ConstanteExpressionArithmetique {

    public long value;

    public ConstanteN(long value) {
        this.value = value;
    }

    public ConstanteN(double sqrt) {
		// TODO Auto-generated constructor stub
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

}
