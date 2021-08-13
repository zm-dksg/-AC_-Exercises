package org.academiadecodigo.shellmurais;

import java.util.Iterator;

public class MyIterator implements Iterator<Integer> {

    private Integer cur;
    private Integer max;

    public MyIterator(Integer min, Integer max) {
        this.cur = min;
        this.max = max+1;

    }

    public Integer getCur() {
        return cur;

    }

    public boolean isEven() {
        return (cur % 2) == 0;

    }

    @Override
    public boolean hasNext() {
        return (cur + 1) <= max;

    }

    @Override
    public Integer next() {
        return ++cur;

    }

}
