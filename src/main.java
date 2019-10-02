public class main {

    public static void main(String[] args) {

        String fileName = "input.txt";
        String result = "";

        WriteIntoFile file = new WriteIntoFile(fileName);
        file.write();

        ReadFromFile readFromFile = new ReadFromFile(fileName);
        readFromFile.getFileText();
        int size = readFromFile.getFileText().size();
        System.out.println("Total Lines: " + size);

        for (int i = 0; i < size; i++) {
            Lines lines = readFromFile.getFileText().get(i);
            String line = lines.getLine();

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
                    result += String.valueOf((a + b)) + "\n";
                    break;
                case "-":
                    System.out.println(a - b);
                    result += String.valueOf((a - b)) + "\n";
                    break;

                case "*":
                    System.out.println(a * b);
                    result += String.valueOf((a * b)) + "\n";

                    break;

                case "/":
                    System.out.println(a / b);
                    result += String.valueOf((a / b)) + "\n";

                    break;

            }

            file.writeResult("output.txt", result);
        }
    }
}
