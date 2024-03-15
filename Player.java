public class Player {
    /* calculate rating at the end of the game depending on # of served and # of mistakes */
    private double cash;
    private int mistakes;
    private int served;
    private int rating;
    private int hints;
    private int customers;

    public Player(double c, int m, int s, int r, int h, int t){
        cash = m;
        mistakes = m;
        served = s;
        rating = r;
        hints = h;
        customers = t;
    }
    
    public void playerReset(){
        cash = 0;
        mistakes = 0;
        served = 0;
        rating = 0;
        hints = 0;
        customers = 0;
    }

    public double getCash(){
        return cash;
    }

    public void addCash(double cashAmount){
        cash += cashAmount;
    }

    public int getMistakes(){
        return (customers-served);
    }

    public int getServed(){
        return served;
    }

    public void addServed(){
        served += 1;
    }

    public int getHints(){
        return hints;
    }

    public void addHint(){
        hints += 1;
    }

    public void setTotalCustomers(int t){
        customers = t;
    }

    public int getTotalCustomers(){
        return customers;
    }

    public String getRating(){
        rating = (served * 5) / customers;
        String stars = "";
        for (int idx = 0; idx<rating; idx++){
            stars += "★";
        } for (int e = 0; e < (5-rating); e++){
            stars+= "☆";
        }
        return stars;
    }

    public static void main (String[] args){
        Player player = new Player(0.00, 0, 0, 0, 0, 0);
        System.out.println(player.getCash());
        System.out.println(player.getMistakes());
        player.addServed();
        System.out.println(player.getServed());
        System.out.println(player.getRating());
    }
}