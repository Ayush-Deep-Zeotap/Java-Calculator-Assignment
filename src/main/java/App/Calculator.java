package App;

import App.CalcInterface;

public class Calculator {

    CalcInterface calcInterface;

    public Calculator(CalcInterface newCalcInterface){
        this.calcInterface = newCalcInterface;
    }

    public Integer add(int x,int y){
        return x + y;
    }

    public Integer sub(int x,int y){
        return x - y;
    }

    public Integer mul(int x,int y){
        return x * y;
    }

    public Integer div(int x,int y){
        if(y == 0) throw new ArithmeticException("Divide By Zero");
        return x/y;
    }

    public Integer toZero(int x,int y){
        return calcInterface.fun(sub(x,y));
    }

}
