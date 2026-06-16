import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // TODO: Uncomment the code below to pass the first stage
        while (true) {
            System.out.print("$ ");
            Scanner sc = new Scanner(System.in);
            String Command = sc.nextLine();
            if (Command.equals("exit")) {
                break;
            }
            if(Command.startsWith("echo ")){
                System.out.println(Command.substring(5));
            }
            System.out.println(Command + ": command not found");
        }
        
    }
}
