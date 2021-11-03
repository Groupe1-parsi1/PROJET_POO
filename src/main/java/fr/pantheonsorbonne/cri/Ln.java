package fr.pantheonsorbonne.cri;

public class Ln extends OpUnaire {

	public Ln(ExpressionArithmetique op) {
		super(op, "ln");
	}

	@Override
	public String toString() {
		return "(ln(" + value.toString() + "))";
	}

	@Override
	public ExpressionArithmetique simplifier() {
		ExpressionArithmetique val = this.value.simplifier();
		if (val instanceof ConstanteN) {
			ConstanteN cons = (ConstanteN) val;
			if (cons.value == 1)
				return new ConstanteN(0);
		}
		if (val.equals(ConstanteSymbolique.E)) {
			return new ConstanteN(1);
		}
		return new Ln(val);
	}
	
	@Override
	public double calculer() {
		return Math.log(this.value.calculer());
	}

}
