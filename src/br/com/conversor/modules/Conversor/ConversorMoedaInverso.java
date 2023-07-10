package br.com.conversor.modules.Conversor;

public class ConversorMoedaInverso extends Conversor {
    public ConversorMoedaInverso() {
        super();
    }

    public double converterEuroParaReal(double valorEmEuro) {
        return valorEmEuro * getRealToEuro();
    }

    public double converterDolarParaReal(double valorEmDolar) {
        return valorEmDolar * getRealToDolar();
    }

    public double converterLibrasEsterlinasParaReal(double valorEmLibrasEsterlinas) {
        return valorEmLibrasEsterlinas * getRealToLibrasEsterlinas();
    }

    public double converterPesoArgentinoParaReal(double valorEmPesoArgentino) {
        return valorEmPesoArgentino * getRealToPesoArgentino();
    }

    public double converterPesoChilenoParaReal(double valorEmPesoChileno) {
        return valorEmPesoChileno * getRealToPesoChileno();
    }
}