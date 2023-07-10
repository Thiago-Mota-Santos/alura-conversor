package br.com.conversor.modules.GUI;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.swing.JOptionPane;

import br.com.conversor.modules.Conversor.ConversorMoedaInverso;
import br.com.conversor.modules.Conversor.Currencyconverter;
import br.com.conversor.modules.ConversorCripto.ConvertCryptocurrencies;
import br.com.conversor.modules.ConversorCripto.CryptoToReal;
import br.com.conversor.modules.ConversorCripto.RealToCripto;

public class ConversorGUI {
    public void exibirMenuPrincipal() {
        String[] opcoes = { "Conversor de Moedas", "Conversor de Criptomoedas" };
        String opcaoSelecionada = (String) JOptionPane.showInputDialog(
            null,
            "Escolha uma opção:",
            "Menu Principal",
            JOptionPane.PLAIN_MESSAGE,
            null,
            opcoes,
            opcoes[0]
        );

        if (opcaoSelecionada != null) {
            if (opcaoSelecionada.equals("Conversor de Moedas")) {
                exibirConversorMoedas();
            } else if (opcaoSelecionada.equals("Conversor de Criptomoedas")) {
                exibirConversorCriptomoedas();
            }
        }
    }

    public void exibirConversorMoedas() {
    Currencyconverter conversor = new Currencyconverter();
    ConversorMoedaInverso conversorInverso = new ConversorMoedaInverso();

    // Opções de conversão
    String[] opcoes = {
        "Real para Dólar",
        "Real para Euro",
        "Real para Libras Esterlinas",
        "Real para Peso Argentino",
        "Real para Peso Chileno",
        "Dólar para Real",
        "Euro para Real",
        "Libras Esterlinas para Real",
        "Peso Argentino para Real",
        "Peso Chileno para Real"
    };

    String opcaoSelecionada = (String) JOptionPane.showInputDialog(
        null,
        "Escolha uma opção de conversão:",
        "Conversor de Moedas",
        JOptionPane.PLAIN_MESSAGE,
        null,
        opcoes,
        opcoes[0]
    );

    if (opcaoSelecionada != null) {
        String valorString = JOptionPane.showInputDialog("Digite o valor:");

        double valor = Double.parseDouble(valorString);
        double valorConvertido = 0;

        // Mapeamento de opções de conversão para funções lambda
        Map<String, Function<Double, Double>> conversoes = new HashMap<>();
        conversoes.put("Real para Dólar", v -> conversor.converterRealToDolar(v));
        conversoes.put("Real para Euro", v -> conversor.converterRealToEuro(v));
        conversoes.put("Real para Libras Esterlinas", v -> conversor.converterRealToLibrasEsterlinas(v));
        conversoes.put("Real para Peso Argentino", v -> conversor.converterRealToPesoArgentino(v));
        conversoes.put("Real para Peso Chileno", v -> conversor.converterRealToPesoChileno(v));
        conversoes.put("Dólar para Real", v -> conversorInverso.converterDolarParaReal(v));
        conversoes.put("Euro para Real", v -> conversorInverso.converterEuroParaReal(v));
        conversoes.put("Libras Esterlinas para Real", v -> conversorInverso.converterLibrasEsterlinasParaReal(v));
        conversoes.put("Peso Argentino para Real", v -> conversorInverso.converterPesoArgentinoParaReal(v));
        conversoes.put("Peso Chileno para Real", v -> conversorInverso.converterPesoChilenoParaReal(v));

        if (conversoes.containsKey(opcaoSelecionada)) {
            Function<Double, Double> conversao = conversoes.get(opcaoSelecionada);
            valorConvertido = conversao.apply(valor);
        }

        JOptionPane.showMessageDialog(null, "Valor convertido: " + valorConvertido);
    }

    exibirMenuPrincipal();
}

     public void exibirConversorCriptomoedas() {
        // Opções de conversão
        RealToCripto converterCrypto = new RealToCripto();
     CryptoToReal converterReverseCrypto = new CryptoToReal();
        String[] opcoes = {
                "Real para Bitcoin",
                "Real para Ethereum",
                "Real para Ripple",
                "Real para Litecoin",
                "Real para Cardano",
                "Bitcoin para Real",
                "Ethereum para Real",
                "Ripple para Real",
                "Litecoin para Real",
                "Cardano para Real"
        };

        String opcaoSelecionada = (String) JOptionPane.showInputDialog(
                null,
                "Escolha uma opção de conversão:",
                "Conversor de Criptomoedas",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        if (opcaoSelecionada != null) {
            String valorString = JOptionPane.showInputDialog("Digite o valor:");
            double valor = Double.parseDouble(valorString);
            double valorConvertido = 0;

            // Mapeamento de opções de conversão para lambdas
            Map<String, Function<Double, Double>> conversoes = new HashMap<>();
            conversoes.put("Real para Bitcoin", v -> converterCrypto.converterRealToBitcoin(v));
            conversoes.put("Real para Ethereum", v -> converterCrypto.converterRealToEthereum(v));
            conversoes.put("Real para Ripple", v -> converterCrypto.converterRealToRipple(v));
            conversoes.put("Real para Litecoin", v -> converterCrypto.converterRealToLiteCoin(v));
            conversoes.put("Real para Cardano", v -> converterCrypto.converterRealToAda(v));
            conversoes.put("Bitcoin para Real", v -> converterReverseCrypto.converterBitcoinToReal(v));
            conversoes.put("Ethereum para Real", v -> converterReverseCrypto.converterEthereumToReal(v));
            conversoes.put("Ripple para Real", v -> converterReverseCrypto.converterRippleToReal(v));
            conversoes.put("Litecoin para Real", v -> converterReverseCrypto.converterLiteCoinToReal(v));
            conversoes.put("Cardano para Real", v -> converterReverseCrypto.converterAdaToReal(v));

            if (conversoes.containsKey(opcaoSelecionada)) {
                Function<Double, Double> conversao = conversoes.get(opcaoSelecionada);
                valorConvertido = conversao.apply(valor);
            }

            JOptionPane.showMessageDialog(null, "Valor convertido: " + valorConvertido);
        }

        exibirMenuPrincipal();
    }

}
