package com.other;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Fayne on 2018/03/29.
 * 一个小程序
 *  找出一定特色的成语，导入的是成语大全，有6w多个。
 *  嘿嘿，以后儿子做作业很简单呐。
 */
public class idiom {
    public static void main(String[] args) throws IOException {
        long startTime=System.currentTimeMillis();   //获取开始时间
        String filename = "idiom.txt";
        String fileContent = "";
        String []res=new String[100000];
        int num2=0;
        String res2[]=new String [30808];
        int num = 0;
        try {
            File f = new File(filename);
            if (f.isFile() && f.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(f), "gbk");
                BufferedReader reader = new BufferedReader(read);
                String line;
                while ((line = reader.readLine()) != null) {
                    if(line.length()>4)
                        res[num]=line.substring(0,5);
                    num++;
                }
                read.close();
            }
            for(String temp:res){
                if(temp!=null){
                    res2[num2]=temp;
                    num2++;
                }
            }
            for(int i=1;i<res2.length;i++)
                res2[i-1]=res2[i];
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(num2);
        System.out.println(Arrays.toString(res2));
        int num__aabc=0;
        ArrayList<String>list=new ArrayList<>();
        for(int i=0;i<res2.length;i++){
            String a1=res2[i].substring(1,2);
            String a2=res2[i].substring(2,3);
            String a3=res2[i].substring(3,4);
            String a4=res2[i].substring(4,5);
            if(a3.equals(a4)&&a1.equals(a2)){
                 list.add(res2[i]);
                 num__aabc++;
            }
        }
        for(String temp:list)
            System.out.println(temp);
        System.out.println("num__aabc"+": "+num__aabc);
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

    }
}
