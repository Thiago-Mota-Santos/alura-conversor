package br.com.conversor.modules.ConversorCripto;


public class CryptoToReal extends ConvertCryptocurrencies {
    public CryptoToReal(){
        super();
    }

    public double converterBitcoinToReal(double valor) {
        return valor * getRealToBtc();
    }

    public double converterEthereumToReal(double valor) {
        return valor * getRealToEth();
    }

     public double converterRippleToReal(double valor) {
        return valor * getRealToRipple();
    }
     public double converterAdaToReal(double valor) {
        return valor * getRealToAda();
    }
     public double converterLiteCoinToReal(double valor) {
        return valor * getRealToLtc();
    }

}

