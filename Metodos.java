import java.util.Scanner;
import java.util.regex.Pattern;

public class Metodos {
    Scanner sc = new Scanner(System.in);
    private String nome;
    private double saldo;
    double saque;

    double valorInvestir;

    private String email;
    private String senha;

    double valor;
    public Metodos(){

    }
    public class InvalidEmailException extends Exception {

        public InvalidEmailException(String message) {
            super(message);
        }
    }

    public class InvalidPasswordException extends Exception{
        public InvalidPasswordException (String message){
            super(message);
        }
    }


    public void setEmail(String email) throws InvalidEmailException {

        if (!Pattern.matches("[\\w-\\.]+@[\\w-\\.]+\\.[a-zA-Z]{2,}", email)) {
            throw new InvalidEmailException("Digite um email válido.");
        }
        this.email = email;
    }

    public void setSenha(String senha) throws InvalidPasswordException {

        if (!Pattern.matches("(?=.*[0-9])(?=.*[A-Z]).{8,}", senha)) {
            throw new InvalidPasswordException("Senha inválida. Digite uma senha com pelo menos 8 caracteres, contendo letras maiúsculas e números.");
        }
        this.senha = senha;
    }



    public void deposito (double din){
        this.saldo = 0;
        this.valor = din;

        while(true){
            if(valor <=0){
                System.out.println("Valor inválido. O valor deve ser maior que 0R$");
                break;
            }else{
                System.out.println("--------------------------------------");
                System.out.printf("O valor de %.2fR$ foi depositado%n",valor);
                saldo += valor;
                System.out.printf("Seu novo saldo é %.2fR$%n", saldo);
                System.out.println("--------------------------------------");
                break;
            }

        }
    }
    public void saque(double dinSaque){
        this.saque = dinSaque;

        if (saque <=0){
            System.out.println("--------------------------------------");
            System.out.println("Valor inválido. O saque deve ser maior que 0");
            System.out.println("--------------------------------------");

        } else if (saque > saldo) {
            System.out.println("--------------------------------------");
            System.out.println("Valor inválido. O saque não pode ser maior que seu saldo");
            System.out.println("--------------------------------------");

        }else{
            System.out.println("--------------------------------------");
            saldo -= saque;
            System.out.printf("Valor de %.2fR$ foi sacado. Seu novo saldo é de %.2fR$%n", saque, saldo);
            System.out.println("--------------------------------------");

        }

    }
    public void info(String nomes){
        this.nome = nomes;
        System.out.println("--------------------------------------");
        System.out.printf("Olá %s %n", nome);
        System.out.printf("Seu saldo é de %.2fR$ %n", saldo);
        System.out.println("--------------------------------------");
    }

    public void investir(){
        double valorNovo = 0, valorAntigo;

        while(true){
            if(saldo == 0){
                System.out.println("Você não tem saldo suficiente para investir");
            }else{
                System.out.print("Digite quanto você ira investir conosco: ");
                this.valorInvestir = sc.nextDouble();
                valorAntigo = valorInvestir;

                if(valorInvestir <= 0){
                    System.out.println("Digite um valor válido");
                }else if(valorInvestir > saldo){
                    System.out.println("Saldo insuficiente");
                }else{
                    saldo -= valorInvestir;
                    System.out.println("Seu dinheiro irá ficar rendendo conosco durante 1 mês");

                    for(int i = 1; i <=30; i++){

                        valorNovo = valorAntigo + (valorAntigo * 0.06);
                        valorAntigo = valorNovo;


                        System.out.printf("%d° dia - Saldo %.2f%n",i, valorAntigo);

                    }
                    valorInvestir = valorNovo;
                    saldo += valorInvestir;
                    break;
                }
            }

        }

    }
}
