import java.util.Scanner;

public class CaixaEletronico {
	
	//Variavel global
	static double saldo = 100;
    static String nome;
    static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Informe seu nome:");
        nome = scan.nextLine();
        
        while(nome == "") {
        	System.out.println("Por favor, informe um nome válido:");
        	nome = scan.nextLine();
        }
        
        System.out.println("Olá " + nome + " é um prazer ter você por aqui!");

        servicos();
	}
	
	//Metodo para selecionar os servicos
    public  static void servicos() {
        System.out.println("\nSelecione uma opção:\n 1. Saldo\n 2. Extrato\n 3. Saque\n 4. Depósito\n 5. Transferência\n 6. Sair");
        int opcao = scan.nextInt();

        switch (opcao) {
            case 1:
                ver_saldo();
                break;
            case 2:
                ver_extrato();
                break;
            case 3:
                fazer_saque();
                break;
            case 4:
                fazer_deposito();
                break;
            case 5:
                fazer_transferencia();
                break;
            case 6:
                sair();
                break;
            default:
                erro();
                break;
        }
    }
    
    public static void ver_saldo(){
        valid_senha();
        System.out.println("\nSeu saldo atual é: R$" + saldo);
        servicos();
    }

    public static void fazer_deposito(){
        valid_senha();

        Double deposito;
        System.out.println("\nInforme o valor para o depósito:");
        deposito = scan.nextDouble();

        //Valida se é um numero
        boolean validDeposito = deposito.isNaN();

        if(validDeposito || deposito <=0){
            System.out.println("\nOperação não autorizada");
            fazer_deposito();
        }
        else {
            saldo = saldo + deposito;
            ver_saldo();
            servicos();
        }
        
    }

    public static void fazer_saque(){

        valid_senha();
        
        System.out.println("\nInforme o valor do saque:");
        Double saque = scan.nextDouble();
        boolean validSaque = saque.isNaN();

        if(validSaque) {
        	System.out.println("\nOperação não autorizada");
            fazer_saque();
        }
        else if(saque > saldo || saque <= 0 ){
            System.out.println("\nOperação não autorizada");
            fazer_saque();
        }
        else{
            saldo = saldo - saque;
            ver_saldo();
        }
        servicos();
    }

    public static void fazer_transferencia(){
        valid_senha();
        Double trasf;
        Double numConta;

        System.out.println("\nInforme o número da conta:");
        numConta = scan.nextDouble();
        boolean validConta = numConta.isNaN();
        
        if(validConta) {
        	System.out.println("\nPor informe um número válido.");
            fazer_transferencia();
        }
        
        System.out.println("\nInforme o valor para a transferência:");
        trasf = scan.nextDouble();

        if(trasf > saldo || trasf <=0) {
            System.out.println("\nOperação não autorizada");
            fazer_transferencia();
        }
        else {
            saldo = saldo - trasf;
            ver_saldo();
        }
        servicos();
    }

    public static void ver_extrato(){
        valid_senha();

        String extrato = "\n-----EXTRATO-----\n\n Lojas Americanas\n Produto: Bala Finni\n Valor Total: R$10,00\n Data: 01/09/2022\n -------------------\n Mercado\n Produtos: Arroz, Leite, Bolacha, Maça\n Valor Total: R$47,89\n Data: 05/09/2022\n -------------------\n Saque\n Valor do saque: R$ 80,00\n Data: 07/09/2002\n -------------------\n Depósito\n Banco Inter\n Para: Fabiola Costa\n Valor: R$100,00";
        System.out.println(extrato);

        servicos();
    }

    public static void sair(){
        System.out.println("\nVocê deseja sair? S/N");
        String resp = scan.nextLine();
        
        if(resp.equals("S")|| resp.equals("s")) {
        	System.out.println("\n"+ nome + ", foi um prazer ter você por aqui!");
        	System.exit(0);
        }
        else if(resp.equals("N") || resp.equals("n")) {
        	servicos();
        }
        else {
        	System.out.println("\nPor favor, informe S/N");    
        	sair();
        }
        
    }

    public static void valid_senha(){
        int senha = 3589;
        System.out.println("\nInforme a sua senha:");
        int validSenha = scan.nextInt();

        while(validSenha != senha){
            System.out.println("\nSenha incorreta");
            validSenha = scan.nextInt();
        }
    }

    public static void erro(){
        System.out.println("\nPor favor,informe um número entre 1 e 6");
        servicos();
    }

}