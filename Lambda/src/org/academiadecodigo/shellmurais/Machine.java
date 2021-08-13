package org.academiadecodigo.shellmurais;

public class Machine {

    public <T> T monoOp(T p1, MonoOperation<T> op) {
        return op.monoOperation(p1);
    }

    public <T> T biOp(T p1, T p2, BiOperation<T> op) {
        return op.biOperation(p1,p2);
    }

}
