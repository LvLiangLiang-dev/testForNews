package com.lll.algorithm.tree.heap;

/**
 * 最大堆的定义
 *      初始化动作
 *      插入动作
 *      上浮动作（为了维护堆的定义）
 *
 *      取出动作
 *      下降动作
 *
 * 优化：1就是不断交换（三步赋值）变成一步赋值操作，不断的往后移动（和插入排序的一种优化类似）
 *
 *
 *
 * Created by lvliangliang on 2017/12/20.
 */
public class Heap<T extends Comparable> {
    protected T[] data;
    protected int capacity;
    protected int count;

    public Heap(int capicaty) {
        data = (T[]) new Comparable[capicaty + 1];
        this.capacity = capicaty;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(T a) {
        if(count+1>capacity) System.out.println("sorry ,out of index");
        data[count+1] = a;
        count++;
        shiftup(count);
    }
    public T outElement(){
        T result=data[1];

        swap(1,count);
        count--;
        shiftdown(1);

        return result;

    }

    /**
     * 主要是在行动之前要考虑到各种情况
     *
     * break情况
     * j开始是左子树，先判断下右子树存不存在，和左子树的大小关系，变换j的值，只要最大的，要符合堆的定义。
     * @param i
     */
    public  void shiftdown(int i) {
//        while(i<=count&&(data[i].compareTo(data[2*i])<0||data[i].compareTo(data[2*i+1])<0)){
//            if(data[2*i].compareTo(data[2*i+1])<0){
//                swap(i,2*i+1);
//                i=2*i+1;
//            }
//            else{
//                swap(i,2*i);
//                i=2*i;
//            }
//        }

        while(2*i<=count){
            int j=2*i;
            if(j+1<count&&data[j].compareTo(data[j+1])<0){
                j++;
            }
            if(data[i].compareTo(data[j])>0)
                break;
            swap(i,j);
            i=j;
        }
    }


    public  void shiftup(int count) {
        while (count > 1 && data[count / 2].compareTo(data[count]) < 0) {
            swap(count / 2, count);
            count = count / 2;
        }
    }

    private void swap(int i, int j) {
        T temp;
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // 以树状打印整个堆结构
    public void treePrint(){

        if( size() >= 100 ){
            System.out.println("This print function can only work for less than 100 integer");
            return;
        }

        System.out.println("The max heap size is: " + size());
        System.out.println("Data in the max heap: ");
        for( int i = 1 ; i <= size() ; i ++ ){
            // 我们的print函数要求堆中的所有整数在[0, 100)的范围内
            assert (Integer)data[i] >= 0 && (Integer)data[i] < 100;
            System.out.print(data[i] + " ");
        }
        System.out.println();
        System.out.println();

        int n = size();
        int maxLevel = 0;
        int numberPerLevel = 1;
        while( n > 0 ){
            maxLevel += 1;
            n -= numberPerLevel;
            numberPerLevel *= 2;
        }

        int maxLevelNumber = (int)Math.pow(2, maxLevel-1);
        int curTreeMaxLevelNumber = maxLevelNumber;
        int index = 1;
        for( int level = 0 ; level < maxLevel ; level ++ ){

            String line1 = new String(new char[maxLevelNumber*3-1]).replace('\0', ' ');

            int curLevelNumber = Math.min(count-(int)Math.pow(2,level)+1,(int)Math.pow(2,level));
            boolean isLeft = true;
            for( int indexCurLevel = 0 ; indexCurLevel < curLevelNumber ; index ++ , indexCurLevel ++ ){
                line1 = putNumberInLine( (Integer)data[index] , line1 , indexCurLevel , curTreeMaxLevelNumber*3-1 , isLeft );
                isLeft = !isLeft;
            }
            System.out.println(line1);

            if( level == maxLevel - 1 )
                break;

            String line2 = new String(new char[maxLevelNumber*3-1]).replace('\0', ' ');
            for( int indexCurLevel = 0 ; indexCurLevel < curLevelNumber ; indexCurLevel ++ )
                line2 = putBranchInLine( line2 , indexCurLevel , curTreeMaxLevelNumber*3-1 );
            System.out.println(line2);

            curTreeMaxLevelNumber /= 2;
        }
    }
    private String putNumberInLine( Integer num, String line, int indexCurLevel, int curTreeWidth, boolean isLeft){

        int subTreeWidth = (curTreeWidth - 1) / 2;
        int offset = indexCurLevel * (curTreeWidth+1) + subTreeWidth;
        assert offset + 1 < line.length();
        if( num >= 10 )
            line = line.substring(0, offset+0) + num.toString()
                    + line.substring(offset+2);
        else{
            if( isLeft)
                line = line.substring(0, offset+0) + num.toString()
                        + line.substring(offset+1);
            else
                line = line.substring(0, offset+1) + num.toString()
                        + line.substring(offset+2);
        }
        return line;
    }
    private String putBranchInLine( String line, int indexCurLevel, int curTreeWidth){

        int subTreeWidth = (curTreeWidth - 1) / 2;
        int subSubTreeWidth = (subTreeWidth - 1) / 2;
        int offsetLeft = indexCurLevel * (curTreeWidth+1) + subSubTreeWidth;
        assert offsetLeft + 1 < line.length();
        int offsetRight = indexCurLevel * (curTreeWidth+1) + subTreeWidth + 1 + subSubTreeWidth;
        assert offsetRight < line.length();

        line = line.substring(0, offsetLeft+1) + "/" + line.substring(offsetLeft+2);
        line = line.substring(0, offsetRight) + "\\" + line.substring(offsetRight+1);

        return line;
    }

    public static void main(String[] args) {
        int N = 50;
        Heap<Integer> heap = new Heap<>(100);
        System.out.println(heap.size());
        for (int i = 0; i < N; i++) {
            Integer random = new Integer((int) (Math.random() * 100));
            heap.insert(random);
        }
        System.out.println(heap.size());
        heap.treePrint();
        Comparable a=heap.outElement();
        System.out.println("the outelement is: "+a);
        System.out.println(heap.size());
        heap.treePrint();


    }

}
