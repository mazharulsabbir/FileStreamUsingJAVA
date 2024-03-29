import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class main {
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String OUTPUT_FILE_NAME = "output.txt";

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

//        calculateFromFile();

//        stringConcatenation();

//        stringTokenizer();

//        whiteSpaceRemoval();

        commentRemoval();
    }

    private static void commentRemoval() {
        ReadFromFile readFromFile = new ReadFromFile(INPUT_FILE_NAME);
        List<String> lines = readFromFile.getFileTextString();

        StringBuilder output = new StringBuilder();
        boolean multiLine = false;
        char lastChar;
        for (String line : lines) {
            StringBuilder stringBuilder = new StringBuilder();
            lastChar = ' ';
            String s = line;
            int i;
            for (i = 0; i < s.length() - 1; i++) {
                char prev = s.charAt(i);
                char current = s.charAt(i + 1);

                String s2 = String.valueOf(prev) + current;

                if (s.contains("/*") && !s.contains("*/")) {
                    multiLine = true;
                }

                if (multiLine) {
                    if (s.contains("/*") && s.contains("*/")) {
                        multiLine = false;
                    } else if (s.contains("*/")) {
                        s = s.replaceAll("\\*/", "");
                        stringBuilder.append(s.trim());
                        multiLine = false;
                        break;
                    }
                }

                if (!multiLine) {
                    if (s2.equals("//") || s2.equals("/*")) {
                        if (s2.equals("//"))
                            i = s.length();
                        else {
                            int j;
                            for (j = i; j < s.length(); j++) {
                                char x1 = s.charAt(j - 1);
                                char x2 = s.charAt(j);

                                String x = String.valueOf(x1) + x2;

                                if (x.contains("*/")) {
                                    if (x.equals("*/")) {
                                        i = j;
                                        break;
                                    } else {
                                        j++;
                                    }
                                } else {
                                    i = s.length();
                                }

                                lastChar = s.charAt(s.length() - 1);
                            }
                        }
                    } else {
                        stringBuilder.append(prev);
                    }
                }
            }
            stringBuilder.append(lastChar);
            output.append(stringBuilder.toString()).append("\n");
        }

        System.out.println(output.toString());

        WriteIntoFile write = new WriteIntoFile(OUTPUT_FILE_NAME);
        write.write(output.toString());
    }

    private static void whiteSpaceRemoval() {
        ReadFromFile readFromFile = new ReadFromFile(INPUT_FILE_NAME);

        List<String> list = readFromFile.getFileTextString();

        StringBuilder output = new StringBuilder();
        for (String s : list) {
            output.append(s).append(" ");
        }

        String result = output.toString().replaceAll("( )+", " ");
        System.out.println(result);

        WriteIntoFile writeIntoFile = new WriteIntoFile(OUTPUT_FILE_NAME);
        writeIntoFile.write(result);
    }

    private static void stringConcatenation() {
        WriteIntoFile writeIntoFile = new WriteIntoFile(INPUT_FILE_NAME);

        System.out.print("How much lines do you want to add? ");
        int totalInputLines = scanner.nextInt();

        String lines = "";
        for (int i = 0; i <= totalInputLines; i++) {
            lines += scanner.nextLine() + "\n";

        }
        writeIntoFile.write(lines.trim());

        ReadFromFile readFromFile = new ReadFromFile(INPUT_FILE_NAME);
        List<String> output = readFromFile.getFileTextString();

        int length = output.size();

        String writeOutput = "";
        for (int i = 0; i < length; i++) {
            writeOutput += output.get(i) + " ";
        }

        System.out.println(writeOutput.trim());
        writeIntoFile.writeResult(OUTPUT_FILE_NAME, writeOutput.trim());

    }

    private static void stringTokenizer() {
        WriteIntoFile writeIntoFile = new WriteIntoFile(INPUT_FILE_NAME);

        System.out.print("Write a line: ");

        String lines = scanner.nextLine() + "\n";

        writeIntoFile.write(lines.trim());

        ReadFromFile readFromFile = new ReadFromFile(INPUT_FILE_NAME);
        List<String> output = readFromFile.getFileTextString();

        String givenInput = output.get(0).replace("\\n", " ");

        StringTokenizer stringTokenizer = new StringTokenizer(givenInput);

        StringBuilder builder = new StringBuilder();
        while (stringTokenizer.hasMoreTokens()) {
            builder.append(stringTokenizer.nextToken()).append("\n");
        }

        System.out.println(builder.toString());
        writeIntoFile.writeResult(OUTPUT_FILE_NAME, builder.toString());
    }

    private static void calculateFromFile() {
        Scanner scanner = new Scanner(System.in);

        String result = "";

        WriteIntoFile file = new WriteIntoFile(INPUT_FILE_NAME);
        int n = 0;
        System.out.println("How much line you want to add? ");
        n = scanner.nextInt();
        String writeLine = "";
        for (int i = 0; i <= n; i++) {
            writeLine += (scanner.nextLine()) + "\n";
        }
        file.write(writeLine);

        ReadFromFile readFromFile = new ReadFromFile(INPUT_FILE_NAME);
        readFromFile.getFileTextString();
        int size = readFromFile.getFileTextString().size();
        System.out.println("__________________________");

        for (int i = 0; i < size; i++) {
            String line = readFromFile.getFileTextString().get(i);
//            String line = lines.getLine();

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

                file.writeResult(OUTPUT_FILE_NAME, result);
            }

        }
    }
}
