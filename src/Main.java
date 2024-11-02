import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("-----------------------Menu------------------------");
            System.out.println("1. Opção 1 - Ler uma unica cadeia");
            System.out.println("2. Opção 2 - Ler arquivo com multiplas cadeias");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção (1, 2 ou 0 para sair): ");

            while (!scanner.hasNextInt()) {
                System.out.print("Escolha inválida. Digite 1, 2 ou 0: ");
                scanner.next();
            }
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite uma cadeia: ");
                    String input1 = lerStringNaoVazia(scanner);
                    System.out.println(Misc.StringToQueue(input1));
                    System.out.println(Misc.queueToString(Misc.StringToQueue(input1)));
                    //TODO adicionar engine de unica entrada
                    break;
                case 2:
                    System.out.print("Digite o path para o arquivo contendo as cadeias para teste: ");
                    String input2 = lerStringNaoVazia(scanner);
                    Engines.MultipleInputsEntry(input2);
                    //TODO adicionar  engine de multiplas entradas
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha 1, 2 ou 0.");
            }
        } while (escolha != 0);

        scanner.close();
    }

    private static String lerStringNaoVazia(Scanner scanner) {
        String entrada;
        do {
            entrada = scanner.nextLine().trim(); // Remove espaços em branco
            if (entrada.isEmpty()) {
                System.out.print("Entrada vazia. Digite novamente: ");
            }
        } while (entrada.isEmpty());
        return entrada;
    }
}