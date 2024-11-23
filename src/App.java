public class App {
    public static void main(String[] args) {
        String url = "https://www.gutenberg.org/cache/epub/37431/pg37431.txt";
        String outputFileName = "PrideAndPrejudice_PigLatin.txt";
 
 
        try {
            Book book = new Book(url); 
            String bookContent = book.getText();
 
 
            String[] lines = bookContent.split("\n");
            StringBuilder translatedContent = new StringBuilder();
 
 
            for (String line : lines) {
                translatedContent.append(PigLatinTranslator.translateLine(line)).append("\n");
            }
 
 
            book.saveToFile(translatedContent.toString(), outputFileName);
            System.out.println("Translation complete! Saved to: " + outputFileName);
        } catch (java.io.IOException e) {
            System.err.println("An error occurred during file operations: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
 }
 
 
 