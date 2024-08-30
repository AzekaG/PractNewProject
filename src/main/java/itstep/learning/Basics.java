package itstep.learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Basics {

    public void run(){
        System.out.println("Hello World");


        byte b = 10;
        short s = 20;
        int i = 30;
        long j = 4000000000000000000L;

        float f = 5.09f;
        double d = 6.0e-5;

        char c = 'A';
        boolean bool = true;


        Byte bb = b;
        Short ss = s;
        Integer ii = new Integer(i);
        Long ll = j;
        Float ff = f;
        Double dd = d;
        Character ch = c;
        Boolean bool1 = false ;

        int[] arr1 = new int[10];
        byte[] arr2 = {1,2,3,4,5};
        char[] arr3 = new char[]{'a','b','c'};

        int[][] arr4 = new int[2][3];

        byte[][] arr5 = {
                {1,2,3},
                {4,5,6,7,8},
                {1,2}
        };

        List<Integer> list = new ArrayList<>();
        List<Object> list1 = new LinkedList<>();

        for(int k = 0; k < arr2.length; k++)
        {
            list.add((int)arr2[k]);
        }

        for(int value : list)
        {
            System.out.println(value);
        }


    }
}
