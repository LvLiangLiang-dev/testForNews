package com.lll.leetcode;//package com.lll.leetcode;
//
//import java.net.*;
//import java.net.URLConnection;
//import java.nio.charset.Charset;
//import java.util.*;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Queue;
//import java.util.*;
//import com.csvreader.CsvReader;
//import com.csvreader.CsvWriter;
//
///**
//* @author lvliangliang E-mail:lvliangbupt@136.com
//* @version Create time：2017年9月25日 下午6:04:21
//* class illustration:
//*/
///**
// * @author NewUser
// */
//
//public class TestHashTable {
//	public static void main(String[] args) throws Exception {
//		int []nums={1,2,3};
//		int size=nums.length;
//		System.out.println(size);
//	}
//	/**
//	 *
//	 */
//	private static void question507() {
//		int num=28;
//		boolean result;
//		if(num==1)result=false;
//		int temp=1;
//		for(int i=2;i<=(int)Math.sqrt(num);i++){
//			if(num%i==0){
//				 temp=temp+i+num/i;
//			}
//		}
//		result = temp == num;
//	}
//	/**
//	 *
//	 */
//	private static void question645() {
//		int []nums={3,2,2};
//		Set<Integer>set=new HashSet();
//		int error=-1,temp=-1;
//		int []result=new int[2];
//		for(int i=0;i<nums.length;i++){
//			if(!set.add(nums[i])){
//				error=nums[i];
//			}
//		}
//		if(set.contains(error+1)){
//			result[0]=error-1;
//			result[1]=error;
//		}else{
//			if(!set.contains(1)&&error==2){
//				result[1]=error-1;
//				result[0]=error;
//			}else{
//                result[0]=error;
//			    result[1]=error+1;
//            }
//		}
//		 if(nums[0]>nums[1]&&result[0]<result[1]){
//		     temp=result[0];
//		     result[0]=result[1];
//		     result[1]=temp;
//		 }
//		 if(nums[0]<nums[1]&&result[0]>result[1]){
//		     temp=result[0];
//		     result[0]=result[1];
//		     result[1]=temp;
//		 }
//		System.out.println(Arrays.toString(result));
//	}
//	/**
//	 *
//	 */
//	private static void question69() {
//		int x=7;
//		int left=1,right=x;
//		int result=-1,mid=0,temp;
//		while(left<=right){
//			 mid=(left+right)/2;
//			 temp=mid*mid;
//			if(temp==x)result=mid;
//			else if(temp>x)right=mid-1;
//			else if(temp<x)left=mid+1;
//		}
//		int result2= mid*mid >x?mid-1:mid;
//		System.out.println(result);
//		System.out.println(result2);
//	}
//	/**
//	 *
//	 */
//	private static void question447() {
//		int[][] points={{0,0},{1,0},{2,0}};
//
//		int length=points.length,result=0,result1=0;
//		int [][]temp=new int[length][length];
//		Set<Integer>set=new HashSet<Integer>();
//		for(int i=0;i<length;i++){
//			for(int j=0;j<length;j++){
//				temp[i][j]=(int) (Math.pow((points[i][0]-points[j][0]), 2)+
//						Math.pow((points[i][1]-points[j][1]), 2));
//			}
//		}
//		for(int i=0;i<length;i++){
//			for(int j=0;j<length;j++){
//				if(i==j)continue;
//				if(set.add(temp[i][j])==false)result++;
//			}
//			set.clear();
//			System.out.println(result);
//			if(result>0)result1=result1+result*(result+1);
//			result=0;
//		}
//
//		System.out.println("result1:"+result1);
//	}
//	/**
//	 *
//	 */
//	public static  int  a(int b){
//		int result=0;
//
//		for(int i=1;i<=b;i++)
//			result=result+result*i;
//		if(b==0)result=0;
//		return result;
//	}
//	private static void question463() {
//		 int [][]grid={{1,1,1},{0,1,0}};
//		 int t0=0,t3=0,t2=0,tx=0,temp;
//			int length=grid.length,wide=grid[0].length;
//			int [][]grids=new int[length+2][wide+2];
//			for(int i=1;i<length+1;i++)
//				for(int j=1;j<wide+1;j++){
//					grids[i][j]=grid[i-1][j-1];
//				}
//			for(int i=1;i<length+1;i++)
//				for(int j=1;j<wide+1;j++){
//					if(grids[i][j]==1){
//						temp=grids[i-1][j]+grids[i][j-1]+grids[i+1][j]+grids[i][j+1];
//						if(temp==0)t0++;
//						if(temp==2)t2++;
//						if(temp==1)t3++;
//	                    if(temp==3)tx++;
//					}
//				}
//			int result=t3*3+t2*2+t0*4+tx*1;
//	}
//	/**
//	 *
//	 */
//	private static void question500() {
//		String[] words={"Hello", "Alaska", "Dad", "Peace"};
//		String[] result=new String[words.length];
//		int num=0;
//		for(int i=0;i<words.length;i++){
//			if(words[i].toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")){
//				result[num]=words[i];
//				num++;
//			}
//		}
//		String[] rr=new String[num];
//		rr=result;
//		System.out.println(rr[0]);
//	}
//	/**
//	 *
//	 */
//	private static void question575() {
//		int[] candies={1,1,2,2,3,3};
//
//		Set<Integer>set=new HashSet();
//		for(int i=0;i<candies.length;i++)set.add(candies[i]);
//		int result=set.size()>=candies.length/2?candies.length/2:set.size();
//		System.out.println(result);
//	}
//	/**
//	 *
//	 */
//	private static void question594() {
//		int []nums={1,3,2,2,5,2,3,2,3,2,3,7};
//
//		Map<Integer,Integer>map=new HashMap();
//		Integer max=Integer.MIN_VALUE;
//		int a=0,b=0;
//
//
//		for(int i=0;i<nums.length;i++)map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//		for(int i=0;i<nums.length;i++){
//			a=nums[i];
//			if(map.get(a-1) != null){
//				if(map.get(a)+map.get(a-1)>max){
//					max=map.get(a)+map.get(a-1);
//				}
//			}
//			if(map.get(a+1) != null){
//				if(map.get(a)+map.get(a+1)>max){
//					max=map.get(a)+map.get(a+1);
//				}
//			}
//		}
//		System.out.println(max);
//	}
//	/**
//	 *
//	 */
//	private static void TestToArray() {
//		List<String>list=new LinkedList<String>();
//		list.add("aaa");
//		list.add("bbb");
//		list.add("ccc");
//		list.add("ddd");
//		list.add("eee");
//		String []a=list.toArray(new String[9]);
//		System.out.println(a[1]);
//		System.out.println(a[8]);
//		System.out.println(list.toArray(new String[9]));
//		System.out.println(list.toArray());
//	}
//	/**
//	 *
//	 */
//	private static void quesiont599_2() {
//		String []list1={"Shogun", "Tapioca Express", "Burger King", "KFC"};
//		String []list2={"KFC","Shogun","Burger King"};
//
//		Map<String,Integer>map=new HashMap<String,Integer>();
//		List<String> list=new LinkedList<String>();
//		for(int i=0;i<list1.length;i++)map.put(list1[i], i);
//		Integer min=Integer.MAX_VALUE;
//		for(int i=0;i<list2.length;i++){
//			Integer temp=map.get(list2[i]);
//			if(temp!=null&&temp+i<=min){
//				 if(temp+i<min){
//	                    list.clear();
//					    min=temp+i;
//					    System.out.println(min);
//	                }
//				list.add(list2[i]);
//			}
//		}
//
//		System.out.println(list.get(0));
//	}
//	/**
//	 *
//	 */
//	private static void queue_test() {
//		Queue<Integer>queue=new LinkedList<Integer>();
//		queue.offer(1);
//		queue.offer(2);
//		System.out.println("size=	 "+queue.size());
//		System.out.println("element= "+queue.element());
//		System.out.println("poll=    "+queue.poll());
//		System.out.println("element= "+queue.element());
//		System.out.println("size=	 "+queue.size());
//		System.out.println("poll=    "+queue.poll());
//		System.out.println("size=	 "+queue.size());
//	}
//	/**
//	 *
//	 */
//	private static void question389_2() {
//		String s = "abcde";
//		String t = "abcdef";
//		char a=0;
//		for(int i=0;i<s.length();i++)a^=s.charAt(i);
//		for(int i=0;i<t.length();i++)a^=t.charAt(i);
//		System.out.println(a);
//	}
//	/**
//	 *
//	 */
//	private static void question389() {
//		String s = "abcde";
//		String t = "abcdef";
//
//		char result='0';
//		Map<Character,Integer> map=new HashMap<Character,Integer>();
//		for(int i=0;i<s.length();i++){
//			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
//		}
//		for(int i=0;i<t.length();i++){
//			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
//		}
//		Map<Integer,Character> map1=new HashMap<Integer,Character>();
//		for(Character cc:map.keySet()){
//			Integer te=1;
//			if(te.equals(map.get(cc))){
//				result=cc;
//			}
//		}
//		System.out.println(result);
//	}
//	/**
//	 *
//	 */
//	private static void FourMethodsErgodic() {
//		Map<String,String>map=new HashMap<String,String>();
//		map.put("1", "v1");
//		map.put("2", "v2");
//		map.put("3", "v3");
//		System.out.println(map.entrySet());
//		System.out.println(map.keySet());
//		for(String key:map.keySet()){
//			System.out.println("key="+key+" and value="+map.get(key));
//		}
//		for(String value:map.values()){
//			System.out.println("value= "+value);
//		}
//		for(Entry<String, String>entry:map.entrySet()){
//			System.out.println(entry.getKey()+" "+entry.getValue());
//		}
//		System.out.println(4);
//		Iterator it=map.entrySet().iterator();
//		while(it.hasNext()){
//			Entry  entry=(Entry) it.next();
//			System.out.println(entry.getKey()+" "+entry.getValue());
//		}
//	}
//	private static void question599() {
//		String []list1={"Shogun", "Tapioca Express", "Burger King", "KFC"};
//		String []list2={"KFC", "Shogun", "Burger King"};
//
//		int sum=0;
//		Map map1=new HashMap();
//		Map result=new HashMap();
//		String []results=new String[list1.length];
//
//		for(int i=0;i<list1.length;i++){
//			map1.put(list1[i],i);
//		}
//
//		if(list1.length>list2.length){
//			for(int i=0;i<list2.length;i++){
//				if(map1.containsKey(list2[i])){
//					sum=i+(int)map1.get(list2[i]);
//					result.put(list2[i], sum);
//				}
//			}
//		}
//	}
//
//	@SuppressWarnings("unused")
//	private static void question290() {
//		String pattern="abaa";
//		String str="dog cat cat dog";
//
//		Map  map=new HashMap ();boolean result=true;
//		String[]words=str.split(" ");
//		if(pattern.length()!=words.length)result=false;
//		for(int i=0;i<words.length;i++){
//			if(map.put(pattern.charAt(i), i)!=map.put(words[i], i))result=false;
//		}
//		System.out.println(result);
//	}
//
//}