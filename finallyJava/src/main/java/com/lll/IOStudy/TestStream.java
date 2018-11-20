package com.lll.IOStudy;

import java.io.*;
import java.util.Arrays;

/**
 * Created by lvliangliang on 2017/11/26.
 */
public class TestStream {
    public static void main(String[] args) throws IOException {
//        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream("xxxx.txt"));
//        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream("1xxxx.txt"));
//        int len;
//        while((len=bufferedInputStream.read())!=-1){
//            bufferedOutputStream.write(len ^ 112358);
//        }
//        bufferedInputStream.close();
//        bufferedOutputStream.close();
        testReadWriteChinese();


    }

    /**
     * 用字符流才方便，字节流很麻烦。
     *
     *
     * ###20.13_IO流(字节流读写中文)
     * 字节流读取中文的问题
     * 字节流在读中文的时候有可能会读到半个中文,造成乱码
     * 字节流写出中文的问题
     * 字节流直接操作的字节,所以写出中文必须将字符串转换成字节数组
     * 写出回车换行 write("\r\n".getBytes());
     * @throws IOException
     */
    public static void testReadWriteChinese() throws IOException {
        FileInputStream fileInputStream=new FileInputStream("E:\\web_project\\FinallyJava\\src\\main\\resources\\some\\xxx.txt");
        FileOutputStream fileOutputStream=new FileOutputStream("xxxo.txt");
        byte []bytes=new byte[4];
        int len;
        while((len=fileInputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        fileOutputStream.write("我爱你".getBytes());
        fileInputStream.close();
        fileOutputStream.close();

    }

    /**
     * 不关，如果没满，就不会写入。
     * buffered就是缓冲
     * bufferedInputStream是在内存中创建的，
     * 减少了写到硬盘和从硬盘读的次数，但是内存中的次数是没有改变的，内存的运算效率要远远大于硬盘，
     * 所以缓冲流效率更高。
     *
     * close用来关闭流释放资源的，如果是带缓冲区的，不但会关闭流，还会先刷新缓冲区，关闭后不能再写出。
     * flush用来刷新缓冲区的，刷新后可以再次写出。
     * @throws IOException
     */
    public static void testBuffered() throws IOException {
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream("E:\\web_project\\FinallyJava\\src\\main\\resources\\some\\xxx.txt"));
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream("output.txt"));
        int b;
        while((b=bufferedInputStream.read())!=-1){
            bufferedOutputStream.write(b);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();

    }

    /**
     * read(bytes[])返回的是有效的字节个数
     *
     * write()，有三个参数，字节数组名，
     * 	write(byte[] b, int off, int len)
     将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。
     *
     *
     *
     *
     * @throws IOException
     */
    private static void copyLittleBytes() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\WEB_PROJECTS\\FinallyJava\\src\\main\\resources\\some\\xxx.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

//        byte[] bytes = new byte[2];
//        int a=fileInputStream.read(bytes);
//        System.out.println(Arrays.toString(bytes));
//        System.out.println("a="+a);
//
//        byte[] bytes2 = new byte[2];
//        int a2=fileInputStream.read(bytes2);
//        System.out.println(Arrays.toString(bytes2));
//        System.out.println("a2="+a2);

        int t1,t2;
        t1=fileInputStream.read();
        t2=fileInputStream.read();
        System.out.println("t1="+t1+"\n"+"t2="+t2);


        byte by[]=new byte[1024];
        int len;
        while((len=fileInputStream.read(by))!=-1){
            fileOutputStream.write(by,0,len);
        }



        fileInputStream.close();
        fileOutputStream.close();
    }

    /**
     * available():返回的是剩余的字节数。
     * read和write都有字节数组的参数，可以按照字节数组来存储一次读的量，这样可以减少读的次数。
     * 但是用 available来作为字节数组的长度，从而读取，这样可能会内存溢出。
     *
     * @throws IOException
     */
    private static void copyByBytesAvailable() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\WEB_PROJECTS\\FinallyJava\\src\\main\\resources\\some\\run.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("output.jpg");

        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        fileOutputStream.write(bytes);
//        System.out.println(Arrays.toString(bytes));

        fileInputStream.close();
        fileOutputStream.close();
    }

    /**
     * 拷贝，输入流到输出流。
     * 效率很低，按字节拷很慢。
     * 每次只能一个字节，只有八位而已。
     *
     * @throws IOException
     */
    private static void copyStream() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\web_project\\FinallyJava\\src\\main\\resources\\some\\run.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("output.jpg");
        int b;
        while ((b = fileInputStream.read()) != -1) {     //在不断的读每一个字节
            fileOutputStream.write(b);              //将每一个字节写出
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    /**
     * 如果没有对应的文件，会自动创建。
     * 虽然写出的是一个int数，但是到文件上是一个字节，会自动去除前三个8位。
     * 构造函数中有一个append变量，如果为真，则是追加。
     * 如果没有append，就是在原有的基础上就行修改，不是删除文件再创建  ^-^
     *
     * @throws IOException
     */
    public static void testOutputStream() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt", true);
        fileOutputStream.write(48);
        fileOutputStream.write(49);
    }

    /**
     * inputstream是一个抽象类，outputstream也是一个抽象类。
     * 文件的结束标志是 -1；读的时候只要不是-1，就可以不断的读下去，有了循环的出口；
     * 要抛异常，因为可能读不到，可能没有响应的文件，在编译之前是不能确定有没有对应的文件的；
     * close，要关闭；
     * read();从输入流中读取一个字节； 返回值是int，对应的字符的ascii码；
     *
     * @throws IOException
     */
    public static void testFileInputStream() throws IOException {
        File file = new File("E:\\web_project\\FinallyJava\\src\\main\\resources\\test1.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        int x1 = fileInputStream.read();
        System.out.println(x1);
        int x2 = fileInputStream.read();
        System.out.println(x2);
        int x3 = fileInputStream.read();
        System.out.println(x3);
        fileInputStream.close();
    }
}
