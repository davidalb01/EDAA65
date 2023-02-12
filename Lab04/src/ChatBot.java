import java.util.Scanner;

public class ChatBot {
	  public static void main(String[] args) {
	    java.io.File file = new java.io.File("responses.txt");
	    Responses responses = new Responses(file);
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Hi, I'm a chatbot. Ask me a question");
	    
	    while (true) {
	      System.out.print("You: ");
	      String input = scanner.nextLine();
	      if (input.equalsIgnoreCase("bye")) {
	        System.out.println("Goodbye!");
	        break;
	      }
	      String response = responses.getResponse(input);
	      if (response != null) {
	        System.out.println("Chatbot: " + response);
	      } else {
	        while (true) {
	          System.out.println("Chatbot: I don't know the answer,tell me it and i will remember it forever.");
	       
	          if (input.equalsIgnoreCase("delete")) {
	        	  System.out.print("You: ");
	            System.out.println("Chatbot: Question deleted.");
	            break;
	          }
	          System.out.print("Answer: ");
	          String answer = scanner.nextLine();
	          responses.addResponse(input, answer, file);
	          System.out.println("Chatbot: Thanks for teaching me.");
	          break;
	        }
	      }
	    }
	    scanner.close();
	  }
	}
