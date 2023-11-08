import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Count {

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try {
            
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;
            Map<String, Integer> wordCount = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                
                String word = line.toLowerCase();
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
            reader.close();

            
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
            writer.close();

            System.out.println("Word count results have been written to " + outputFile);

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}

     

