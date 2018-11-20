package com.lll.handel;///**
// *
// */
//package com.lll.handel;
//import com.csvreader.CsvReader;
//import com.csvreader.CsvWriter;
//import org.apdplat.word.WordSegmenter;
//import org.apdplat.word.segmentation.Word;
//
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLConnection;
//import java.nio.charset.Charset;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
///**
//* @author lvliangliang E-mail:lvliangbupt@136.com
//* @version Create time：2017年10月16日 上午10:50:31
//* class illustration:
//*/
///**
// * @author NewUser
// *
// */
//public class HandelUrlAndData {
//	/**
//	 * @param args
////	 * @throws Exception
//	 */
//	public static void main(String[] args) throws Exception {
//		long startTime=System.currentTimeMillis();
//		String filepath="C:/Users/NewUser/Desktop/ForGraduation/data/835data.csv";
//		String filepath1="C:/Users/NewUser/Desktop/ForGraduation/data/835outdata_1.csv";
//		List<String[]>data=importCsv(filepath);
//		List<String[]>data1=new ArrayList<>();
//		int count=0;
//		int count_label_0=0;
//		for(String[] strings:data){
//			count++;
////			if(strings[10].equals("0"))count_label_0++;
////			if(strings[10]=="0")count_label_0++;
//			String temp[]={strings[1],strings[3]};
//			data1.add(temp);
//		}
//		//输出列表
//		System.out.println("============================================");
////		for(String[] strings:data){
////			System.out.println(count+": ");
//////			System.out.println(data.get(count).toString());
//////			System.out.println(strings.toString());
////			System.out.println(Arrays.toString(strings));
////			count++;
////		}
//		System.out.println("export result is "+exportCsv(data1,filepath1));
////		System.out.println("count_label_0: "+count_label_0);
//		System.out.println("count: "+count);
//		System.out.println("\n");
//		long endTime=System.currentTimeMillis(); //获取结束时间
//		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
//		System.out.println("============================================");
//	}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//	/**
//	 * @throws Exception
//	 * 分词方法
//	 * word分词法
//	 *
//	 */
//	private static void participle() throws Exception {
//		long startTime=System.currentTimeMillis();
//		String OutPath3 = "C:/Users/NewUser/Desktop/command/360_filter1_participle.csv";
//		String InPath3 = "C:/Users/NewUser/Desktop/command/360_filter1_keyword.csv";
//		List<String[]> data=importCsv(InPath3);
//		List<String[]> outdata3=new ArrayList<String[]>();
//		int count=0;
//
//		for (String[] strings : data) {
//			System.out.println(count);
//			List<Word> word = WordSegmenter.seg(strings[2]);
//			String []tempp={strings[0],strings[1],strings[2],word.toString()};
//    		outdata3.add(tempp);
//			count++;
//		}
//
//		for(int i=0;i<outdata3.size();i++){
//			System.out.println(outdata3.get(i));
//		}
//		long endTime=System.currentTimeMillis(); //获取结束时间
//		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
//		String aaa=(endTime-startTime)+"ms";
//		String[] ttime={aaa};
//		outdata3.add(ttime);
//		System.out.println("export result is "+exportCsv(outdata3,OutPath3));
//	}
//
//	/**
//	 * @throws Exception
//	 * 提取关键词主题函数
//	 */
//	private static void toKeyWord() throws Exception {
//		//变量定义
//		long startTime=System.currentTimeMillis();
//		int count=0;
//		String OutPath = "C:/Users/NewUser/Desktop/command/360_filter1.csv";
//		String OutPath2 = "C:/Users/NewUser/Desktop/command/360_filter1_keyword.csv";
//		List<String[]> outdata2=new ArrayList<String[]>();
//		String regex="<article id=bd_article> <h1>.*</h1>";
//
//		Pattern p=Pattern.compile(regex);
//		List<String[]> data=importCsv(OutPath);
//		for (String[] strings : data) {
//			System.out.println(count);
//			try {
//	            URL url=new URL(strings[2]);
//	            URLConnection conn=url.openConnection();
//	            HttpURLConnection httpConnection = (HttpURLConnection) conn;
//	            int responseCode = httpConnection.getResponseCode();
//	            if (responseCode == HttpURLConnection.HTTP_OK) {
//	                System.err.println("http connect success");
//	                InputStream in = httpConnection.getInputStream();
//	                InputStreamReader isr = new InputStreamReader(in);
//	                BufferedReader bufr = new BufferedReader(isr);
//	                String str;
//	                while ((str = bufr.readLine()) != null) {
//	                	Matcher m=p.matcher(str);
//	                	while(m.find()){
//	                		String temp=m.group().substring(28, m.group().length()-5);
//	                		String []tempp={strings[0],strings[2],temp};
//	                		outdata2.add(tempp);
//	                	}
//	                }
//	                bufr.close();
//	            } else {
//	            	System.err.println("http connect fail");
//	            }
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//			count++;
//		}
//
//
//		//输出列表
//		for(int i=0;i<outdata2.size();i++){
//			System.out.println(outdata2.get(i));
//		}
//		System.out.println("export result is "+exportCsv(outdata2,OutPath2));
//		long endTime=System.currentTimeMillis(); //获取结束时间
//		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
//	}
//	/**
//	 * @throws Exception
//	 * 处理url，将不合格的去除出去，留下合格的
//	 * 导入360_filter1.csv文件
//	 */
//	private static void firstWork() throws Exception {
//		long startTime=System.currentTimeMillis();
//		int count=0,count_down=0,count_up=0;
//		String filepath="C:/Users/NewUser/Desktop/command/360_200.csv";
//		String OutPath = "C:/Users/NewUser/Desktop/command/360_filter1.csv";
//		List<String[]> data=importCsv(filepath);
//		List<String[]> outdata=new ArrayList<String[]>();
//
//		//
//		for (String[] strings : data) {
//			count++;
//			System.out.println(count+": " );
//			String temp=urltest_1(strings[2]);
//			if(temp.length()<1000){
//				System.err.println("length<2000");
//				count_down++;
//			}else{
//				outdata.add(strings);
//				System.err.println("length>>>>2000");
//				count_up++;
//			}
//		}
//
//		//输出列表
//		System.out.println("--------begin--------");
//		System.out.println(count);
//		System.out.println("count_up: "+count_up);
//		System.out.println("count_down: "+count_down);
//		System.out.println(exportCsv(outdata,OutPath));
//		long endTime=System.currentTimeMillis(); //获取结束时间
//		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
//		System.out.println("---------end---------");
//	}
//
//	/**
//	 * @throws Exception
//	 * 测试url能否链接上
//	 */
//	public static String urltest_1(String link) {
//		String result="origin";
//		try {
//            URL url=new URL(link);
//            URLConnection conn=url.openConnection();
//            HttpURLConnection httpConnection = (HttpURLConnection) conn;
//            int responseCode = httpConnection.getResponseCode();
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                System.err.println("http connect success");
//                InputStream in = httpConnection.getInputStream();
//                InputStreamReader isr = new InputStreamReader(in);
//                BufferedReader bufr = new BufferedReader(isr);
//                String str;
//                while ((str = bufr.readLine()) != null) {
//                    result=str;
//                }
//                bufr.close();
//            } else {
//            	System.err.println("http connect fail");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//		return result;
//	}
//
//
//	public static List<String[]> importCsv(String filePath) throws Exception {
//		CsvReader reader = null;
//		char separator = ',';
//		List<String[]> dataList = new ArrayList<String[]>();
//		try {
//			reader = new CsvReader(filePath, separator, Charset.forName("GBK"));
//			reader.readHeaders();
//			while (reader.readRecord()) {
//				dataList.add(reader.getRawRecord().split(","));
//			}
//		} catch (Exception e) {
//			System.out.println("读取CSV出错..." + e);
//			throw e;
//		} finally {
//			if (null != reader) {
//				reader.close();
//			}
//		}
//		return dataList;
//	}
//
//
//
//	public static boolean exportCsv(List<String[]> dataList, String filePath) throws Exception {
//		boolean isSuccess = false;
//		CsvWriter writer = null;
//		FileOutputStream out = null;
//		char separator = ',';
//		try {
//			out = new FileOutputStream(filePath, true);
//			writer = new CsvWriter(out, separator, Charset.forName("GBK"));
//			for (String[] strs : dataList) {
//				writer.writeRecord(strs);
//			}
//			isSuccess = true;
//		} catch (Exception e) {
//			System.out.println("生成CSV出错..." + e);
//			throw e;
//		} finally {
//			if (null != writer) {
//				writer.close();
//			}
//			if (null != out) {
//				try {
//					out.close();
//				} catch (IOException e) {
//					System.out.println("exportCsv close Exception: " + e);
//					throw e;
//				}
//			}
//		}
//		return isSuccess;
//	}
//}
