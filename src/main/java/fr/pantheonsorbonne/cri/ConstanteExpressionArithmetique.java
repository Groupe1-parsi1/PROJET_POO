package fr.pantheonsorbonne.cri;

abstract public class ConstanteExpressionArithmetique implements ExpressionArithmetique {

    @Override
    public ExpressionArithmetique simplifier() {
        return this;
    }

}
