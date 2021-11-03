package fr.pantheonsorbonne.cri;

public abstract class OpUnaire implements ExpressionArithmetique {

    protected ExpressionArithmetique value;
    protected String operationName;

    public OpUnaire(ExpressionArithmetique op, String operationName) {
        this.operationName = operationName;
        this.value = op;
    }
    
    @Override
    public String toString() {
        return "(" + this.operationName + "(" + value.toString() + "))"; 
    }
    @Override
    public boolean equals(Object ea) {
    	if(this == ea) 
			return true;
		if(ea == null)
			return false;
		if(!(this.getClass() == ea.getClass())) 
			return false;
		OpUnaire tmp = (OpUnaire) ea;
		ExpressionArithmetique tmvaleur = tmp.value.simplifier();
    	if(this.value.toString().equals(tmvaleur.toString()) 
    			&& this.operationName.equals(tmp.operationName))
    		return true; 
    	else return false;
    }
}
