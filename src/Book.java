import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Book {
    private String text;

    public Book(String urlString) throws IOException {
        this.text = loadBookFromUrl(urlString);
    }

    private String loadBookFromUrl(String urlString) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(urlString).openStream()));
        String content = "";
        String line;

        while ((line = reader.readLine()) != null) {
            content += line + "\n";
        }

        reader.close(); 
        return content;
    }

    public String getText() {
        return text;
    }

    public void saveToFile(String content, String outputFileName) throws IOException {
        FileWriter writer = new FileWriter(outputFileName);
        writer.write(content);
        writer.close(); 
    }
}
