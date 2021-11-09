package fr.pantheonsorbonne.cri;

public class Multiplication extends OpBinaire {

    public Multiplication(ExpressionArithmetique left, ExpressionArithmetique right) {
        super(left, right, "*");
    }


    @Override
    protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteN valRight) {

        return new ConstanteN(valLeft.value * valRight.value);
    }

    @Override
    protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ConstanteQ valRight) {

        return new ConstanteQ(valLeft.getNum() * valRight.getNum(), valLeft.getDenum() * valRight.getDenum()).simplifier();
    }

    @Override
    protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteQ valRight) {
        return new ConstanteQ(valLeft.value * valRight.getNum(), valRight.getDenum());
    }
    
    
    @Override
   	public double calculer() {
   		return this.left.calculer() * this.right.calculer();

   	}

    
}
