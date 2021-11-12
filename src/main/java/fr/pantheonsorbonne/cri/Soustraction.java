package fr.pantheonsorbonne.cri;

public class Soustraction extends OpBinaire {
    public Soustraction(ExpressionArithmetique leftOp, ExpressionArithmetique rightOp) {
        super(leftOp, rightOp, "-");
    }

    @Override
    protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteN valRight) {
        return new ConstanteN(valLeft.value - valRight.value);
    }

    @Override
    protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ConstanteQ valRight) {
        long num = valLeft.getNum() * valRight.getDenum() - valLeft.getDenum() * valRight.getNum();
        long denum = valLeft.getDenum() * valRight.getDenum();
        return new ConstanteQ(num, denum).simplifier();
    }

    protected ExpressionArithmetique simplifier(ConstanteQ valLeft, ConstanteN valRight) {
        
    	long num = valLeft.getNum() - valRight.getValue()*valLeft.getDenum();
    	long denum = valLeft.getDenum(); 
        return new ConstanteQ(num, denum).simplifier();
    }
    
    protected ExpressionArithmetique simplifier(ConstanteN valLeft, ConstanteQ valRight) {
    	long num = valLeft.getValue()*valRight.getDenum() - valRight.getNum();
    	long denum = valRight.getDenum();
    	return new ConstanteQ(num, denum).simplifier();
    }
    
		
    @Override
   	public double calculer() {
   		return this.left.calculer() - this.right.calculer();
   	}
    

}
