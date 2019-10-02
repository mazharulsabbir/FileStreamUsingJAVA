import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteIntoFile {

    private String fileName;

    public WriteIntoFile(String fileName) {
        this.fileName = fileName;
    }

    public void write() {
        try {
            FileWriter fileWriter = new FileWriter(fileName);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("1984+2");
            printWriter.println("1+578");
            printWriter.println("7+24");
            printWriter.println("94+5");

            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
