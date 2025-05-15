import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Chamando o menu principal
        menuPrincipal();

        // saber que existe
        // scanner.useDelimiter("\\n");
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void menuPrincipal() {
        boolean continuar = true;
        Scanner scanner = new Scanner(System.in);

        // Lista de clientes
        ArrayList<Clientes> clientes = new ArrayList<>();

        // Loop de execuções do código
        while (continuar) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Inserir nova conta");
            System.out.println("2. Listar as contas");
            System.out.println("3. Consultar cheque especial");
            System.out.println("4. Sacar dinheiro");
            System.out.println("5. Depositar dinheiro");
            System.out.println("6. Pagar um boleto");
            System.out.println("7. Sair");

            try {
                System.out.print("Insira uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();
                
                // Tratamento de opções
                switch (opcao) {
                    // Inserir novos clientes
                    case 1 -> {
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
                    }

                    // Listagem de clientes
                    case 2 -> {
                        System.out.println("\n--- Lista de Contas ---");
                        if (clientes.isEmpty()) {
                            System.out.println("Nenhuma conta cadastrada.");
                        } else {
                            for (Clientes c : clientes) {
                                System.out.println(c.Mensagem());
                            }
                        }
                    }

                    // Sair do loop
                    case 7 -> {
                        continuar = false;
                        System.out.println("Até mais!");
                    }

                    default -> System.out.println("Insira uma opção válida!");
                }
            } catch (Exception e) {
                System.out.println("Insira uma opção válida!");
                break;
            }
        }

        scanner.close();
    }
}
