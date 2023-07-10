package br.com.conversor.modules;

import br.com.conversor.modules.GUI.ConversorGUI;

public class App {
    public static void main(String[] args) throws Exception {
       

        System.out.println("Conversor de moedas");

        ConversorGUI conversorGUI = new ConversorGUI();
        conversorGUI.exibirMenuPrincipal();
    

        // ConversorMoeda conversor = new ConversorMoeda();
        // ConversorMoedaInverso conversorInverso = new ConversorMoedaInverso();
        // RealToCripto conversorReal = new RealToCripto();


        // String valorEmReaisString = JOptionPane.showInputDialog("Digite o valor em reais:");
        // double valorEmReais = Double.parseDouble(valorEmReaisString);

        // // Converter para euros
        // double valorEmEuros = conversor.converterRealParaEuro(valorEmReais);
        // JOptionPane.showMessageDialog(null, "Valor em euros: " + valorEmEuros);

        // // Converter de euros para reais
        // String valorEmEurosString = JOptionPane.showInputDialog("Digite o valor em euros:");
        // double valorEmEurosInverso = Double.parseDouble(valorEmEurosString);
        // double valorEmReaisInverso = conversorInverso.converterEuroParaReal(valorEmEurosInverso);
        // JOptionPane.showMessageDialog(null, "Valor em reais: " + valorEmReaisInverso);
    }
}

