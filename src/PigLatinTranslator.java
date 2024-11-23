public class PigLatinTranslator {
    
    public static String translateWord(String word) {
        if (word.length() == 0) {
            return word; 
        }

        int firstVowelIndex = -1;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                firstVowelIndex = i;
                break;
            }
        }
        
        if (firstVowelIndex == -1) {
            return word + "ay";
        }

        String consonants = word.substring(0, firstVowelIndex);
        String vowels = word.substring(firstVowelIndex);

        return vowels + consonants + "ay";
    }

    public static String translateLine(String line) {
        String[] words = line.split(" ");  
        String translatedLine = "";

        for (String word : words) {
            translatedLine += translateWord(word) + " ";
        }

        return translatedLine.trim();
    }
}
