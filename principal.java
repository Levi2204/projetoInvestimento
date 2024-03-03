import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodos met = new Metodos();
        int escolha;
        String nome, email, senha;
        double valorDeposito, valorSaque;
        System.out.println("Bem vindo");

        System.out.print("Por favor nos informe seu nome antes de começarmos:");
        nome= sc.nextLine();
        while(true){

            System.out.println("--------------------------------------");
            System.out.print("""
                    1 - Cadastrar
                    2 - Consultar seus saldo
                    3 - Depositar
                    4 - Sacar
                    5 - Investir
                    6 - Sair
                    Por favor digite o que você deseja fazer:""");
            escolha = sc.nextInt();
            sc.nextLine();
            System.out.println("--------------------------------------");
            switch (escolha){
                case 1:
                    while(true){

                        System.out.print("Digite um e-mail: ");
                        email = sc.nextLine();
                        try {
                            met.setEmail(email);

                        } catch (Metodos.InvalidEmailException e) {
                            System.out.println(e.getMessage());
                            continue;
                        }

                        System.out.print("Digite uma senha: ");
                        senha = sc.nextLine();
                        try {
                            met.setSenha(senha);
                            break;
                        } catch (Metodos.InvalidPasswordException e) {
                            System.out.println(e.getMessage());

                        }
                    }
                    System.out.println("Cadastro realizado com sucesso");
                    break;
                case 2:
                    met.info(nome);
                    break;
                case 3:
                    System.out.print("Quanto você deseja depositar: ");
                    valorDeposito = sc.nextDouble();
                    met.deposito(valorDeposito);
                    break;
                case 4:
                    System.out.print("Quanto você deseja sacar: ");
                    valorSaque = sc.nextDouble();
                    met.saque(valorSaque);
                    break;
                case 5:
                    met.investir();
                    break;
                case 6:
                    System.out.println("Obrigado");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;


            }
            if (escolha == 6){
                break;
            }
        }



    }
}
