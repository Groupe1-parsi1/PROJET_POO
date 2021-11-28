package fr.pantheonsorbonne.cri;

public abstract class ConstanteExpressionArithmetique implements ExpressionArithmetique {

    @Override
    public ExpressionArithmetique simplifier() {
        return this;
    }

}
