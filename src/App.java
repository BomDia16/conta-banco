import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Chamando o menu principal
        menuPrincipal();
    }

    public static void menuPrincipal() {
        boolean continuar = true;
        Scanner scanner = new Scanner(System.in);

        // Lista de clientes
        ArrayList<Clientes> clientes = new ArrayList<>();

        // Loop de execuções do código
        while (continuar) {
            System.out.println("\n1. Inserir nova conta");
            System.out.println("2. Listar as contas");

            try {
                System.out.print("Insira uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();
                
                // Tratamento de opções
                switch (opcao) {

                    // Inserir novo cliente
                    case 1:
                        System.out.print("Insira o número do cliente: ");
                        int numero = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Insira a agência do cliente: ");
                        String agencia = scanner.nextLine();

                        System.out.print("Insira o nome do cliente: ");
                        String nome = scanner.nextLine();

                        // Conferir se a string possui apenas letras
                        if (!nome.matches("[a-zA-Z\s]+")) {
                            System.out.println("Insira um nome apenas com letras!");
                            break;
                        }

                        System.out.print("Insira o saldo do cliente: ");
                        double saldo = scanner.nextDouble();
                        scanner.nextLine();

                        Clientes novoCliente = new Clientes(numero, agencia, nome, saldo);
                        clientes.add(novoCliente);
                        System.out.println("Cliente adicionado com sucesso!");
                        break;

                    case 2:

                        // Listagem de clientes
                        System.out.println("\n--- Lista de Contas ---");
                        if (clientes.isEmpty()) {
                            System.out.println("Nenhuma conta cadastrada.");
                        } else {
                            for (Clientes c : clientes) {
                                System.out.println(c.Mensagem());
                            }
                        }
                        break;

                    default:
                        System.out.println("Insira uma opção válida!");
                        break;
                }

                // Checagem para sair do loop
                System.out.print("\nGostaria de realizar mais alguma coisa? (y/n): ");
                String resposta = scanner.nextLine();
                if (resposta.equalsIgnoreCase("n")) {
                    continuar = false;
                    System.out.println("Até mais!");
                }
            } catch (Exception e) {
                System.out.println("Insira uma opção válida!");
                break;
            }
        }

        scanner.close();
    }
}
