import java.util.Scanner;

public class main { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please insert your expression:");
        String input = sc.nextLine();

        System.out.println("your input: '" + input+ "'");
        
        calc c = new calc();

        System.out.println("Result: "+c.evaluate(input));



        sc.close();
    }
}