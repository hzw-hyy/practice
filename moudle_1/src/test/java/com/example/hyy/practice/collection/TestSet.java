package com.example.hyy.practice.collection;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/9/25 9:48
 */
public class TestSet {

    public static void main(String[] args) {
//        testHashSet();
        testTreeSet();
    }

    static void testHashSet() {
        Set<String> sets = Sets.newHashSet();
        sets.add("bb");
        sets.add("aa");
        sets.add("ff");
        sets.add("cc");
        sets.add("ee");
        for (String set : sets) {
            System.out.println(set);
        }
    }

    @Test
    static void testTreeSet() {

        Set<String> sets = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        sets.add("bb");
        sets.add("aa");
        sets.add("ff");
        sets.add("cc");
        sets.add("ee");
        for (String set : sets) {
            System.out.println(set);
        }

    }


}
