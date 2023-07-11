package br.com.conversor.modules.GUI;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.conversor.modules.Conversor.CurrencyConverterInverse;
import br.com.conversor.modules.Conversor.Currencyconverter;
import br.com.conversor.modules.ConversorCripto.CryptoToReal;
import br.com.conversor.modules.ConversorCripto.RealToCripto;

public class ConversorGUI {

    private Currencyconverter currencyconverter;
    private CurrencyConverterInverse currencyConverterInverse;
    
    private RealToCripto realToCripto;
    private CryptoToReal cryptoToReal;

    public ConversorGUI() {
        currencyconverter = new Currencyconverter();
        currencyConverterInverse = new CurrencyConverterInverse();
        realToCripto = new RealToCripto();
        cryptoToReal = new CryptoToReal();
    }
    

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
        String valorString;
        double valor = 0;
        boolean valorValido = false;

        while (!valorValido) {
            valorString = JOptionPane.showInputDialog("Digite o valor:");

            if (valorString != null && !valorString.isEmpty() && valorString.matches("\\d+")) {
                valor = Double.parseDouble(valorString);
                valorValido = true;
            } else {
                JOptionPane.showMessageDialog(null, "Valor inválido! Digite apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        double valorConvertido = 0;
        String unidade = "";

        Map<String, Function<Double, Double>> conversoes = criarMapeamentoConversoes();

        if (conversoes.containsKey(opcaoSelecionada)) {
            Function<Double, Double> conversao = conversoes.get(opcaoSelecionada);
            valorConvertido = conversao.apply(valor);

            unidade = obterUnidadeConversao(opcaoSelecionada);
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String valorFormatado = decimalFormat.format(valorConvertido);

        JOptionPane.showMessageDialog(null, "Valor convertido: " + valorFormatado + " em " + unidade);

        int opcaoContinuar = JOptionPane.showOptionDialog(null, "Deseja continuar no programa?", "Continuar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new String[] { "Sim", "Não" }, "Sim");
        if (opcaoContinuar == JOptionPane.YES_OPTION) {
            exibirMenuPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Programa finalizado", "Finalizado", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0); 
        }
    } else {
        exibirMenuPrincipal();
    }
}



    private Map<String, Function<Double, Double>> criarMapeamentoConversoes() {
        Map<String, Function<Double, Double>> conversoes = new HashMap<>();

        conversoes.put("Real para Dólar", v -> currencyconverter.converterRealToDolar(v));
        conversoes.put("Real para Euro", v -> currencyconverter.converterRealToEuro(v));
        conversoes.put("Real para Libras Esterlinas", v -> currencyconverter.converterRealToLibrasEsterlinas(v));
        conversoes.put("Real para Peso Argentino", v -> currencyconverter.converterRealToPesoArgentino(v));
        conversoes.put("Real para Peso Chileno", v -> currencyconverter.converterRealToEuro(v));
        conversoes.put("Dólar para Real", v -> currencyConverterInverse.converterDolarToReal(v));
        conversoes.put("Euro para Real", v -> currencyConverterInverse.converterEuroToReal(v));
        conversoes.put("Libras Esterlinas para Real", v -> currencyConverterInverse.converterLibrasEsterlinasToReal(v));
        conversoes.put("Peso Argentino para Real", v -> currencyConverterInverse.converterPesoArgentinoToReal(v));
        conversoes.put("Peso Chileno para Real", v -> currencyConverterInverse.converterPesoChilenoToReal(v));

        return conversoes;
    }

    public void exibirConversorCriptomoedas() {
    String[] opcoes = {
        "Real para Bitcoin",
        "Real para Etherium",
        "Real para Ripple",
        "Real para Litecoin",
        "Real para Cardano",
        "Bitcoin para Real",
        "Etherium para Real",
        "Ripple para Real",
        "Litecoin para Real",
        "Cardano para Real",
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

        if (valorString != null && !valorString.isEmpty()) {
            if (valorString.matches("\\d+")) { 
                double valor = Double.parseDouble(valorString);
                double valorConvertido = 0;
                String unidade = "";

                Map<String, Function<Double, Double>> conversoes = criarMapeamentoConversoesCripto();

                if (conversoes.containsKey(opcaoSelecionada)) {
                    Function<Double, Double> conversao = conversoes.get(opcaoSelecionada);
                    valorConvertido = conversao.apply(valor);
                    unidade = obterUnidadeConversao(opcaoSelecionada);
                }

                DecimalFormat decimalFormat = new DecimalFormat("#0.000000");
                String valorFormatado = decimalFormat.format(valorConvertido);
                JOptionPane.showMessageDialog(null, "Valor convertido: " + valorFormatado + " em " + unidade);
                JOptionPane.showMessageDialog(null, "Valor convertido: " + valorFormatado + " em " + unidade);

            int opcaoContinuar = JOptionPane.showOptionDialog(null, "Deseja continuar no programa?", "Continuar",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new String[] { "Sim", "Não" }, "Sim");
            if (opcaoContinuar == JOptionPane.YES_OPTION) {
                exibirMenuPrincipal();
            } else {
                JOptionPane.showMessageDialog(null, "Programa finalizado", "Finalizado", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            } else {
                JOptionPane.showMessageDialog(null, "Valor inválido! Digite apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    exibirMenuPrincipal();
}

    private Map<String, Function<Double, Double>> criarMapeamentoConversoesCripto() {
         Map<String, Function<Double, Double>> conversoes = new HashMap<>();

        conversoes.put("Real para Bitcoin", v -> realToCripto.converterRealToBitcoin(v));
        conversoes.put("Real para Etherium", v -> realToCripto.converterRealToEtherium(v));
        conversoes.put("Real para Ripple", v -> realToCripto.converterRealToRipple(v));
        conversoes.put("Real para Litecoin", v -> realToCripto.converterRealToLiteCoin(v));
        conversoes.put("Real para Cardano", v -> realToCripto.converterRealToAda(v));
        conversoes.put("Bitcoin para Real", v -> cryptoToReal.converterBitcoinToReal(v));
        conversoes.put("Etherium para Real", v -> cryptoToReal.converterBitcoinToReal(v));
        conversoes.put("Ripple para Real", v -> cryptoToReal.converterRippleToReal(v));
        conversoes.put("Litecoin para Real", v -> cryptoToReal.converterLiteCoinToReal(v));
        conversoes.put("Cardano para Real", v -> cryptoToReal.converterAdaToReal(v));

        return conversoes;
    }



    private String obterUnidadeConversao(String opcao) {
    switch (opcao) {
        case "Real para Bitcoin":
            return "Bitcoin";
        case "Real para Etherium":
            return "Etherium";
        case "Real para Ripple":
            return "Ripple";
        case "Real para Litecoin":
            return "Litecoin";
        case "Real para Cardano":
            return "Cardano";
        case "Bitcoin para Real":
            return "Real";
        case "Etherium para Real":
            return "Real";
        case "Ripple para Real":
            return "Real";
        case "Litecoin para Real":
            return "Real";
        case "Cardano para Real":
            return "Real";
        case "Real para Dólar":
            return "Dólar";
        case "Real para Euro":
            return "Euro";
        case "Real para Libras Esterlinas":
            return "Libras Esterlinas";
        case "Real para Peso Argentino":
            return "Peso Argentino";
        case "Real para Peso Chileno":
            return "Peso Chileno";
        case "Dólar para Real":
            return "Real";
        case "Euro para Real":
            return "Real";
        case "Libras Esterlinas para Real":
            return "Real";
        case "Peso Argentino para Real":
            return "Real";
        case "Peso Chileno para Real":
            return "Real";
        default:
            return "";
    }
}
}