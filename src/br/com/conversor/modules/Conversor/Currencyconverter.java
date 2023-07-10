package br.com.conversor.modules.Conversor;

public class Currencyconverter extends Conversor{
    public Currencyconverter() {
        super();
    }

    public double converterRealToDolar(double valorEmReais) {
        return valorEmReais / getRealToDolar();
    }

    public double converterRealToEuro(double valorEmReais) {
        return valorEmReais / getRealToEuro();
    }

    public double converterRealToLibrasEsterlinas(double valorEmReais) {
        return valorEmReais / getRealToLibrasEsterlinas();
    }

    public double converterRealToPesoArgentino(double valorEmReais) {
        return valorEmReais / getRealToPesoArgentino();
    }

    public double converterRealToPesoChileno(double valorEmReais) {
        return valorEmReais / getRealToPesoChileno();
    }
}


