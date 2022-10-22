import org.junit.jupiter.api.Test;

public class bitOperationTest {

    @Test
    void test1(){



        int a = 10, b = 5;

        System.out.println("交互b:" +(a ^ b ^ b));


        System.out.println("交互a:"+(a ^ b ^ a  ));


        System.out.println(-12>>3);
        System.out.println(12>>3);
        System.out.println(-12>>>3);


        //  0 0 0 1  -->   a
        //  1 0 0 1  -->   b


        //  1 0 0 0  -->   求和后
        //  1 0 0 1  -->   b
        //  0 0 0 1   ===a   a=a^b^b


        //  1 1 0 0  12

        //  0110
        //  1001
        //  1010

    }
}
