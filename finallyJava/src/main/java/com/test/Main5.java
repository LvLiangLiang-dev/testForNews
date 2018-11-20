package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Fayne on 2018/09/08.
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String res = scanner.nextLine();
        int out = 0;
        int len = res.length();

        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < len - 1; i++) {

            if (res.charAt(i) != res.charAt(i + 1)) {
                continue;
            } else {
                list.add(i);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            if (i == 0) {
                result.add(list.get(0) + 1);
            }else{
                result.add(list.get(i)-list.get(i-1));
            }
            result.add(res.length()-list.get(list.size()-1)-1);
        }

        for(int i=0;i<result.size();i++)
            System.out.println(result.get(i));

    }
}
