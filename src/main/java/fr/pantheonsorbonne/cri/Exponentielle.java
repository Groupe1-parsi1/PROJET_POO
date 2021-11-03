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

}
