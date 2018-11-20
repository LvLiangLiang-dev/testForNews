package com.lll.algorithm.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Fayne on 2018/08/09.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> res = new HashMap<String, Integer>();
        Map<String, Integer> last = new HashMap<String, Integer>();
        String flag = null;
        while (in.hasNext()) {
            long sum = 0;
            res.put(in.next(), in.nextInt());
            flag = in.next();
        }
        int length = flag.length();
        int num_flag = 0,num=0;
        Character[] result = new Character[length];
        flag.toCharArray();
        for (int i = 0; i < length; i++) {
            num_flag += flag.toCharArray()[i];
        }
        for (String temp : res.keySet()) {
            for (int i = 0; i < length; i++) {
                num += temp.toCharArray()[i];
            }
            if(num==num_flag){
                last.put(temp,res.get(temp));
            }
        }
        for(String temp1 : last.keySet()){
            System.out.println(temp1+" "+last.get(temp1));
        }
    }
}