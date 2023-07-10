package br.com.conversor.modules.Conversor;

public class Conversor {
    private double realToDolar;
    private double realToEuro;
    private double realToLibrasEsterlinas;
    private double realToPesoArgentino;
    private double realToPesoChileno;

    public Conversor() {
        realToDolar = 4.86;
        realToEuro = 5.37;
        realToLibrasEsterlinas = 6.27;
        realToPesoArgentino = 0.019;
        realToPesoChileno = 0.006;
    }

    public double getRealToDolar() {
        return realToDolar;
    }

    public void setRealToDolar(double realToDolar) {
        this.realToDolar = realToDolar;
    }

    public double getRealToEuro() {
        return realToEuro;
    }

    public void setRealToEuro(double realToEuro) {
        this.realToEuro = realToEuro;
    }

    public double getRealToLibrasEsterlinas() {
        return realToLibrasEsterlinas;
    }

    public void setRealToLibrasEsterlinas(double realToLibrasEsterlinas) {
        this.realToLibrasEsterlinas = realToLibrasEsterlinas;
    }

    public double getRealToPesoArgentino() {
        return realToPesoArgentino;
    }

    public void setRealToPesoArgentino(double realToPesoArgentino) {
        this.realToPesoArgentino = realToPesoArgentino;
    }

    public double getRealToPesoChileno() {
        return realToPesoChileno;
    }

    public void setRealToPesoChileno(double realToPesoChileno) {
        this.realToPesoChileno = realToPesoChileno;
    }
}

