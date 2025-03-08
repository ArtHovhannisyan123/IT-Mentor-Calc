import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            try {
                String input = s.nextLine();

                if(input.equalsIgnoreCase("exit"))
                    break;

                String[] strings = input.split("[^\\d]+");
                String operator = input.replaceAll("[\\d]+","").trim();

                if(strings.length != 2 || operator.length() != 1) {
                    throw new Exception("Должно быть два числа и один оператор!");
                }

                int a,b;
                a = Integer.parseInt(strings[0]);
                b = Integer.parseInt(strings[1]);

                if(!numberValue(a) || !numberValue(b)) {
                    throw new Exception("Числа должны быть от 1 до 10 включительно!");
                }

                System.out.println(calc(a,b,operator));

            } catch (Exception e) {
                System.out.println("Ошибка!!! " + e.getMessage());
            }
        }
    }
    private static boolean numberValue(int num) {
        return num > 0 && num < 11;
    }

    private static int calc(int a, int b, String operator) throws Exception {
        return switch (operator){
            case "+" -> a + b;
            case "-" -> a - b;
            case "/" -> a / b;
            case "*" -> a * b;
            default -> throw new Exception("Не корректный оператор " + operator);
        };
    }
}

