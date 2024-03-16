import calculator.Calculator;
import calculator.CalculatorPureImpl;
import statics.StaticProxyCalculator;

public class UserAop {
    public static void main(String[] args) {

        //房东目标
        Calculator target = new CalculatorPureImpl();

        //房东代理
        Calculator proxy = new StaticProxyCalculator(target);

        //调用
        int add = proxy.add(1, 2);

        System.out.println("add = " + add);

    }
}
