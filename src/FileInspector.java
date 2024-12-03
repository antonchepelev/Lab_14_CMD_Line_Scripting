import javax.swing.*;
import java.io.*;
import java.util.Scanner;
public class FileInspector {
    public static void main(String[] args) {
        int lineLength = 0;
        int lineCount = 0;
        int lineWordCount = 0;


        System.out.println("Hello world!");
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) { // Check if a file was selected
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());



            try (Scanner scanner = new Scanner(selectedFile)) {
                // Read file line by line
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String words[] = line.split("  ");
                    lineWordCount = 0; //reset the count after each line
                    for (String word: words){
                        lineWordCount++;
                    }
                    lineCount ++;
                    lineLength = line.length();
                    System.out.printf("Line count: %d Line Length: %d Line word count: %d \n",lineCount,lineLength,lineWordCount);

                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
            }
        } else {
            System.out.println("File selection canceled.");
        }


    }

}