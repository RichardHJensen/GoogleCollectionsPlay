package com.rhjensen.pairwise;

import java.util.Iterator;

/**
 * User: Richard H. Jensen
 * Date: 4/24/12
 * Time: 12:29 PM
 */
public class PairwiseIterator<T> {

    private final Iterator<T> baseIterator;

    public PairwiseIterator(Iterable<T> iterable) {
        baseIterator = iterable.iterator();
    }

    public boolean hasNext() {
        return baseIterator.hasNext();
    }

    public  ItemPair<T> next() {
        ItemPair<T> result = null;
        if (hasNext()) {
            T first = baseIterator.next();
            T second = null;
            if (baseIterator.hasNext()) {
                second = baseIterator.next();
            }
            result = new ItemPair<T>(first, second);
        }
        return result;
    }

    public class ItemPair<T> {
        private final T firstItem;
        private final T secondItem;
        public ItemPair(T first, T second) {
            firstItem = first;
            secondItem = second;
        }

        public T first() {
            return firstItem;
        }

        public T second() {
            return secondItem;
        }
    }
}
