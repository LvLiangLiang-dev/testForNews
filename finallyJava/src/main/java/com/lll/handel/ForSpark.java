package com.lll.handel;
import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ForSpark {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();   //获取开始时间
        System.setProperty("hadoop.home.dir", "D:\\hadoop-2.2.0");
        SparkConf conf = new SparkConf().setMaster("local").setAppName("wordCountTest");
        JavaSparkContext sc = new JavaSparkContext(conf);




        JavaRDD<String> lines = sc.textFile("D:\\dream.txt");
//使用java8提供的lambda表达式
//一句可以完成wordcount
        JavaPairRDD<String, Integer> counts =
                lines
                        //根据'\001'分割来源行
                        .flatMap(line -> Arrays.asList(line.split("\\001")).iterator())
                        //map输出 (单词,1)
                        .mapToPair(w -> new Tuple2<String, Integer>(w, 1))
                        //通过reduce相同key，value值相加
                        .reduceByKey((x, y) -> x + y);

//根据得到的value值排序而不是key，默认只提供了根据key排序
//那么想到的思路是，交换key、value，进行key排序，交换回来，完成value排序
        counts
                //交换key-value，注意类型
                .mapToPair(s -> new Tuple2<Integer, String>(s._2, s._1))
                //倒序
                .sortByKey(false)
                //交换key-value，注意类型
                .mapToPair(s -> new Tuple2<String, Integer>(s._2, s._1))
                //转成集合
                .collect()
                //输出
                .forEach(tuple -> System.out.println(tuple._1() + ": " + tuple._2()));

//        List<String> list=new ArrayList<String>();
//        list.add("1 1 2 a b");
//        list.add("a b 1 2 3");
//        JavaRDD<String> RddList=sc.parallelize(list);
//
//        //先切分为单词，扁平化处理
//        JavaRDD<String> flatMapRdd = RddList.flatMap(new FlatMapFunction<String, String>() {
//            @Override
//            public Iterator<String> call(String str) {
//                return Arrays.asList(str.split(" ")).iterator();
//
//            }
//        });
//
//        //再转化为键值对
//        JavaPairRDD<String, Integer> pairRdd = flatMapRdd.mapToPair(new PairFunction<String, String, Integer>() {
//            public Tuple2<String, Integer> call(String word) throws Exception {
//                return new Tuple2<String, Integer>(word, 1);
//            }
//        });
//
//        //对每个词语进行计数
//        JavaPairRDD<String, Integer> countRdd = pairRdd.reduceByKey(new Function2<Integer, Integer, Integer>() {
//            @Override
//            public Integer call(Integer i1, Integer i2) {
//                return i1 + i2;
//            }
//        });
//        System.out.println("结果："+countRdd.collect());
//
//        sc.close();
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}