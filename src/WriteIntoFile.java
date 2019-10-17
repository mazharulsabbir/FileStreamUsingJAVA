import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WriteIntoFile {

    private String inputFileName;

    public WriteIntoFile(String fileName) {
        this.inputFileName = fileName;
    }

    public void writeResult(String outputFileName,String lines) {
        try {
            FileWriter fileWriter = new FileWriter(outputFileName);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(lines);

            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeResult(String outputFileName, List<String> lines) {
        try {
            FileWriter fileWriter = new FileWriter(outputFileName);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(lines);

            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String line) {
        try {
            FileWriter fileWriter = new FileWriter(inputFileName);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(line);
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
