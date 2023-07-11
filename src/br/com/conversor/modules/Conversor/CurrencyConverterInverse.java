package br.com.conversor.modules.Conversor;

public class CurrencyConverterInverse extends Conversor {
    public CurrencyConverterInverse() {
        super();
    }

    public double converterEuroToReal(double valorEmEuro) {
        return valorEmEuro * getRealToEuro();
    }

    public double converterDolarToReal(double valorEmDolar) {
        return valorEmDolar * getRealToDolar();
    }

    public double converterLibrasEsterlinasToReal(double valorEmLibrasEsterlinas) {
        return valorEmLibrasEsterlinas * getRealToLibrasEsterlinas();
    }

    public double converterPesoArgentinoToReal(double valorEmPesoArgentino) {
        return valorEmPesoArgentino * getRealToPesoArgentino();
    }

    public double converterPesoChilenoToReal(double valorEmPesoChileno) {
        return valorEmPesoChileno * getRealToPesoChileno();
    }
}