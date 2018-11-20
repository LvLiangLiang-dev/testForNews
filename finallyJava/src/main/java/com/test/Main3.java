package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int temp2 = 0, m = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> once = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            once.add(i);
            for (int j = 0; j < n; j++) {
                temp2 = scanner.nextInt();
                if (temp2 != 0) {
                    once.add(temp2);
                } else {
                    list.add(new ArrayList<>(once));
                    once.clear();
                    break;
                }
            }
        }
//        System.out.println(Arrays.toString(list.toArray()));

        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                for (int j = 0; j < list.get(k).size(); j++) {
                    if (list.get(i).contains(list.get(k).get(j))) {
                        list.get(i).addAll(list.get(k));
                        list.remove(k);
                        n--;
                        k--;
                        break;
                    }
                }
            }
        }
        System.out.println(list.size());
    }
}
