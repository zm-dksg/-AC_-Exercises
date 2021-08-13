package org.academiadecodigo.shellmurais;

import java.util.Iterator;

public class BiRange implements Iterable<Integer> {

    private Integer min;
    private Integer max;
    private boolean reverseFlag;

    public BiRange(int min, int max, boolean reverseFlag) {
        this.min = min;
        this.max = max;
        this.reverseFlag = reverseFlag;

    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                if (reverseFlag) { return (max - 1) >= min; }
                else { return (min + 1) <= max; }

            }

            @Override
            public Integer next() {
                if (reverseFlag) { return --max; }
                else { return ++min; }

            }

        };

    }

}
