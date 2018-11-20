package com.lll.basics.string;

import com.lll.basics.inherit.Test;

/**
 * Created by lvliangliang on 2018/01/05.
 */
public class testString {
    public void fortest(){
        forStringBuffer();
    }

    /**
     * StringBuffer
     *  初始化：
     *      构造一个其中不带字符的字符串缓冲区，其初始容量为 16 个字符。
     *
     *
     *  append
     *  deleteCharAt
     *  insert
     *  reverse
     *  setCharAt
     *  trimToSize 该方法的作用是将StringBuffer对象的中存储空间缩小到和字符串长度一样的长度，减少空间的浪费。
     *
     *
     *
     */
    public void forStringBuffer(){
        StringBuffer stringBuffer=new StringBuffer();
        StringBuffer stringBuffer2=new StringBuffer();
        StringBuffer stringBuffer3=new StringBuffer(10);
        StringBuffer stringBuffer4=new StringBuffer("the forth");

        System.out.println(stringBuffer.capacity());
        System.out.println(stringBuffer2.capacity());
        System.out.println(stringBuffer3.capacity());
        System.out.println(stringBuffer4.capacity());

    }

}
