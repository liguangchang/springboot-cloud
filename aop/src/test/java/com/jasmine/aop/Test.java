package com.jasmine.aop;

/**
 * @author lgc guangchang
 * @create 2019-08-07 23:34
 **/
public class Test {
    public static void main(String[] args) throws Exception {
        int test = test(1, 100);
        System.err.println(test);
    }

    public static int test(int i,int j) throws Exception {
        int sum=0;
        if (j<i){
            throw new Exception("参数异常");
        }

        while (i<j){
            sum+=i;
            i++;
        }
        if (i==j){
            return sum+=j;
        }
        return sum;
    }
}
