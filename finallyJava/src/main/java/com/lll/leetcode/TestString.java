package com.lll.leetcode;
/**
 * 
 */


import java.util.Arrays;
import java.util.*;

/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time：2017年9月18日 下午6:02:02
* class illustration:
*/
/**
 * @author NewUser
 *
 */
public class TestString {
	/**
	 * @param args
	 * String topic Questions
	 * COME ON!
	 */
	public static void main(String[] args) {
		int n=3,num=0,count=0;
		 
	 
	}

	/**
	 * 
	 */
	private static void question541() {
		String s = "abcdefg";int k=2;
		
		
		int temp=s.length()/2*k;
		int left=s.length()-temp*2*k;
		String []str=new String[2*temp+2];
		StringBuilder result=new StringBuilder();
		for(int i=0;i<temp*2;i++){
			if(i%2==0){
				str[i]=new StringBuilder(s.substring(i*k, i*k+k)).reverse().toString();
			}else{
				str[i]=s.substring(i*k, i*k+k).toString();
			}
		}
		if(left<k){
			str[2*temp]=new StringBuilder(s.substring(temp*2*k,s.length())).reverse().toString();
			str[2*temp+1]="";
			
		}else if(left>=k){
			str[2*temp]=new StringBuilder(s.substring(temp*2*k,temp*2*k+k)).reverse().toString();
			str[2*temp+1]=s.substring(temp*2*k+k,s.length()).toString();
		}else if(left==0){
			str[2*temp]="";
			str[2*temp+1]="";
		}
		for(String st:str){
			result.append(st);
		}
		System.out.println(result.toString());
	}

	/**
	 * 
	 */
	private static void somepoints() {
		//字符串拼接，只进入string pool，编译期间执行的。
		String tt="iloveyou";
		tt=tt+'j';
		System.out.println(tt);
		
		String a="iloveyou";
		a.toString();
		
		Object a1=new Object();
		System.out.println(a1.toString());
		StringBuffer a2=new StringBuffer(20);
		
		String a3=a+1;
		System.out.println(a3);
		
		String c=a.substring(0, 2);
		System.out.println(c);
	}

	/**
	 * 真的很强，用了一些自带的和方便的函数
	 * 用了stringbuilder，能够方便的操作字符串，并且是可增的
	 * 利用tostring可以很快速的不断转换，从stringbuilder到string，嘿嘿。
	 */
	private static void question557_2() {
		String s="Let's take LeetCode contest";
		String []str=s.split(" ");
		for(int i=0;i<str.length;i++){
			str[i]=new StringBuilder(str[i]).reverse().toString();
		}
		StringBuilder result=new StringBuilder();
		for(String st:str)result.append(st+" ");
		System.out.println(result.toString().trim());
	}

	/**
	 * time	limit exceeded
	 * 
	 */
	private static void question557() {
		String s="Let's take LeetCode contest";
		char []temp=new char[s.length()];
		int wordnum=0,j=0;
		String result="";
		for(int i=0;i<s.length();i++){
			temp[j]=s.charAt(i);
			j++;
			if(s.charAt(i)==' '){
				for(int k=j-2;k>=0;k--){
					result+=temp[k];
				}
				result=result+' ';
				j=0;
			}
			if(i==s.length()-1){
				for(int k=j-1;k>=0;k--){
					result+=temp[k];
				}
			}
		}
		System.out.println(result);
	}

	/**
	 * 
	 */
	private static void question383() {
		String ma="iloveyou";
		String ra="idve";
		char []man=ma.toCharArray();
		char []ran=ra.toCharArray();
		int count=0;boolean result=false;
		for(int i=0;i<ra.length();i++){
			for(int j=0;j<ma.length();j++){
				if(ran[i]==man[j]){
					man[j]='1';
					count++;
					break;
				}
			}
		}
		if(count==ran.length) result=true;
		System.out.println(result);
	}

	/**
	 * 
	 */
	private static void question520() {
		char a='s';
		int aa=1;
		
		String temp="ifsadfaA";
		String temp1="0";
		System.out.println(temp.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+"));
		System.out.println(temp1.matches("[^a-zA-Z]"));
	}

	/**
	 * 
	 */
	private static void stringchar() {
		char temp[]={'a','b','c'};
		System.out.println(temp.toString());
		
		String aaa=Arrays.toString(temp);
		System.out.println("aaa "+aaa);
		String aaa2=String.valueOf(temp);
		System.out.println("aaa2 "+aaa2);
		
		String a="iloveyou";
		char[] arr=a.toCharArray();
		System.out.println(arr[0]);
		char[] arr2=new char[a.length()];
		for(int i=0;i<a.length();i++){
			arr2[i]=a.charAt(i);
		}
		System.out.println(arr[0]);
	}

	private static void question680() {
		String s="dabcba";
		boolean result=false;
		int len=s.length();
		char temp[]=new char[len];
		
		
		for(int i=0;i<len;i++){
			temp[i]=s.charAt(len-1-i);
		}
		String reverse=String.valueOf(temp);
		
		System.out.println("s      :"+s);
		System.out.println("reverse:"+reverse);
		
		/*int i=0;
		String s_new=s.substring(0, i)+s.substring(i+1,len);
		String reverse_new=reverse.substring(0, len-i-1)
				+reverse.substring(len-i, len);
		
		System.out.println("s_new      :"+s_new);
		System.out.println("reverse_new:"+reverse_new);*/
		
		if(s.equals(reverse))result=true;
		else{
			for(int i=0;i<len;i++){
				String s_new=s.substring(0, i)+s.substring(i+1,len);
				String reverse_new=reverse.substring(0, i)
						+reverse.substring(i+1, len);
				if(s_new.equals(reverse_new)){
					result=true;
					break;
				}
			}
		}
		System.out.println(result);
	}
	/**
	 * 
	 */
	private static void quesiont459_2() {
		String s="abcabcabcabc";
		boolean jieguo=false;
		int len=s.length();
		for(int i=len/2;i>=1;i--){
			if(len%i==0){
				String temp=s.substring(0, i);
				StringBuilder result=new StringBuilder();
				for(int j=0;j<len/i;j++){
					result.append(temp);
				}
                jieguo = result.toString().equals(s);
			}
		}
		System.out.println(jieguo);
	}

	/**
	 * 
	 */
	private static void quesiont459() {
		String s="aaa";
		
		int count=0;
		char one =s.charAt(0);
		for(int i=1;i<s.length();i++){
			if(one==s.charAt(i)){
				count=i;
				break;
			}
		}
		String copy=s.substring(0, count);
		String result=copy;
		if(count==1){
			for(int i=0;i<s.length()-1/count;i++) 
				result=result+copy;
		}else{
			for(int i=0;i<s.length()/(count+1);i++) 
				result=result+copy;
		}
		
		System.out.println("result "+result);
		System.out.println(1/3);
	}

	/**
	 * 
	 */
	private static void question345() {
		String s="leetcode";
		
		
		char []yuanyin={'a','e','i','o','u'};
		int len=s.length();
		char temp[]=s.toCharArray();
		int count=0;
		char ttt;
		int location[]=new int [len];
		for(int i=0;i<len;i++){
			for(int j=0;j<5;j++){
				if(temp[i]==yuanyin[j]){
					location[count]=i;
					count++;
				}
			}
		}
		for(int i=0;i<count/2;i++){
			ttt=temp[location[i]];
			temp[location[i]]=temp[location[count-i-1]];
			temp[location[count-i-1]]=ttt;
		}
		String result=new String(temp);
		System.out.println(result);
	}
}











