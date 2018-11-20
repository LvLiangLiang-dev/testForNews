package com.lll.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


public class testArray {
	public static class Node{
		int value;
		Node next;
		public Node(int n){
			this.value=n;
			this.next=null;
		}
	}
	public static void main(String[] args) {
		//int []a = null;
		//a[0]=1;
		//System.out.println(a[0]);
		//数组是个对象，没有new一个空间，直接赋值，是出错的。
		
		int[]a1=new int[10];
		a1[0]=9;
		System.out.println(a1[2]);
		//数组的初始值是0
		
	}
	/**
	 * 
	 */
	private static void question_167() {
		int numbers[]={2,3,4,5,7, 11, 15};
		int target=18,len=numbers.length;
        int []result=new int[2];
        int slow=0;int faster=1;
        while(numbers[slow]+numbers[faster]!=target){
        	if(slow<len&&faster<len&&numbers[slow]+numbers[faster]<target){
                faster++;
            }else if(slow<len&&faster<len&&numbers[slow]+numbers[faster]>target){
                faster--;
                slow++;
            }
        	
        	//if(faster)
        }
        result[0]=slow;
        result[1]=faster;
        System.out.println("slow:"+numbers[slow]+"    faster:"+numbers[faster]);
	}
	/**
	 * 
	 */
	private static void intAndInteger() {
		int i = 128;
        Integer i2 = 128;
        Integer i3 = new Integer(128);
        //Integer会自动拆箱为int，所以为true
        System.out.println("1"+(i == i2));
        System.out.println(i == i3);
        System.out.println("**************");
        Integer i5 = 127;//java在编译的时候,被翻译成-> Integer i5 = Integer.valueOf(127);
        Integer i6 = 127;
        System.out.println(i5 == i6);//true
        /*Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6);//false
*/        Integer ii5 = new Integer(127);
        System.out.println(i5 == ii5); //false
        Integer i7 = new Integer(128);
        Integer i8 = new Integer(128);
        System.out.println(i7 == i8);  //false
        System.out.println(i7.hashCode()+"i"+i8.hashCode());  //false
        
        int a=1,b=1;
        Integer c=1;
        System.out.println(c.equals(a));
        
        Integer aa=Integer.valueOf(-128);
        Integer bb=-128;
        Integer ccc;

        System.out.println("aa==bb"+(aa==bb));
        
        Integer aa1=127;
        Integer bb1=127;
        System.out.println("aa1==bb1"+(aa1==bb1));
        
        
        List am=new ArrayList();
        am.add(bb);
        am.add(1);
	}
	/**
	 * 
	 */
	private static void question_414() {
		int[] nums={1,2,3,8,7,10};
		int result=0;
		Integer []save=new Integer [3];
		save[0]=save[1]=save[2]=null;
		for(Integer n:nums){
			if(n.equals(save[0])||n.equals(save[1])||n.equals(save[2]))continue;
			if(save[0]==null||n>save[0]){
				save[2]=save[1];
				save[1]=save[0];
				save[0]=n;
			}else if(save[1]==null||n>save[1]){
				save[2]=save[1];
				save[1]=n;
			}else if(save[2]==null||n>save[2]){
				save[2]=n;
			}
		}
		if(save[2]!=null&&save[0]!=save[1]&&save[1]!=save[2])
			result=save[2];
		else result=save[0];
		System.out.println(result);
	}
	/**
	 * 
	 */
	private static void demo16() {
		int []nums={1,3,4,5,2,6,1};
		boolean a=true;
		//if(k==0&&nums.length>=0)return true;
        Map<Integer,Integer> result=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            result.put(nums[i],result.getOrDefault(nums[i],0)+1);
        }
        for(int i=0;i<result.size();i++){
            //result.get(nums[i])==result.get(nums[i]+k)
        }
	}
	/**
	 * 
	 */
	private static void demo15() {
		List<Integer> temp=new ArrayList<Integer>();
		temp.add(4);
		temp.add(9);
		
		temp.add(0,44);
		//temp.set(3, 3);
		for(int i=0;i<temp.size();i++)
			System.out.println(temp.get(i).toString());
		
		System.out.println("size="+temp.size());
		System.out.println("===========================");
		
		List<Integer> tt=new ArrayList<Integer>(temp);
		System.out.println(tt);
		if(tt==temp)System.out.println("=");
		else System.out.println("!=");
	}
	/**
	 * 
	 */
	private static void demo14() {
		Map map = new HashMap();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("key4", "value4");
		Set set = map.keySet();//将map的kye放到set里了
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			String key =  (String)iter.next();
			System.out.println("key=" + key + "  value=" + map.get(key));
		}
		System.out.println("----------------------------------------------------");
		Iterator iter1 = map.entrySet().iterator();
		while(iter1.hasNext()){
			Map.Entry me = (Map.Entry)iter1.next();
			System.out.println("key=" + me.getKey() + " value=" + me.getValue());
		}
	}
	/**
	 * 
	 */
	private static void demo13() {
		HashMap<Integer,Integer>ff=new HashMap<Integer,Integer>();
		ff.put(1, 10);
		ff.put(2, 11);
		int a=ff.getOrDefault(3, 0);
		int a1=ff.get(1);
		System.out.println(a1);
		
		System.out.println(ff.entrySet());
	}
	/**
	 * 
	 */
	private static void demo12() {
		int a[]={1,4,3,2,5,8,7,6};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		int c[]={1,4,3,2,5,8,7,6};
		for(int num:c){
			System.out.print(num);
		}
	}
	/**
	 * 
	 */
	private static void demo11() {
		/*
		 * 定义数组的俩种方式，我们只是得到了一个数组的引用，
		 * 此时已经为引用分配了空间，但是还没有为数组对象本身分配空间，
		 * 想要给数组对象本身分配空间，必须要初始化才行。
		 */
		int t1[];
		int [] t2;
		
		int t3[]={1,2,3};//等价于new来进行空间分配，，这是静态赋值
		int t4[]=t3;     //给数组的引用赋值
		int t5[]=new int [1];//此为 动态赋值
		t5[0]=1;
		
		int t6[]=null;
		//如果再赋值，就会抛出空指针异常。
	}
	/**
	 * 
	 */
	private static void demo10() {
		System.out.println(10^2);
		 System.out.println((int)Math.pow(10, 2));
		 System.out.println(25%10);
		 System.out.println(25/10);
	}
	public static void demo9(){
		String a="1";
		int[] b={1,2,3};
		demo8(a,b);
		System.out.println(a);
		System.out.println(b[0]);
		System.out.println(b[1]);
	}
	public static void demo8(String a,int x[]){
		a="2";
		x[0]=4;
		x[1]=5;
	}

	public static void demo7(){
		@SuppressWarnings("rawtypes")
		List<Map> ls=new ArrayList<Map>();
		Map map1=new HashMap();
		map1.put(1, "zhangsan");
		map1.put(2, "lisi");
		
		Map map2=new HashMap();
		map2.put(1, "wangwu");
		ls.add(map1);
		ls.add(map2);
		System.out.println(ls.get(1));
		System.out.println(map1.get(1));
		System.out.println(map1.toString());
		//ls.add((Collection<? extends Map>) map1.get(1));
		
		Stack<Character> ss=new Stack<Character>();
	}
	public static void demo6(){
		List<Map> data=new ArrayList<Map>();
		/*Map map1={FREQUENCY=1, TOPIC_SN=RA26-lulu,
				ID=0000490-170619143314125-oozie-root-C, ENDTIME=2017-08-05 00:00:00, 
				STARTTIME=2017-07-19 04:03:00, SIZE=1, STATUS=RUNNING, 
				NEXTTIME=2017-07-20 04:03:00, OPERATE=, USER=admin};
		data={FREQUENCY=1, TOPIC_SN=RA26-lulu, ID=0000490-170619143314125-oozie-root-C, ENDTIME=2017-08-05 00:00:00, STARTTIME=2017-07-19 04:03:00, SIZE=1, STATUS=RUNNING, NEXTTIME=2017-07-20 04:03:00, OPERATE=, USER=admin};*/
		Map map1 = new HashMap();
		map1.put("name", "lll");
		System.out.println(map1.get("name"));
	}
	public static void demo5(){
		Node head=null;
		Node last=null;
		head=new Node(2);
		head.next=new Node(3);
		head.next.next=new Node(4);
		head.next.next.next=new Node(5);
		head.next.next.next.next=new Node(6);
		head.next.next.next.next.next=new Node(7);
		 
		 
		Node head1=null;
		head1=new Node(11);
		head1.next=new Node(12);
		head1.next.next=new Node(13);
		head1.next.next.next=new Node(14);
		head1.next.next.next.next=new Node(15);
		head1.next.next.next.next.next=new Node(16);
		
		head1=head;
		head.next.next=new Node(99);
		System.out.println(head1.next.next.value);
		System.out.println(head.next.next.value);
		System.out.println(head1.next.next);
		System.out.println(head.next.next);
	}
	public static void demo4(){
		Scanner in=new Scanner(System.in);//这就是是java接受控制台的输入

		//System.out.println(in.nextInt()); //从输出流返回一个int
		//System.out.println(in.nextLine()); //从输出流返回一个string
		
		Node head=null;
		if(in.hasNextInt()){
			head=new Node(in.nextInt());
		}
		Node temp=head;
		while(in.hasNextInt()){
			temp.next=new Node(in.nextInt());
			temp=temp.next;
		}
		in.close();
		System.out.println(getListLength(head));
		
	}
	
	public static int getListLength(Node head){
		int len=0;
		while(head!=null){
			len++;
			head=head.next;
		}
		return len;
	}
	public static void demo3(){
		//list
		LinkedList<String> ll=new LinkedList<String>();
		ll.add("1");
		ll.add("2");
		ll.add("3");
		ll.add("4");
		ll.add("5");
		System.out.println(ll.getFirst());
		System.out.println(ll.getLast());
	}
	public static void demo2(){
		String []str={"cc","dddd","323423","3216543243"};
		int i=str.length;
		System.out.println(i);
		String []temp2={"a","b"};
		String aa=temp2[0]+temp2[1];
		System.out.println(aa);	
		
		String []temp3 = null;
		//temp3[0]="a";
		//temp3[1]="b";
		//String bb=temp3[0]+temp3[1];
		//System.out.print(bb);
		
		String tt="fasdfa";
		System.out.println(tt.length());
		String a="a";
		String b="b";
		String c=a+b;
		System.out.println(c);
		
		System.out.println("---------------------------------");
		char[]ac=new char[9];
		ac[2]=tt.toCharArray()[2];
		ac[1]=tt.toCharArray()[1];
		ac[0]=tt.toCharArray()[0];
		String ta=new String(ac,0,3);
		System.out.println(ta);
		System.out.println("---------------------------------");
		String ty;
		ty=null;
		ty="a"+"b";
		
		System.out.println("---------------------------------1");
		System.out.println(ty.indexOf(b));
		System.out.println("---------------------------------2");

		int []num={1,2,3,1,2,3};
		if(num[0]==num[3]&&num[1]==num[4]&&num[2]==num[5]){
			System.out.println("jjj");
			
		}
		
		
		
	}
	public static void demo1(){
		System.out.println(12%10);
		System.out.println(-22/10);
		System.out.println(2%10);
		System.out.println(Math.pow(10,2));
	
		String result;
		
		String d="-123";
		result=d.substring(1);
		String ac=new StringBuilder(d).reverse().toString();
		System.out.println(ac);
		
		System.out.println("-------------------------------");
		String a="12345";
		
		StringBuffer sb=new StringBuffer(a);
		sb.insert(0, '-');
		String s=sb.toString();
		System.out.println(s);
	}
}