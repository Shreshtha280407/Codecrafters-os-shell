import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            if (!sc.hasNextLine()) {
                break;
            }
            String input = sc.nextLine();

            if (input.equals("exit 0")) {
                break;
            }

            else if (input.startsWith("echo ")) {
                System.out.println(input.substring(5));
            }

            else if (input.startsWith("type ")) {
                String command = input.substring(5);

                if (command.equals("echo")
                        || command.equals("exit")
                        || command.equals("type")) {

                    System.out.println(command + " is a shell builtin");
                } else {

                    boolean found = false;

                    // Prefer common system locations first
                    String[] preferred = {"/bin", "/usr/bin"};
                    for (String dir : preferred) {
                        File file = new File(dir, command);
                        if (file.exists() && file.isFile() && file.canExecute()) {
                            System.out.println(command + " is " + file.getAbsolutePath());
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        String path = System.getenv("PATH");
                        if (path != null && !path.isEmpty()) {
                            String[] pathDirs = path.split(File.pathSeparator);
                            for (String dir : pathDirs) {
                                File file = new File(dir, command);
                                if (file.exists() && file.isFile() && file.canExecute()) {
                                    System.out.println(command + " is " + file.getAbsolutePath());
                                    found = true;
                                    break;
                                }
                            }
                        }
                    }

                    if (!found) {
                        System.out.println(command + ": not found");
                    }
                }
            }

            else {
                System.out.println(input + ": command not found");
            }
        }

        sc.close();
    }
}