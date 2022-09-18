import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int mainCounter = 0;

        System.out.println("Write number1: ");
        String number1 = scanner.nextLine();
        System.out.println("Write number2: ");
        String number2 = scanner.nextLine();

        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        for (int i = 0; i < number1.length(); i++) {
            if (number1.charAt(i) == 'X' || number1.charAt(i) == 'I' || number1.charAt(i) == 'V') {
                counter1++;
            }
            if (Character.isDigit(number1.charAt(i))){
                counter3++;
            }
        }
        for (int i = 0; i < number2.length(); i++) {
            if (number2.charAt(i) == 'X' || number2.charAt(i) == 'I' || number2.charAt(i) == 'V') {
                counter2++;
            }
            if (Character.isDigit(number2.charAt(i))){
                counter4++;
            }
        }

        if (counter1 == number1.length() && counter2 == number2.length()){
            mainCounter++;
            int num1 = romanNumber(number1);
            int num2 = romanNumber(number2);
                if (num1 > 0 && num2 > 0) {
                    System.out.println("Choose operation (+ - / *)");
                    String operation = scanner.nextLine();

                    switch (operation) {
                        case "+" -> System.out.println("Answer: " + convertIntegerToRoman(num1 + num2));
                        case "-" -> System.out.println("Answer: " + convertIntegerToRoman(num1 - num2));
                        case "*" -> System.out.println("Answer: " + convertIntegerToRoman(num1 * num2));
                        case "/" -> System.out.println("Answer: " + convertIntegerToRoman(num1 / num2));
                        default -> System.out.println("Wrong operation");
                    }
                } else {
                    throw new RuntimeException();
                }
            }


        if (counter3 == number1.length() && counter4 == number2.length()){
            mainCounter++;
            int num1 = Integer.parseInt(number1);
            int num2 = Integer.parseInt(number2);

            System.out.println("Choose operation (+ - / *)");
            String operation = scanner.nextLine();

            switch (operation) {
                case "+" -> System.out.println("Answer: " + (num1 + num2));
                case "-" -> System.out.println("Answer: " + (num1 - num2));
                case "*" -> System.out.println("Answer: " + (num1 * num2));
                case "/" -> System.out.println("Answer: " + (num1 / num2));
                default -> System.out.println("Wrong operation");
            }
        }

        try{
            if (mainCounter==0){
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            System.out.println("Write only 'I, V, X' or '1, 2, 3, 4, 5, 6, 7, 8, 9, 0'");
        }


    }

    static int romanNumber(String str) {
        int summa = 0;
        int length = str.length();
        int checkCounter = 0;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == 'X' || str.charAt(i) == 'I' ||
                    str.charAt(i) == 'V') {
                checkCounter++;
            }
        }

        if (checkCounter == length) {

            str = str + " ";

            for (int i = 0; i < length; i++) {
                char ch = str.charAt(i);
                char nextChar = str.charAt(i + 1);

                if (ch == 'X') {
                    summa += 10;
                } else if (ch == 'I') {
                    if (nextChar == 'X') {
                        summa += 9;
                        i++;
                    } else if (nextChar == 'V') {
                        summa += 4;
                        i++;
                    } else {
                        summa++;
                    }
                } else if (ch == 'V') {
                    summa += 5;
                }
            }
            return summa;
        } else {
            System.out.println("Enter only roman Integer");
            return 0;
        }
    }

    static String convertIntegerToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();
        for(int i=0;i<values.length;i++)
        {
            while(num >= values[i])
            {
                num = num - values[i];
                roman.append(romanLetters[i]);
            }
        }
        return roman.toString();
    }
}