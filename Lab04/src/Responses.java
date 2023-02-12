import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

class Responses {
  private HashMap<String, String> responses = new HashMap<>();
  
  public Responses(java.io.File file) {
    try {
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] parts = line.split("=");
        if (parts.length >= 2) {
            responses.put(parts[0].toLowerCase(), parts[1]);
          } else {
            System.out.println("Ignoring invalid line: " + line);
          }
        }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found, creating a new one.");
    }
  }

  public void addResponse(String question, String answer, java.io.File file) {
    responses.put(question.toLowerCase(), answer);
    try {
      PrintWriter writer = new PrintWriter(file);
      for (String key : responses.keySet()) {
        writer.println(key + "=" + responses.get(key));
      }
      writer.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found, could not write the responses.");
    }
  }

  public String getResponse(String input) {
    return responses.get(input.toLowerCase());
  }
  
  public void editAnswer(String question, String newAnswer) {
    responses.put(question, newAnswer);
  }
}
