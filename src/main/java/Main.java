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
            } else if (Command.startsWith("echo ")) {
                System.out.println(Command.substring(5));
            } else if (Command.startsWith("type")) {
                String cmd = Command.substring(5);
                if (cmd.equals("type") ||
                        cmd.equals("echo") ||
                        cmd.equals("exit")) {
                    System.out.println(cmd + " is a shell builtin");

                } else {
                    System.out.println(cmd + ": not found");
                }

            } else {
                System.out.println(Command + ": command not found");
            }
        }

    }
}
