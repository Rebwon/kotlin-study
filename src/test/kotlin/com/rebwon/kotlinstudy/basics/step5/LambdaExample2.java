package com.rebwon.kotlinstudy.basics.step5;

public final class LambdaExample2 {

    public void something() {
        int count = 0;
        Runnable runnable = () -> {
            // count++; 컴파일 에러.
            System.out.println("Hello World");
        };
    }
}
