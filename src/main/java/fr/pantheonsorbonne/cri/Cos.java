package fr.pantheonsorbonne.cri;

public class Cos extends OpUnaire {

    public Cos(ExpressionArithmetique op) {
        super(op, "cos");
    }
   
    @Override
    public ExpressionArithmetique simplifier() {
        ExpressionArithmetique val = this.value.simplifier();
        if (val instanceof ConstanteSymbolique) {
            ConstanteSymbolique cons = (ConstanteSymbolique) val;
            if (cons.constant == ConstanteSymbolique.ConstantesSymboliqueConnues.PI)
                return new ConstanteN(-1);
        }
        if (val instanceof ConstanteN) {
            ConstanteN value = (ConstanteN) val;
            if (value.value == 90 || value.value == -90)
                return new ConstanteN(0);
            else if (value.value == 0)
            	return new ConstanteN(1);
            else if(value.value == 60 || value.value == -60)
            	return new ConstanteQ(1, 2);
            else if(value.value == 120 || value.value == -120)
            	return new ConstanteQ(-1, 2);
        }
        return new Cos(val);
    }
    
    @Override
   	public double calculer() {
   		return Math.cos(this.value.calculer());
   	}
}
