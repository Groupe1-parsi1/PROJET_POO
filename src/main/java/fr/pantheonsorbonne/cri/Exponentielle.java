package fr.pantheonsorbonne.cri;

public class Exponentielle extends OpUnaire {

    public Exponentielle(ExpressionArithmetique op) {
        super(op, "exp");
    }


    @Override
    public ExpressionArithmetique simplifier() {
        this.value = this.value.simplifier();
        if (this.value instanceof ConstanteN) {
            ConstanteN cons = (ConstanteN) this.value;
            if (cons.value == 0)
                return new ConstanteN(1);
        }
        return this;
    }
    @Override
	public double calculer() {
		return Math.exp(this.value.calculer());
	}


	@Override
	public ExpressionArithmetique deriver() {
		ExpressionArithmetique derVal = this.value.deriver().simplifier();
		if(derVal instanceof ConstanteN) {
			ConstanteN tmp = (ConstanteN) derVal;
			if(tmp.value == 1)
				return this.simplifier();
		}else if(derVal instanceof ConstanteQ) {
			ConstanteQ tmp = (ConstanteQ) derVal;
			if(tmp.denum == tmp.num)
				return this.simplifier();
		}	
		return new Multiplication(this.value.deriver(), this).simplifier();
	}
	
	@Override
	public ExpressionArithmetique deriver(int n) {
		ExpressionArithmetique tmp = this.simplifier();
		for(int i = 0; i < n; i++)
			tmp = tmp.deriver();
		return tmp;
	}

}
