/*
 * Copyright (C) 2024 Christian Amsberg Janner
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package avaliacao.n1;

/**
 *
 * @author Christian Amsberg Janner
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Prova1 {
    public static void main(String[] args) {
        // Declaração das variáveis
        int opcao = 0;
        int qde_expresso = 0;
        int qde_capuccino = 0;
        int qde_leite_com_cafe = 0;
        int qde_cafes_vendidos;
        double valor_expresso;
        double valor_capuccino;
        double valor_leite_com_cafe;
        double valor_cafes_vendidos;
        double totalConta = 0.0;
        
        // Mapa para armazenar os produtos e seus respectivos valores
        Map<Integer, Double> produtos = new HashMap<>();
        produtos.put(1, 0.75); // Café expresso
        produtos.put(2, 1.0);  // Café capuccino
        produtos.put(3, 1.25); // Leite com café
        
        // Instanciação de um objeto da classe Scanner para receber entradas do usuário
        Scanner sc = new Scanner(System.in);
    
        // Início do loop do-while para permitir ao usuário fornecer opções até que escolha sair (opção 5)
        do {
            // Exibe o menu de opções para o usuário
            System.out.println("\nMENU DE OPÇÕES: ");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Remover produto");
            System.out.println("3 - Mostrar total da conta");
            System.out.println("4 - Pagar parte da conta");
            System.out.println("5 - Pagar total da conta");
            System.out.println("6 - Sair");
          
            // Lê a opção fornecida pelo usuário
            opcao = sc.nextInt();
          
            // Realiza ações com base na opção escolhida pelo usuário
            switch(opcao) {
                case 1:
                    System.out.println("\nADICIONAR PRODUTO: ");
                    System.out.println("Escolha o produto:");
                    System.out.println("1 - Café expresso");
                    System.out.println("2 - Café capuccino");
                    System.out.println("3 - Leite com café");
                    int produtoSelecionado = sc.nextInt();
                    if (produtos.containsKey(produtoSelecionado)) {
                        System.out.println("Informe a quantidade:");
                        int quantidade = sc.nextInt();
                        if (quantidade > 0) {
                            if (produtoSelecionado == 1)
                                qde_expresso += quantidade;
                            else if (produtoSelecionado == 2)
                                qde_capuccino += quantidade;
                            else if (produtoSelecionado == 3)
                                qde_leite_com_cafe += quantidade;
                            totalConta += produtos.get(produtoSelecionado) * quantidade;
                            System.out.println("Produto adicionado com sucesso!");
                        } else {
                            System.out.println("Quantidade inválida. Tente novamente.");
                        }
                    } else {
                        System.out.println("Produto inválido. Tente novamente.");
                    }
                    break;
                case 2:
                    // Aqui você pode implementar a remoção de produtos da lista de compras
                    System.out.println("\nREMOVER PRODUTO: ");
                    // Implementação não fornecida, pois depende de como a lista de compras está sendo armazenada
                    break;
                case 3:
                    System.out.println("\nTOTAL DA CONTA: " + totalConta);
                    break;
                case 4:
                    System.out.println("\nPAGAR PARTE DA CONTA: ");
                    System.out.println("Informe o valor a ser pago:");
                    double valorPago = sc.nextDouble();
                    if (valorPago <= totalConta) {
                        totalConta -= valorPago;
                        System.out.println("Valor pago com sucesso!");
                    } else {
                        System.out.println("Valor excede o total da conta. Tente novamente.");
                    }
                    break;
                case 5:
                    System.out.println("\nPAGAR TOTAL DA CONTA: ");
                    System.out.println("Total da conta: " + totalConta);
                    totalConta = 0.0;
                    System.out.println("Conta paga com sucesso!");
                    break;
                case 6:
                    if (totalConta > 0) {
                        System.out.println("Conta em aberto. Por favor, pague a conta antes de sair.");
                        opcao = 0; // Mantém o usuário no loop até que a conta seja paga ou cancelada
                    } else {
                        System.out.println("Encerrando o programa. Obrigado por utilizar!");
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
          
        } while (opcao != 6); // Continua o loop até que o usuário escolha sair (opção 6)
    }
}


