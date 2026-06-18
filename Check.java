import java.io.File;
public class Check {
  public static void main(String[] a) {
    File f = new File("/usr/bin/cat");
    System.out.println("exists=" + f.exists());
    System.out.println("isFile=" + f.isFile());
    System.out.println("canExecute=" + f.canExecute());
    try { System.out.println("abs=" + f.getAbsolutePath()); } catch (Exception e) { e.printStackTrace(); }
  }
}
