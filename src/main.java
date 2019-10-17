import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class main {
    private static String inputFileName = "input.txt";
    private static String outputFileName = "output.txt";

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
//        calculate();

//        Task1();

//        Task2();
    }

    private static void whiteSpaceRemoval(){
        ReadFromFile readFromFile = new ReadFromFile(outputFileName);
        readFromFile.getFileText();
    }

    private static void Task1() {
        WriteIntoFile writeIntoFile = new WriteIntoFile(inputFileName);

        System.out.print("How much lines do you want to add? ");
        int totalInputLines = scanner.nextInt();

        String lines = "";
        for (int i = 0; i <= totalInputLines; i++) {
            lines += scanner.nextLine() + "\n";

        }
        writeIntoFile.write(lines.trim());

        ReadFromFile readFromFile = new ReadFromFile(inputFileName);
        List<Lines> output = readFromFile.getFileText();

        int length = output.size();

        String writeOutput = "";
        for (int i = 0; i < length; i++) {
            Lines lines1 = output.get(i);
            writeOutput += lines1.getLine() + " ";
        }

        System.out.println(writeOutput.trim());
        writeIntoFile.writeResult(outputFileName, writeOutput.trim());

    }

    private static void Task2() {
        WriteIntoFile writeIntoFile = new WriteIntoFile(inputFileName);

        System.out.print("Write a line: ");

        String lines = scanner.nextLine() + "\n";

        writeIntoFile.write(lines.trim());

        ReadFromFile readFromFile = new ReadFromFile(inputFileName);
        List<Lines> output = readFromFile.getFileText();

        Lines text = output.get(0);
        int lengthOfLine = text.getLine().length();
        String givenInput = text.getLine().replace("\\n", " ");

        StringTokenizer stringTokenizer = new StringTokenizer(givenInput);

        List<String> strings = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
            strings.add(stringTokenizer.nextToken());
        }
        writeIntoFile.writeResult(outputFileName, strings);
    }

    private static void calculate() {
        Scanner scanner = new Scanner(System.in);

        String result = "";

        WriteIntoFile file = new WriteIntoFile(inputFileName);
        int n = 0;
        System.out.println("How much line you want to add? ");
        n = scanner.nextInt();
        String writeLine = "";
        for (int i = 0; i <= n; i++) {
            writeLine += (scanner.nextLine()) + "\n";
        }
        file.write(writeLine);

        ReadFromFile readFromFile = new ReadFromFile(inputFileName);
        readFromFile.getFileText();
        int size = readFromFile.getFileText().size();
        System.out.println("__________________________");

        for (int i = 0; i < size; i++) {
            Lines lines = readFromFile.getFileText().get(i);
            String line = lines.getLine();

            if (!line.equals("")) {

                int arithmeticSignIndex = 0;

                String firstInput = "", tempSecondInput = "";
                for (int j = 0; j < line.length(); j++) {
                    if (line.charAt(j) == '+' |
                            line.charAt(j) == '-' |
                            line.charAt(j) == '*' |
                            line.charAt(j) == '/'
                    ) {
                        arithmeticSignIndex = j;
                        break;
                    } else {
                        firstInput += String.valueOf(line.charAt(j));
                    }
                }

                for (int j = line.length() - 1; j >= 0; j--) {
                    if (line.charAt(j) == '+' |
                            line.charAt(j) == '-' |
                            line.charAt(j) == '*' |
                            line.charAt(j) == '/'
                    ) {
                        break;
                    } else {
                        tempSecondInput += String.valueOf(line.charAt(j));
                    }
                }

                String secondInput = "";

                for (int j = tempSecondInput.length() - 1; j >= 0; j--) {
                    secondInput += String.valueOf(tempSecondInput.charAt(j));
                }

                int a = Integer.parseInt(firstInput);
                int b = Integer.parseInt(secondInput);

                switch (String.valueOf(line.charAt(arithmeticSignIndex))) {
                    case "+":
                        System.out.println(a + b);
                        result += (a + b) + "\n";
                        break;
                    case "-":
                        System.out.println(a - b);
                        result += (a - b) + "\n";
                        break;

                    case "*":
                        System.out.println(a * b);
                        result += a * b + "\n";

                        break;

                    case "/":
                        System.out.println(a / b);
                        result += a / b + "\n";

                        break;

                }

                file.writeResult(outputFileName, result);
            }

        }
    }
}
