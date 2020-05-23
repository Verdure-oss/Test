package com.jxj.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Sf {

    int[] ints = {1, 9, 4, 3, 6, 5, 11, 2, 20};

    //冒泡
    //@Test
    void Test1() {
        int x = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length - i - 1; j++) {
                x++;
                if (ints[j] > ints[j + 1]) {
                    int tmp = ints[j + 1];
                    ints[j + 1] = ints[j];
                    ints[j] = tmp;
                }
                String str = "";
                for (int k = 0; k < ints.length; k++) {
                    str = str + ints[k] + ",";
                }
                System.out.println(str);
            }
        }
        System.out.println(x);
    }

    //选择排序
    //@Test
    void Test2() {
        for (int i = 0; i < ints.length; i++) {
            int min = ints[i];
            int minindex = i;
            for (int j = i + 1; j < ints.length; j++) {
                if (min > ints[j]) {
                    min = ints[j];
                    minindex = j;
                }
            }
            ints[minindex] = ints[i];
            ints[i] = min;

        }
        String str = "";
        for (int i = 0; i < ints.length; i++) {
            str = str + ints[i] + ",";
        }
        System.out.println(str);
    }

    //插入排序
    @Test
    void Test3() {
        for (int i = 1; i < ints.length; i++) {
            for (int j = i; j > 0; j--) {
                if (ints[j - 1] > ints[j]) {
                    int tmp = ints[j];
                    ints[j] = ints[j - 1];
                    ints[j - 1] = tmp;
                }
            }
        }
        String str = "";
        for (int i = 0; i < ints.length; i++) {
            str = str + ints[i] + ",";
        }
        System.out.println(str);
    }
}
