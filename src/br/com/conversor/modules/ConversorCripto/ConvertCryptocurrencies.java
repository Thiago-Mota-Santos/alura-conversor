package br.com.conversor.modules.ConversorCripto;


public class ConvertCryptocurrencies { 
   
    private double realToBtc;
    private double realToEth;
    private double realToRipple;
    private double realToAda;
    private double realToLtc;

    public ConvertCryptocurrencies() {
        realToBtc = 149296.47;
        realToEth = 9227.34;
        realToRipple = 2.34;
        realToAda = 1.42;
        realToLtc = 471.74;
    }

    public double getRealToBtc() {
        return realToBtc;
    }

    public void setRealToBtc(double realToBtc) {
        this.realToBtc = realToBtc;
    }

    public double getRealToEth() {
        return realToEth;
    }

    public void setRealToEth(double realToEth) {
        this.realToEth = realToEth;
    }

    public double getRealToRipple() {
        return realToRipple;
    }

    public void setRealToRipple(double realToRipple) {
        this.realToRipple = realToRipple;
    }

    public double getRealToAda() {
        return realToAda;
    }

    public void setRealToAda(double realToADA) {
        this.realToAda = realToADA;
    }

    public double getRealToLtc() {
        return realToLtc;
    }

    public void setRealToLtc(double realToLtc) {
        this.realToLtc = realToLtc;
    }

}
