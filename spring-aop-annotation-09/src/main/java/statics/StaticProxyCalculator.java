package statics;

import calculator.Calculator;

public class StaticProxyCalculator implements Calculator {

    private Calculator calculator;


    //使用构造函数来传入目标(房东)
    public StaticProxyCalculator(Calculator target) {
        this.calculator = target;
    }

    @Override
    public int add(int i, int j) {

        //非核心业务， 中介使用
        System.out.println("i = " + i + ", j = " + j);

        //调用目标
        int result = calculator.add(i, j);
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}

