import java.util.ArrayList;


public class Food {
    private String name;
    private ArrayList<String> ingredients;
    private double price;

    // add drinks & dessert

    public Food(String n, ArrayList<String> i, double p){
        name = n;
        ingredients = i;
        price = p;

    }

    public String getName(){
        return name;
    }

    public ArrayList<String> getIngredients(){
        return ingredients;
    }

    public double getPrice(){
        return price;          
    }

    public static void main (String[] args){
        FoodInitialization f = new FoodInitialization();
        System.out.println(f.getCaliforniaRoll().getName());
        System.out.println(f.getCaliforniaRoll().getPrice());
        System.out.println(f.getWater().getPrice());
        System.out.println("$" + f.getOrangeJuice().getPrice());
        System.out.println();
        System.out.println();
        System.out.println();
    }

}
