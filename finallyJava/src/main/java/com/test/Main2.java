package com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/8/11
 */
public class Main2 {
    public static void main(String[] args) {
        qs2();
    }

    private static void temp() {
        String a = "1,10;32,45";
        System.out.println(a.length());
        System.out.println(a.toCharArray()[1] == ',');
        String[] split1 = a.split(";");
        for (String tmep : split1) {
            System.out.println(tmep);
        }
        System.out.println(a.split(","));
    }

    private static void qs2() {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        String[] qa3 = new String[m + 1];

        int numall = 0;
        for (int i = 0; i < m + 1; i++) {
            qa3[i] = scanner.nextLine();
        }
        String[] qa = new String[m];
        for (int i = 0; i < m; i++) {
            qa[i] = qa3[i + 1];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < qa[i].length(); j++) {
                if (qa[i].toCharArray()[j] == ',') {
                    numall++;
                }
            }
        }
        Integer[][] qa2 = new Integer[numall][2];
        int temp = 0;
        for (int i = 0; i < m; i++) {
            //            for(int j=0;j<qa[i].length();j++){
            String[] split1 = qa[i].split(";");
            for (int k = 0; k < split1.length; k++) {
                String[] split2 = split1[k].split(",");
                qa2[temp][0] = Integer.valueOf(split2[0]);
                qa2[temp][1] = Integer.valueOf(split2[1]);
                temp++;
            }
            //            }
        }
        twoSort(qa2, 0);
        int result[] = new int[numall];
        result[0] = qa2[0][0];
        int record = 0;
        for (int i = 1; i < numall; i++) {
            if (qa2[i][0] <= qa2[i - 1][1] && qa2[i][1] <= qa2[i - 1][1]) {
                record++;
                //               qa2[i-1][0]=0;
                //               qa2[i-1][1]=0;
                qa2[i][0] = qa2[i - 1][0];
                qa2[i][1] = qa2[i - 1][1];
                qa2[i - 1][0] = 0;
                qa2[i - 1][1] = 0;
            }
            if (qa2[i][0] <= qa2[i - 1][1] && qa2[i][1] >= qa2[i - 1][1]) {
                record++;
                //               qa2[i-1][0]=0;
                //               qa2[i-1][1]=0;
                qa2[i][0] = qa2[i - 1][0];
                qa2[i - 1][0] = 0;
                qa2[i - 1][1] = 0;
            }
        }
        twoSort(qa2, 0);
        String ress = "";
        for (int i = 0; i < numall - 1; i++) {
            if (qa2[i][0] != 0) {
                ress += qa2[i][0];
                ress += ",";
                ress += qa2[i][1];
                ress += ';';

            }

        }
        ress += qa2[numall - 1][0];
        ress += ",";
        ress += qa2[numall - 1][1];

        //        ress.append(qa2[numall-1][0]);
        //        ress.append(",");
        //        ress.append(qa2[numall-1][1]);
        System.out.println(ress.toString());
    }

    private static void qs3() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[][] score = new Integer[n][2];
        for (int i = 0; i < n; i++) {
            score[i][0] = scanner.nextInt();
            score[i][1] = scanner.nextInt();
        }
        int max = 0;
        twoSort(score, 0);
        Map<Integer, Integer> res = new HashMap<>();
        System.out.println(10);

    }

    private static void twoSort(Integer[][] work, int i) {
        List<Integer[]> helperList = Arrays.asList(work);
        Collections.sort(helperList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[i].compareTo(o2[i]);
            }
        });
        work = (Integer[][]) helperList.toArray();
    }
}
