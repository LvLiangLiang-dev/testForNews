/**
 * 
 */
package com.lll.algorithm.recursion;
/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time：2017年7月21日 下午5:00:43
* class illustration:
*/
/**
 * @author NewUser
 *
 */
public class queen8 {
	static int [][]show=new int[9][9];
	static int count=1;
	public static void main(String []args){
		method(1);
	}
	/*
	 * 这就是所谓的回溯算法
	 * 在这里是和递归一起体现的
	 * 主要是递归某一层不进入下一层的时候要注意后面的清理上一步的痕迹。
	 * 然后就能在形式上是回退一步，因为是清理了上次的痕迹，在这条路的最后阶段，最后两步都结束的时候就会回退两步
	 * 以此类推，就能回退所有的痕迹。
	 * 就是所谓的试错法。
	 */
	private static void method(int i) {
		if(i>8){
			printt(show);
		}else{
			for(int j=1;j<9;j++){
				show[i][j]=1;
				if(islegal(i,j))  method(i+1);
				show[i][j]=0;
			}
		}
	}
	private static boolean islegal(int i, int j) {
		if(i==1)return true;
		else{
			for(int m=1;m<9;m++)
				for(int k=1;k<i;k++){
					if(show[k][m]==1){
						if(m==j||Math.abs(i-k)==Math.abs(j-m)){
							return false;
						}
					}
				}
		}
		return true;
	}
	private static void printt(int[][] show2) {
		System.out.println(count);
		for(int k=1;k<9;k++){
			for(int m=1;m<9;m++){
				System.out.print(show[k][m]);
			}
			System.out.print("\n");
		}
		count++;
	}
}
