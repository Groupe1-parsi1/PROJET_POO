package fr.pantheonsorbonne.cri;

public class Sin extends OpUnaire {

	public Sin(ExpressionArithmetique op) {
		super(op, "sin");
		// TODO Auto-generated constructor stub
	}

	@Override
	public ExpressionArithmetique simplifier() {
		 ExpressionArithmetique val = this.value.simplifier();
	        if (val instanceof ConstanteSymbolique) {
	            ConstanteSymbolique sinu = (ConstanteSymbolique) val;
	            if (sinu.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI)
	                return new ConstanteN(0);
	        }
	        if (val instanceof ConstanteN) {
	            ConstanteN value = (ConstanteN) val;
	            if (value.value == 0)
	                return new ConstanteN(0);
	            else if (value.value == 90)
	            	return new ConstanteN(1);
	            else if (value.value == -90)
	            	return new ConstanteN(-1);
	            else if (value.value == 30 || value.value == 150)
	            	return new ConstanteQ(1, 2);
	            else if (value.value == -30 || value.value == -150)
	            	return new ConstanteQ(-1, 2);
	        }
	        return new Sin(val);
	}
	
	@Override
	public double calculer() {
		return Math.sin(this.value.calculer());
	}

}
