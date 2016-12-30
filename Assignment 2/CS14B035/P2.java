import syntaxtree.*;
import visitor.*;

public class P2 {
   public static void main(String [] args) {
      try {
         Node root = new MiniJavaParser(System.in).Goal();
         GJDepthFirst<String,String> fparse=new GJDepthFirst<String,String>();
         root.accept(fparse,"0"); // Your assignment part is invoked here.
         root.accept(fparse,"1");
         System.out.println("Program type checked successfully");
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
} 



