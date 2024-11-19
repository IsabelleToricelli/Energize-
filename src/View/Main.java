package View;

import Model.*;
import service.*;
import exception.CustomException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Usuario_model> usuarios = new ArrayList<>();
        ArrayList<ConsumoEnergetico> consumos = new ArrayList<>();
        ArrayList<Sugestao> sugestoes = new ArrayList<>();

        boolean usuarioCadastrado = false;
        boolean consumoRegistrado = false;

        while (true) {
            System.out.println("Bem-vindo ao Energize - Sua ferramenta para Economia de Energia!");
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar novo usuário");
            System.out.println("2 - Registrar consumo mensal");
            System.out.println("3 - Ver sugestões de economia");
            System.out.println("4 - Calcular impacto financeiro e ambiental");
            System.out.println("5 - Sair");

            int opcao;
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    try {
                        System.out.println("Digite o nome do usuário:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite a localização do usuário:");
                        String localizacao = scanner.nextLine();
                        System.out.println("Digite o tipo de consumo (RESIDENCIAL, COMERCIAL, INDUSTRIAL, RURAL):");
                        TipoConsumo tipoConsumo = TipoConsumo.valueOf(scanner.nextLine().toUpperCase());

                        Usuario_model usuario = new Usuario_model(usuarios.size() + 1, nome, localizacao, tipoConsumo);
                        usuarios.add(usuario);
                        usuario.cadastrarUsuario();
                        usuarioCadastrado = true; // Usuário foi cadastrado com sucesso
                        System.out.println("Usuário cadastrado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.err.println("Tipo de consumo inválido. Por favor, verifique se sua resposta está em maiúsculo.");
                    } catch (Exception e) {
                        System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
                    }
                    break;

                case 2:
                    if (!usuarioCadastrado) {
                        System.err.println("Você precisa cadastrar um usuário antes de registrar o consumo.");
                        break;
                    }
                    try {
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
                        consumoRegistrado = true;
                        System.out.println("Consumo registrado com sucesso!");
                    } catch (InputMismatchException e) {
                        System.err.println("Entrada inválida. Por favor, digite valores numéricos.");
                        scanner.nextLine();
                    } catch (CustomException e) {
                        System.err.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.err.println("Erro ao registrar consumo: " + e.getMessage());
                    }
                    break;

                case 3:
                    if (!usuarioCadastrado || !consumoRegistrado) {
                        System.err.println("Você precisa registrar um consumo antes de acessar as sugestões.");
                        break;
                    }
                    System.out.println("Gerando sugestões de economia...");
                    for (ConsumoEnergetico c : consumos) {
                        Sugestao sugestao = new Sugestao(sugestoes.size() + 1, c, c.getConsumoKWh() * 0.5, c.getValorMensal() * 0.2, "Considere instalar painéis solares.");
                        sugestoes.add(sugestao);
                        sugestao.gerarSugestao(c);
                    }
                    System.out.println("Sugestões geradas com sucesso!");
                    break;

                case 4:
                    if (!usuarioCadastrado || !consumoRegistrado) {
                        System.err.println("Você precisa registrar um consumo antes de calcular o impacto.");
                        break;
                    }
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
