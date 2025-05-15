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
            System.out.println("4. Depositar dinheiro");
            System.out.println("5. Sacar dinheiro");
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
                    
                    // Consultar cheque especial
                    case 3 -> {
                        System.out.print("\nInsira o número da conta do cliente que deseja vizualizar: ");
                        int numeroCliente = scanner.nextInt();
                        if (checarClienteExiste(numeroCliente, clientes)) {
                            for (Clientes c : clientes) {
                                if (c.getNumero() == numeroCliente) {    
                                    double chequeEspecial = c.GetChequeEspecial(numeroCliente);
                                    String nome = c.getNome();
                                    System.out.println("Cheque especial de " + nome + " é de R$ " + chequeEspecial);
                                }
                            }
                        }
                    }

                    // Depositar dinheiro
                    case 4 -> {
                        System.out.print("\nInsira o número da conta que gostaria de depositar: ");
                        int numeroCliente = scanner.nextInt();

                        if (checarClienteExiste(numeroCliente, clientes)) {
                            System.out.print("\nInsira o valor do depósito: ");
                            double deposito = scanner.nextDouble();

                            for (Clientes c : clientes) {
                                if (c.getNumero() == numeroCliente) {
                                    double novoDeposito = c.getSaldo() + deposito;
                                    c.setSaldo(novoDeposito);

                                    System.out.println("Valor R$ " + deposito + " depositado com sucesso!");
                                }
                            }
                        }
                    }

                    // Sacar dinheiro
                    case 5 -> {
                        System.out.print("\nInsira o número da conta que gostaria de sacar: ");
                        int numeroCliente = scanner.nextInt();

                        if (checarClienteExiste(numeroCliente, clientes)) {
                            System.out.print("\nInsira o valor do saque: ");
                            double saque = scanner.nextDouble();

                            if (saque > 0) {
                                for (Clientes c : clientes) {
                                    if (c.getNumero() == numeroCliente) {
                                        if (c.getSaldo() > 0 && c.getSaldo() >= saque) {
                                            double novoSaque = c.getSaldo() - saque;
                                            c.setSaldo(novoSaque);

                                            System.out.println("Valor R$ " + saque + " sacado com sucesso!");
                                        } else {
                                            System.out.println("Não há dinheiro suficiente para sacar!");
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Insira um saque de valor positivo!");
                            }
                        }
                    }

                    case 6 -> {
                        System.out.print("\nInsira o número da conta que gostaria de efetuar o pagamento do boleto: ");
                        int numeroCliente = scanner.nextInt();

                        if (checarClienteExiste(numeroCliente, clientes)) {
                            System.out.print("\nInsira o valor do boleto: ");
                            double boleto = scanner.nextDouble();

                            if (boleto > 0) {
                                for (Clientes c : clientes) {
                                    if (c.getNumero() == numeroCliente) {
                                        if (c.getSaldo() > 0 && c.getSaldo() >= boleto) {
                                            double novoBoleto = c.getSaldo() - boleto;
                                            c.setSaldo(novoBoleto);

                                            System.out.println("Valor de R$ " + boleto + " do boleto pago com sucesso!");
                                        } else {
                                            System.out.println("Não há dinheiro suficiente para pagar!");
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Insira um boleto de valor positivo!");
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

    public static boolean checarClienteExiste(int numeroCliente, ArrayList<Clientes> clientes) {
        boolean checkCliente = false;

        if (clientes.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            for (Clientes c : clientes) {
                if (c.getNumero() == numeroCliente) {
                    checkCliente = true;
                } else {
                    System.out.println("Nenhuma conta com esse número cadastrado!");
                }
            }
        }

        return checkCliente;
    }
}
