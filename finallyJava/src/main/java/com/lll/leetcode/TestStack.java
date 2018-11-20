package com.lll.leetcode;

import javax.xml.bind.SchemaOutputResolver;
import java.util.*;

/**
 * Created by Fayne on 2017/11/12.
 */
public class TestStack {
    public static void main(String[] args) {
        question71();

    }

    /**
     * 这是简化，不是删除，linux风格路径
     * 这种题需要注意的是条件的多种，很容易遗漏
     *
     * 然后就是 list初始化可以利用  Arrays.asList()来实现，很方便。
     * stack也可以直接循环。
     * for(String dir:stack){}
     */
    public static void question71() {
        String path = "/a/./b/../../c/";

        Stack<String> stack=new Stack<>();
        List<String> list=new ArrayList<>(Arrays.asList("",".",".."));
        for(String string:path.split("/")){
            if(string.equals("..")&&!stack.isEmpty())stack.pop();
            if(!list.contains(string))stack.push(string);
        }
        String result="";
        for(String dir:stack) System.out.println(dir);
        while(!stack.isEmpty()){
            result="/"+stack.pop()+result;
        }
        System.out.println(result);
    }

    /**
     * stack,集合都有sort方法
     * 可以使用Collection.sort方法调用
     * 默认是升序号
     */

    public static void testStack() {
        LinkedList<Integer> list=new LinkedList<Integer>();
            list.add(1);
            list.add(3);
            list.add(5);
            list.add(9);
            list.add(6);
            System.out.println("size:"+list.size());
            System.out.println("5:"+list.get(0));
            Collections.sort(list);
            System.out.println(list);
            for(Integer temp:list){
            System.out.println(temp.toString());
        }
    }

    /**
     * stack的遍历可以通过isEmpty()方法
     * 字符串与数字的转换
     */
    public static void question682() {
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};

        int result=0;
        Stack<String> stack=new Stack<>();
        for(String string:ops){
            if(string.equals("C")){
                stack.pop();
            }else if(string.equals("D")){
                String temp=stack.peek();
                stack.push(String.valueOf(2*Integer.valueOf(temp)));
            }else if(string.equals("+")){
                String a1=stack.pop();
                String a2=stack.pop();
                String now=String.valueOf(Integer.valueOf(a1)+Integer.valueOf(a2));
                stack.push(a2);
                stack.push(a1);
                stack.push(now);
            }else{
                stack.push(string);
            }
        }
        System.out.println(stack.size());
        Collections.sort(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            result+=Integer.valueOf(stack.pop());
        }
        System.out.println(result);

    }

    /**
     * 这个是栈的一种应用
     * 【 栈的特性 】正常循环的情况下，数组的滚动（游标移动）是向后的，
     * 引入栈的时候，则可以有了向前滚动的机会（有了一定的反悔的机会），
     * 然后这样子就能够解决一些局部的问题（比如说，寻找相邻的大的数字）。
     * 由于栈还可以对于没有价值（已经发现了大的数字）的东西删除，
     * 这样子的遗忘功能，简化了搜索空间，问题空间。
     */
    private static void question496() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int nums : nums2) {
            while (!stack.isEmpty() && stack.peek() < nums) {
                map.put(stack.pop(), nums);
            }
            stack.push(nums);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        System.out.println(Arrays.toString(nums1));
    }

}
