package View;

import Model.*;
import service.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Usuario_model> usuarios = new ArrayList<>();
        ArrayList<ConsumoEnergetico> consumos = new ArrayList<>();
        ArrayList<Sugestao> sugestoes = new ArrayList<>();

        while (true) {
            System.out.println("Bem-vindo ao Energize - Sua ferramenta para Economia de Energia!");
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar novo usuário");
            System.out.println("2 - Registrar consumo mensal");
            System.out.println("3 - Ver sugestões de economia");
            System.out.println("4 - Calcular impacto financeiro e ambiental");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do usuário:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a localização do usuário:");
                    String localizacao = scanner.nextLine();
                    System.out.println("Digite o tipo de consumo (RESIDENCIAL, COMERCIAL, INDUSTRIAL, RURAL):");
                    TipoConsumo tipoConsumo = TipoConsumo.valueOf(scanner.nextLine().toUpperCase());

                    Usuario_model usuario = new Usuario_model(usuarios.size() + 1, nome, localizacao, tipoConsumo);
                    usuarios.add(usuario);
                    usuario.cadastrarUsuario();
                    break;

                case 2:
                    System.out.println("Digite o ID do usuário:");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o consumo mensal em kWh:");
                    double consumoKWh = scanner.nextDouble();
                    System.out.println("Digite o custo médio mensal (R$):");
                    double valorMensal = scanner.nextDouble();

                    ConsumoEnergetico consumo = new ConsumoEnergetico(consumos.size() + 1, idUsuario, valorMensal, consumoKWh, new java.util.Date());
                    consumos.add(consumo);
                    consumo.registrarConsumo();
                    break;

                case 3:
                    System.out.println("Gerando sugestões de economia...");
                    for (ConsumoEnergetico c : consumos) {
                        Sugestao sugestao = new Sugestao(sugestoes.size() + 1, c, c.getConsumoKWh() * 0.5, c.getValorMensal() * 0.2, "Considere instalar painéis solares.");
                        sugestoes.add(sugestao);
                        sugestao.gerarSugestao(c);
                    }
                    break;

                case 4:
                    System.out.println("Resumo da Economia:");
                    for (Sugestao s : sugestoes) {
                        System.out.println("Sugestão: " + s.getDescricao());
                        System.out.println("Economia anual: R$" + (s.getEconomiaMensal() * 12));
                        System.out.println("Redução de CO₂: " + (s.getCarbonoEvitado() * 12) + " kg por ano");
                    }
                    break;

                case 5:
                    System.out.println("Saindo do sistema. Até logo!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
