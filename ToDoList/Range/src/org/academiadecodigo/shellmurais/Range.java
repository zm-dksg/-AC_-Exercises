package org.academiadecodigo.shellmurais;

import java.util.Iterator;

public class Range implements Iterable<Integer> {

    private Integer min;
    private Integer max;

    public Range(Integer min, Integer max) {
        this.min = min;
        this.max = max;

    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator(min,max);

    }

}
