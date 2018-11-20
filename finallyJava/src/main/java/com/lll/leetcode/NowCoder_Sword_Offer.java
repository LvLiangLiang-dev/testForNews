package com.lll.leetcode;


import org.junit.Test;

import java.util.*;

/**
 * Created by lvliangliang on 2018/01/04.
 */
public class NowCoder_Sword_Offer {
    public static void main(String[] args) {
        ;
    }

    @Test
    public void test() {
//        TreeNode root = null, l1 = null, r1 = null, r1l2 = null, r1r2 = null;
//        root.val = 3;
//        root.left = l1;
//        root.right = r1;
//        l1.val = 9;
//        r1.val = 20;
//        r1.left = r1l2;
//        r1.right = r1r2;
//        r1l2.val = 15;
//        r1r2.val = 7;
//        ArrayList<ArrayList<Integer>> list = Print(root);
//        System.out.println(list);

//
//        char arr[] = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e' };
//        char str[] = {'b', 'c', 'c', 'e', 'd' };
//        System.out.println(hasPath2(arr, 3, 4, str));

        System.out.println(helps(123));
    }

    /**
     *      机器人的运动范围
     *      地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
     *      每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
     *      例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
     *      但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
     *      请问该机器人能够达到多少个格子？
     */
    public int movingCount(int threshold, int rows, int cols)
    {
        int rd[]=new int[rows*cols];
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                if(helps(i)+helps(j)<=18)count++;
            }
        }
        return count;
    }

    private int helps(int i) {
        int res=0;
        while(i/10>=1){
            res+=i%10;
            i=i/10;
        }
        res+=i;
        return res;
    }

    /**
     * 矩阵中的路径
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
     * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
     * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
     * 路径不能再次进入该格子。
     *          cann't do it
     *          i want to fuck
     *          shit
     *
     */

    public boolean hasPath2(char[] matrix, int rows, int cols, char[] str) {
        int[] rd = new int[matrix.length];
        int index = 0;
        int trail = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                index = i * cols + j;
                if (judge(matrix, rows, cols, str, i, j, trail, rd)) return true;
            }
        }
        return false;


    }

    private boolean judge(char[] matrix, int rows, int cols, char[] str, int i, int j, int trail, int[] rd) {
        if (i < 0 || i > rows || j < 0 || j > cols || str[trail] != matrix[i * cols + j]) return false;
        if (trail == str.length-1) return true;
        rd[i * cols + j] = 1;
        if (judge(matrix, rows, cols, str, i + 1, j, trail + 1, rd)
                || judge(matrix, rows, cols, str, i - 1, j, trail + 1, rd)
                || judge(matrix, rows, cols, str, i, j + 1, trail + 1, rd)
                || judge(matrix, rows, cols, str, i, j - 1, trail + 1, rd)
                )return true;
        rd[i * cols + j] = 0;
        return false;
    }



    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] rd = new boolean[matrix.length];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                if (help(matrix, rows, cols, i, j, str, 0, rd))
                    return true;
            }
        return false;
    }

    private boolean help(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, boolean[] rd) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k]) return false;
        if (k == str.length - 1) return true;
        rd[k] = true;
        if (help(matrix, rows, cols, i + 1, j, str, k + 1, rd)
                || help(matrix, rows, cols, i - 1, j, str, k + 1, rd)
                || help(matrix, rows, cols, i, j + 1, str, k + 1, rd)
                || help(matrix, rows, cols, i, j - 1, str, k + 1, rd)
                ) return true;
        rd[k] = false;
        return false;
    }

    /**
     * 把二叉树打印成多行
     * 层次遍历，只不过要建立俩个arraylist
     * ?
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> all_list = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> linked = new LinkedList<TreeNode>();
        if (pRoot == null) return all_list;
        TreeNode temp;
        linked.add(pRoot);
        int i = 0, len = 0;
        while (!linked.isEmpty()) {
            len = linked.size();
            i = 0;
            while (i < len) {
                temp = linked.remove();
                list.add(temp.val);
                if (temp.left != null) linked.add(temp.left);
                if (temp.right != null) linked.add(temp.right);
                i++;
            }
            all_list.add(list);
            list.clear();
        }
        return all_list;
    }

    /**
     * 构建乘积数组
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
     * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
     * 不能使用除法。
     * <p>
     * 自己：暴力法
     * 答案：拆开乘的，虽然也是拆开的，但是降低了一个级别的复杂度，很棒`吗的真的没想到
     */
    public int[] multiply2(int[] A) {
        int n = A.length;
        int[] rd = new int[n];
        int temp = 1;
        rd[0] = 1;
        for (int i = 0; i < n - 1; ) {
            temp *= A[i];
            i++;
            rd[i] = temp;
        }
        int temp2 = 1;
        for (int i = n - 1; i > 0; ) {
            temp2 *= A[i];
            i--;
            rd[i] *= temp2;
        }
        return rd;
    }

    public int[] multiply(int[] A) {
        int n = A.length;
        int[] rd = new int[n];
        int temp = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                temp = temp * A[j];
            }
            for (int j = i + 1; j < n; j++) {
                temp = temp * A[j];
            }
            rd[i] = temp;
            temp = 1;
        }
        return rd;
    }


    /**
     * 数组中重复的数字
     * 自己：用了hashmap，全部记录下来个数，然后再次循环吧、判断value的值是否大于1
     * 标记法：  ?
     */
    public boolean duplicate2(int numbers[], int length, int[] duplication) {
        int temp = -1;
        for (int i = 0; i < length; i++) {
            temp = numbers[i];
            if (temp < 0) {
                if (i == -1 * temp) {
                    duplication[0] = i;
                    return true;
                }
                continue;
            }
            numbers[temp] = -1 * numbers[temp];
        }
        return false;
    }

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
        }
        for (int i = 0; i < length; i++)
            if (map.get(numbers[i]) > 1) {
                duplication[0] = numbers[i];
                return true;
            }
        return false;
    }


    /**
     * 翻转单词顺序
     */
    public String ReverseSentence(String str) {
        ArrayList<String> list = new ArrayList<String>();

        int temp = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                list.add(str.substring(temp, i));
                temp = i + 1;
            }
        }
        list.add(str.substring(temp, str.length()));
        String res = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            res += list.get(i) + " ";
        }
        return res.substring(0, res.length() - 1);

    }

    /**
     * 左旋转字符串
     * 自己：通过每次转移一次，一共转移几次就调用几次函数
     * 答案：通过求余数来达到这个解决方案
     * 需要注意的substring函数，都是些小写，然后第二个参数是最后一位还要加上1
     */
    public String LeftRotateString2(String str, int n) {

        if (str.length() == 0) return "";
        int length = str.length();
        int temp = n % length;
        str = str + str;
        return str.substring(temp, temp + length);
    }

    public String LeftRotateString(String str, int n) {
        for (int i = 0; i < n; i++)
            str = help(str);
        return str;
    }

    public String help(String str) {
        int n = str.length();
        str = str.substring(1, n) + str.charAt(0);
        return str;
    }

    /**
     * 和为s的俩个数字
     * 输入一个递增排序的数组和一个数字S，
     * 在数组中查找两个数，是的他们的和正好是S，
     * 如果有多对数字的和等于S，输出两个数的乘积最小的。
     * <p>
     * 因为是递增的，可以考虑用俩个指针，前后逼近，想加比较
     * 可以证明第一次出现的俩个值是最小的。
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int r = array.length - 1;
        int l = 0;
        while (l < r) {
            if (array[l] + array[r] == sum) {
                list.add(array[l]);
                list.add(array[r]);
                break;
            }
            while (array[l] + array[r] > sum) r--;
            while (array[l] + array[r] < sum) l++;
        }
        return list;
    }

    /**
     * 数组中只出现一次的数字
     * 自己写的：利用HashMap
     * 答案：算法  ？没看
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                if (temp == 0) {
                    num1[0] = array[i];
                    temp++;
                }
                if (temp == 1) {
                    num2[0] = array[i];
                }
            }
        }
    }
    /**
     * 统计一个数字在排序数组中出现的次数。
     *
     */


    /**
     * 丑数
     * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
     * 例如6、8都是丑数，但14不是，因为它包含因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
     * <p>
     * 没写出来    ？
     * 用DP去思考
     * 每个现在的树都是之前的某个数的2/3/5倍，所以通过这种等长的后移，可以覆盖每一个书
     * 比较巧妙
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        int[] rd = new int[index];
        rd[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < index; i++) {
            rd[i] = Math.min(rd[t2] * 2, Math.min(rd[t3] * 3, rd[t5] * 5));
            if (rd[i] == rd[t2] * 2) t2++;
            if (rd[i] == rd[t3] * 3) t3++;
            if (rd[i] == rd[t5] * 5) t5++;
        }
        return rd[index - 1];
    }


    /**
     * 把数组排成最小的数
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     * 这一题没想出来。。。。。。。。。。。。。
     * 巧妙的地方是通过collections   集合的一个工具类
     * sort排序函数可以定义compare函数，也就是定义排序规则，然后就是默认的排序方法，可以达到最终的目的。
     * sort(list,new Comparator<String>(){
     * public int compare(String o1,String o2){
     * <p>
     * }
     * <p>
     * });
     */
    public String PrintMinNumber(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i] + "");
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });
        String res = "";
        for (int i = 0; i < list.size(); i++)
            res = res + list.get(i);
        return res;
    }

    /**
     * 整数中1出现的次数
     * 用动态规划做的
     * 答案没看 ？
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n == 0) return 0;
        int[] rd = new int[n + 1];
        rd[0] = 0;
        rd[1] = 1;

        String help = "";
        int temp = 0;
        for (int i = 2; i <= n; i++) {
            help += i;
            for (int m = 0; m < help.length(); m++) {
                if (help.charAt(m) == '1') {
                    temp++;
                }
            }
            rd[i] = rd[i - 1] + temp;
            temp = 0;
            help = "";
        }
        return rd[n];
    }

    /**
     * 最小的k个数
     * 通过快速排序做的
     * 可以通过最大堆，优先队列是通过最大堆实现的java中
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (k > input.length || input.length == 0) return list;
        sort(input, 0, input.length - 1);

        for (int i = 0; i < k; i++)
            list.add(input[i]);
        return list;
    }

    public void sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int p = partion(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public int partion(int[] arr, int l, int r) {
        int compare = arr[l];
        int j = l;//[l+1,j][j+1,i)
        for (int i = l + 1; i < r; i++) {
            if (arr[i] < compare) {
                swap(arr, i, j + 1);
                j++;
            }
        }
        swap(arr, l, j);
        return j;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 数组中出现次数超过一半的数字
     * 用hashmap
     * 算法  ？
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        int n = array.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        for (int i = 0; i < n; i++) {
            if (map.get(array[i]) > n / 2) return array[i];
        }

        return 0;

    }

    /**
     * 栈的压入弹出序列
     * 输入两个整数序列，第一个序列表示栈的压入顺序，
     * 请判断第二个序列是否为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。
     * 例如序列1,2,3,4,5是某栈的压入顺序，
     * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
     * （注意：这两个序列的长度是相等的）
     * <p>
     * 利用一个辅助栈，很是巧妙~~~哈哈
     * 就是将压栈的过程模拟一遍，在模拟的过程中判断是否符合要求，嘿嘿。
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> help = new Stack<Integer>();
        int temp = 0;
        for (int i = 0; i < pushA.length; i++) {
            help.push(pushA[i]);
            while (!help.empty() && help.peek() == popA[temp]) {
                help.pop();
                temp++;
            }
        }
        return help.empty();
    }

    /**
     * 反转链表
     * 输入一个链表，反转链表后，输出链表的所有元素。
     * me:还是借助了arraylist。FUCK
     * ans:还是使用 two points。NND 很不错，就是一个局部的向前指向然后向后循环，就能一步一步的将整个方向逆转，很棒。
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode next = null;
        ListNode before = null;
        while (head != null) {
            next = head.next;
            head.next = before;
            before = head;
            head = next;
        }
        return before;
    }

    public ListNode ReverseList1(ListNode head) {
        if (head == null) return null;
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        for (int i = list.size() - 1; i > 0; i--) {
            list.get(i).next = list.get(i - 1);
        }
        list.get(0).next = null;
        return list.get(list.size() - 1);
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     * <p>
     * me:空间复杂度很高，建立了一个arraylist来记录之前所有的node
     * ans:制造一个长为k的尺子。     减少了空间复杂度，就是two points
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) return null;
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (list.size() - k < 0) return null;
        if (k == 0) return null;
        return list.get(list.size() - k);

    }

    public ListNode FindKthToTail2(ListNode head, int k) {
        ListNode p = head, q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k) {
                q = q.next;
            }
            p = p.next;
        }
        return i >= k ? q : null;

    }

    /**
     * 二进制中1的个数
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * 思路很棒，利用java的位运算和二进制中有多少个1就能和比他小1个的数做与运算多少次不为0；
     * 负数的问题  ？
     */
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /**
     * 变态跳台阶
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 自己做的是通过动态规划
     * 答案简化了递归公式   f(n)=2*f(n-1) 所以可以降低一层循环~~
     */
    public int JumpFloorII(int target) {
        int[] rd = new int[target + 1];
        rd[0] = 1;
        rd[1] = 1;
        for (int i = 2; i <= target; i++) {
            for (int j = i - 1; j >= 0; j--) {
                rd[i] += rd[j];
            }
        }
        return rd[target];
    }


    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     *      直接使用暴力法解决的，没有什么意义
     *      通过二分法，题中已经将其分成俩个子数列
     *      ？
     *
     */


    /**
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     * 运行时间：18ms 占用内存：8608k
     * <p>
     * 第二种pop更合理
     * 如果stack2为空，则把stack1全部转移过来，如果不为空直接pop就可以得到队列的pop。
     * 这样就减少了我本来想的一个while。不过是常数级别的优化，也没什么大用。
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()) {
            int temp = stack1.pop();
            stack2.push(temp);
        }
        int res = stack2.pop();
        while (!stack2.empty()) {
            int temp2 = stack2.pop();
            stack1.push(temp2);
        }
        return res;
    }

    public int pop2() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                int temp = stack1.pop();
                stack2.push(temp);
            }
        }
        return stack2.pop();
    }

    /**
     * 输入一个链表，从尾到头打印链表每个节点的值
     */


    /**
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * <p>
     * 运行时间：18ms 占用内存：13652k
     */
    public String replaceSpace(StringBuffer str) {
        int n = str.length();
        for (int i = 0; i < n; i++)
            if (str.charAt(i) == ' ') {
                str.deleteCharAt(i);
                str.insert(i, "%20");

            }
        System.out.println(str.charAt(2) == ' ');
        System.out.println(str);
        return null;
    }

    /**
     * 二维数组的查找
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
     * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * <p>
     * 运行时间：204ms 占用内存：16728k
     * 运行时间：180ms 占用内存：16608k
     * 暴力法
     * 从左下角或者右上角开始比较，则时间复杂度降低
     */
    public boolean Find2(int target, int[][] array) {
        if (array == null) return false;
        int length = array.length;
        int weight = array[0].length;
        int i = length - 1, j = 0;
        while (i >= 0 && j < weight) {
            if (target == array[i][j]) {
                return true;
            } else if (array[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    public boolean Find(int target, int[][] array) {
        int length = array.length;
        int weight = array[0].length;
        for (int i = 0; i < length; i++)
            for (int j = 0; j < weight; j++)
                if (target == array[i][j])
                    return true;
        return false;
    }


}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}