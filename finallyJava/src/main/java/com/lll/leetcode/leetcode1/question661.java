/**
 * 
 */
package com.lll.leetcode.leetcode1;
/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time：2017年9月8日 上午8:48:02
* class illustration:
*/
/**
 * @author NewUser
 *
 */
public class question661 {
	public static void main(String []args){
		int[][]a={{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				System.out.print(a[i][j]+' ');
			}
			System.out.print("\n");
		}
		System.out.println("\n");
		int [][]r=imageSmoother(a);
		for(int i=0;i<r.length;i++){
			for(int j=0;j<r[0].length;j++){
				System.out.print(r[i][j]+' ');
			}
			System.out.print("\n");
		}
		
		int a1=5/6;
		System.out.println(a1);
	}
	public static int[][] imageSmoother(int[][] M) {
		if(M==null)return null;
		int len=M.length;
        if(len==0)return new int[len][];
		int wide=M[0].length;
		int result[][]=new int[len][wide];
		int fm=0;
		int fz=0;
		for(int i=0;i<len;i++){
			for(int j=0;j<wide;j++){
				for(int x:new int[]{-1,0,1}){
					for(int y:new int[]{-1,0,1}){
						boolean temp=false;
						if(i+x>=0&&j+y>=0&&i+x<len&&j+y<wide)temp=true;
						if(temp){
							fm++;
							fz=fz+M[i+x][j+y];
						}
					}
				}
				result[i][j]=fz/fm;
			}
		}
		return result;
	}
}