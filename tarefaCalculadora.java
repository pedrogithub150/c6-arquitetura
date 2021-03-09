import java.util.Scanner;

public class tarefaCalculadora {

  public static void main(String[] args) {

    int opcao = -1;

    do {

    System.out.print("MENU DA CALCULADORA\nEscolha uma das seguintes opcoes: \n");
       
    Scanner scanner = new Scanner(System.in);

    System.out.println("Opcao 1: SOMA");
    System.out.println("Opcao 2: SUBTRACCAO");
    System.out.println("Opcao 3: MULTIPLICACAO");
    System.out.println("Opcao 4: DIVISAO");
    System.out.println("Opcao 0: Para sair da calculadora");
    opcao = scanner.nextInt();
    
    if (opcao==0){
      break;  
    }

    System.out.print("Insira o primeiro numero: ");
    int a = scanner.nextInt();
  
    System.out.print("Insira o segundo numero: ");
    int b = scanner.nextInt();
    

       
    if (opcao == 1) {
      System.out.println("O resultado da soma é = " + (a+b));
    } else if (opcao == 2) {
      System.out.println("O resultado da subtraccao é = " + (a-b));
    } else if (opcao == 3) {
      System.out.println("O resultado da multiplicacao é = " + (a*b));
    } else if (opcao == 4) {
      System.out.println("O resultado da divisao é = " + (a/b));
    }


    } while (opcao != 0);
  
     
            
    }
  }