package fr.pantheonsorbonne.cri;

public class Addition extends OpBinaire {

    public Addition(ExpressionArithmetique left, ExpressionArithmetique right) {
        super(left, right, "+");
    }


    @Override
    protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteN valRight) {

        return new ConstanteN(valLeft.value + valRight.value);
    }

    @Override
    protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ConstanteQ valRight) {

        long num = valLeft.getNum() * valRight.getDenum() + valLeft.getDenum() * valRight.getNum();
        long denum = valLeft.getDenum() * valRight.getDenum();
        return new ConstanteQ(num, denum).simplifier(); 
    }

    @Override

    protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteQ valRight) {
        return simplifier(new ConstanteQ(valLeft.value, 1), valRight);
    }
    
    @Override
	public double calculer() {
		return this.left.calculer() + this.right.calculer();
	}

}
