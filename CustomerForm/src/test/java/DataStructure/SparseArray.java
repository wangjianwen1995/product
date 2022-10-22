package DataStructure;


import org.junit.jupiter.api.Test;

/***
 *  稀疏数组
 */
public class SparseArray {


    @Test
    public void test1(){
        //第一个代表10 行 ,第二代表10列
        int[][] intarray = new int[10][10];
        intarray[1][2] =1;
        intarray[2][3] =2;

        for (int[] ints : intarray) {

            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }

    }
    @Test
    public void test2(){
        //第一个代表10 行 ,第二代表10列
        System.out.println(3%4);
        System.out.println(7%4);
        System.out.println(2%4);
        System.out.println(2%2);
    }
}
