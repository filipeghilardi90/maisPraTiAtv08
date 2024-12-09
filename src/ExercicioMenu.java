import java.util.Scanner;

public class ExercicioMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Escolha um exercício para executar:");
            System.out.println("1. Operações aritméticas");
            System.out.println("2. Verificar se é um palíndromo");
            System.out.println("3. Sequência de Fibonacci");
            System.out.println("4. Inverter um número");
            System.out.println("5. Verificar se são anagramas");
            System.out.println("6. Jogo de adivinhação");
            System.out.println("7. Contar palavras em uma frase");
            System.out.println("0. Sair");

            int escolha = -1; // Valor inicial inválido
            try {
                escolha = scanner.nextInt();
                scanner.nextLine(); // Consumir o caractere de nova linha
            } catch (RuntimeException e) {
                scanner.nextLine(); // Consumir a entrada inválida
            }
            switch (escolha) {
                case 1:
                    operacoesAritmeticas(scanner);
                    break;
                case 2:
                    verificarPalindromo(scanner);
                    break;
                case 3:
                    sequenciaFibonacci(scanner);
                    break;
                case 4:
                    inverterNumero(scanner);
                    break;
                case 5:
                    verificarAnagramas(scanner);
                    break;
                case 6:
                    jogoAdivinhacao(scanner);
                    break;
                case 7:
                    contarPalavras(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Escolha inválida, tente novamente.");
            }
        }
    }

    public static void operacoesAritmeticas(Scanner scanner) {
        System.out.println("Digite o primeiro número:");
        double num1 = scanner.nextDouble();
        System.out.println("Digite o segundo número:");
        double num2 = scanner.nextDouble();
        System.out.println("Digite o operador (+, -, *, /):");
        char operador = scanner.next().charAt(0);

        double resultado = 0;
        switch (operador) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    System.out.println("Divisão por zero não é permitida.");
                    return;
                }
                break;
            default:
                System.out.println("Operador inválido.");
                return;
        }
        System.out.println("Resultado: " + resultado);
    }

    public static void verificarPalindromo(Scanner scanner) {
        System.out.println("Digite uma palavra:");
        String palavra = scanner.nextLine();
        String invertida = new StringBuilder(palavra).reverse().toString();

        if (palavra.equalsIgnoreCase(invertida)) {
            System.out.println("A palavra é um palíndromo.");
        } else {
            System.out.println("A palavra não é um palíndromo.");
        }
    }

    public static void sequenciaFibonacci(Scanner scanner) {
        System.out.println("Digite o número de termos:");
        int n = scanner.nextInt();

        int a = 0, b = 1;
        System.out.print("Sequência de Fibonacci: " + a + " " + b);

        for (int i = 2; i < n; i++) {
            int c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
        }
        System.out.println();
    }

    public static void inverterNumero(Scanner scanner) {
        System.out.println("Digite um número inteiro:");
        int numero = scanner.nextInt();
        int invertido = 0;

        while (numero != 0) {
            int digito = numero % 10;
            invertido = invertido * 10 + digito;
            numero /= 10;
        }
        System.out.println("Número invertido: " + invertido);
    }

    public static void verificarAnagramas(Scanner scanner) {
        System.out.println("Digite a primeira palavra:");
        String palavra1 = scanner.nextLine();
        System.out.println("Digite a segunda palavra:");
        String palavra2 = scanner.nextLine();

        char[] array1 = palavra1.replaceAll("\\s+", "").toLowerCase().toCharArray();
        char[] array2 = palavra2.replaceAll("\\s+", "").toLowerCase().toCharArray();

        java.util.Arrays.sort(array1);
        java.util.Arrays.sort(array2);

        if (java.util.Arrays.equals(array1, array2)) {
            System.out.println("As palavras são anagramas.");
        } else {
            System.out.println("As palavras não são anagramas.");
        }
    }

    public static void jogoAdivinhacao(Scanner scanner) {
        int numeroSecreto = (int) (Math.random() * 50) + 1;
        int tentativa = 0;

        System.out.println("Tente adivinhar o número entre 1 e 50:");
        while (tentativa != numeroSecreto) {
            tentativa = scanner.nextInt();
            if (tentativa < numeroSecreto) {
                System.out.println("Muito baixo, tente novamente.");
            } else if (tentativa > numeroSecreto) {
                System.out.println("Muito alto, tente novamente.");
            } else {
                System.out.println("Parabéns! Você adivinhou o número.");
            }
        }
    }

    public static void contarPalavras(Scanner scanner) {
        System.out.println("Digite uma frase:");
        String frase = scanner.nextLine();
        String[] palavras = frase.trim().split("\\s+");

        System.out.println("Número de palavras: " + palavras.length);
    }
}
