package com.lll.IOStudy;

import java.io.*;

/**
 * Created by lvliangliang on 2017/11/29.
 */
public class TestReader {
    public static void main(String[] args) throws IOException {
        testLine();
    }

    /**
     * 三层包装。很好很强大。
     * 为了什么？
     * @throws IOException
     */

    public static void testLine() throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream("out.txt")));
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out3.txt")));
        int ch;
        while((ch=bufferedReader.read())!=-1){
            bufferedWriter.write(ch);
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    /**
     * 带缓冲的字符流
     * BufferedReader的read()方法读取字符时会一次读取若干字符到缓冲区, 然后逐个返回给程序, 降低读取文件的次数, 提高效率
     * BufferedWriter的write()方法写出字符时会先写到缓冲区, 缓冲区写满时才会写到文件, 降低写文件的次数, 提高效率
     *
     * @throws IOException
     */
    public static void copyBufferedByReaderAndWriter() throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new FileReader("out.txt"));
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("outout.txt"));
        int ch;
        while((ch=bufferedReader.read())!=-1){
            bufferedWriter.write(ch);
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    /**
     * 自定义字符数组的拷贝
     *
     * @throws IOException
     */
    public static void copyByReaderAndWriter() throws IOException {
        FileReader fileReader=new FileReader("out.txt");
        FileWriter fileWriter=new FileWriter("output.txt");
        int len;
        char[]bytes=new char[1024*8];
        while((len=fileReader.read(bytes))!=-1){
            fileWriter.write(bytes,0,len);
        }
        fileReader.close();
        fileWriter.close();


    }

    /**
     * 字符流是可以直接读写字符的io流。
     * 字符流读取字符，就要先读取到字节数据，然后转换为字符。如果要写出字符，需要把字符转换为字节再写出。
     * <p>
     * read()没参数的，返回的是读取到的，结束返回-1
     *
     * FileWriter类的write()方法可以自动把字符转为字节写出
     *
     *
     *
     *
     * @throws IOException
     */
    public static void testfileReader() throws IOException {
        FileReader fileReader = new FileReader("output.txt");
//        int x=fileReader.read();
//        System.out.println(((char) x));
        int len;
        while ((len = fileReader.read()) != -1) {
            System.out.println((char) len);
        }
        fileReader.close();

        FileWriter fileWriter = new FileWriter("out.txt");
        fileWriter.write("jjjj");
        fileWriter.close();
    }

}
