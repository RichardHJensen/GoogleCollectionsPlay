package com.rhjensen.pairwise;

import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * User: Richard H. Jensen
 * Date: 4/24/12
 * Time: 12:24 PM
 */
public class PairWiseTest {
    @Test
    public void anEmptyListShouldResultInAZeroLengthPairwiseIterator() {
        List<String> list = newArrayList();
        PairwiseIterator iterator = new PairwiseIterator(list);
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void aListWithOneElementShouldResultInAPairWiseIteratorOfLengthOne() {
        List<String> list = newArrayList("one");
        PairwiseIterator iterator = new PairwiseIterator(list);
        assertThat(iterator.hasNext(), is(true));
        PairwiseIterator<String>.ItemPair<String> item = iterator.next();
        assertThat(item, not(nullValue()));
        assertThat(iterator.hasNext(), is(false));
        assertThat(item.first(), is("one"));
        assertThat(item.second(), is(nullValue()));
    }

    @Test
    public void aListWithTwoElementsShouldResultInAPairWiseIteratorOfLengthOne() {
        List<String> list = newArrayList("one", "two");
        PairwiseIterator iterator = new PairwiseIterator(list);
        assertThat(iterator.hasNext(), is(true));
        PairwiseIterator<String>.ItemPair<String> item = iterator.next();
        assertThat(item, not(nullValue()));
        assertThat(item.first(), is("one"));
        assertThat(item.second(), is("two"));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void aListWithThreeElementsShouldResultInAPairWiseIteratorOfLengthTwo() {
        List<String> list = newArrayList("one", "two", "three");
        PairwiseIterator iterator = new PairwiseIterator(list);
        assertThat(iterator.hasNext(), is(true));
        PairwiseIterator<String>.ItemPair<String> item = iterator.next();
        assertThat(item, not(nullValue()));
        assertThat(item.first(), is("one"));
        assertThat(item.second(), is("two"));
        assertThat(iterator.hasNext(), is(true));
        item = iterator.next();
        assertThat(item.first(), is("three"));
        assertThat(item.second(), is(nullValue()));
        assertThat(iterator.hasNext(), is(false));
    }

}
