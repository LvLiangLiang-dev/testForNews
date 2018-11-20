package com.test;

/**
 * Created by Fayne on 2018/09/16.
 */
/**
 *
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StringCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String father = scanner.next();
        String son = scanner.next();
        int count = 0;
        while (son.length() <= father.length()) {
            if (father.indexOf(son) != -1) {
                father = father.substring(father.indexOf(son) + son.length(), father.length());
                count++;
            } else {
                break;
            }
        }
        Pattern p = Pattern.compile(son, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(father);
        while (m.find()) {
            count++;
        }
        System.out.println((count*2)*(count*2));
    }
}
