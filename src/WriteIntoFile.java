import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteIntoFile {

    private String inputFileName;

    public WriteIntoFile(String fileName) {
        this.inputFileName = fileName;
    }

    public void writeResult(String outputFileName,String lines) {
        try {
            FileWriter fileWriter = new FileWriter(outputFileName);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(lines);

            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write() {
        try {
            FileWriter fileWriter = new FileWriter(inputFileName);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("193+2");
            printWriter.println("1+58");
            printWriter.println("7+24");
            printWriter.println("95+5");
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
