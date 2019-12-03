import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
    private static final String TAG = "ReadFromFile";
    private String fileName;
    private String fileText = "";

    private List<String> linesOfString;

    public ReadFromFile(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getFileTextString() {
        linesOfString = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((fileText = bufferedReader.readLine()) != null) {
                linesOfString.add(fileText);
            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return linesOfString;
    }
}
