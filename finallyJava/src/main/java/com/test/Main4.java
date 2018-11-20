package com.test;//package com.test;
//
//import scala.Int;
//
//import java.util.*;
//
///**
// * Created by Fayne on 2018/08/25.
// */
//public class Main4 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int ita1 = scanner.nextInt();
//        int ita2 = scanner.nextInt();
//        int itb1 = scanner.nextInt();
//        int itb2 = scanner.nextInt();
//        MockIterator ita = new MockIterator(ita1, ita2);
//        MockIterator itb = new MockIterator(itb1, itb2);
//        Iterable<Integer> iterable = new MergeIterator(ita, itb);
//
//    }
//}
//
//class MergeIterator implements Iterable<Integer> {
//    private Iterable<Integer> temp1;
//    private Iterable<Integer> temp2;
//    private int[] num;
//    List<Integer> res = new ArrayList<>();
//
//    public MergeIterator(Iterable<Integer> a, Iterable<Integer> b) {
//        this.temp1 = a;
//        this.temp2 = b;
//        if (temp1.iterator().hasNext()) {
//            res.add(temp1.iterator().next());
//        }
//        if (temp2.iterator().hasNext()) {
//            res.add(temp2.iterator().next());
//        }
//        this.num = new int[res.size()];
//    }
//    @Override
//    public Iterator<Integer> iterator() {
//        return null;
//    }
//    public void getAll() {
//
//        for (int i = 0; i < res.size(); i++) {
//            num[i] = res.get(i);
//        }
//        sort(num, 0, num.length - 1);
//    }
//
//    public boolean hasNext() {
//        return false;
//    }
//
//    public Integer next() {
//        return null;
//    }
//
//    void sort(int[] data, int left, int right) {
//        if (left < right) {
//            int center = (left + right) / 2;
//            sort(data, left, center);
//            sort(data, center + 1, right);
//            merge(data, left, center, right);
//        }
//    }
//
//    void merge(int[] data, int left, int center, int right) {
//        int[] tmpArr = new int[data.length];
//        int mid = center + 1;
//        int third = left;
//        int tmp = left;
//        while (left <= center && mid <= right) {
//            if (data[left] <= data[mid]) {
//                tmpArr[third++] = data[left++];
//            } else {
//                tmpArr[third++] = data[mid++];
//            }
//        }
//        while (mid <= right) {
//            tmpArr[third++] = data[mid++];
//        }
//        while (left <= center) {
//            tmpArr[third++] = data[left++];
//        }
//        while (tmp <= right) {
//            data[tmp] = tmpArr[tmp++];
//        }
//    }
//
//
//}
//
//class MockIterator implements Iterable<Integer> {
//    int current, step, endValue;
//
//    public MockIterator(int step, int endValue) {
//        this.step = step;
//        this.endValue = endValue;
//        this.current = endValue % step;
//    }
//
//    public boolean hasNext() {
//        return this.current < this.endValue;
//    }
//
//    public Integer next() {
//        return this.current += this.step;
//    }
//
//    @Override
//    public Iterator<Integer> iterator() {
//        return null;
//    }
//}
