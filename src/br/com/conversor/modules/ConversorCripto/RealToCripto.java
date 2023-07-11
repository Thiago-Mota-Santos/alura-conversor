package br.com.conversor.modules.ConversorCripto;


public class RealToCripto extends ConvertCryptocurrencies {
    public RealToCripto(){
        super();
    }

   public double converterRealToBitcoin(double valor) {
    return valor / getRealToBtc();
}

    public double converterRealToEtherium(double valor) {
        return valor / getRealToEth();
    }

    public double converterRealToLiteCoin(double valor){
        return valor / getRealToLtc();
    }

    public double converterRealToRipple(double valor){
        return valor / getRealToRipple();
    }

    public double converterRealToAda(double valor){
        return valor / getRealToAda();
    }


}
