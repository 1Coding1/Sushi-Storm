import java.util.Scanner;
public class FinalProject {


    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        Customer c = new Customer("Bob", 1);
        Player p = new Player(0,0,0,0,0,0);
        
        Display d = new Display(c, p);
        d.initPanel();
        d.newCustomer();

        //System.out.println(d.getLevel());


        // how to clear the screen System.out.print(String.format("\033[2J"));

        // prompted with two buttons (play & how to)
        // if play, begin game immediately (menu is displayed before game starts)
        // if how to, show instructions then begin game once player finishes reading


        // after game is finished
        
        System.out.println("Play again? (Y/N) ");
        String playAgain = scan.nextLine();
        if (playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("y")){
            //play again
        } else {
            System.out.println("Thank you for playing Sushi Storm!");
        }

        System.out.println(c.getLevel());
        scan.close();
    }
}
