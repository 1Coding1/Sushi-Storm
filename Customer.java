import java.util.Random;
import java.util.ArrayList;
import java.util.*;

public class Customer {
    private String name;
    private int level;
    private Random rand = new Random();
    private FoodInitialization f = new FoodInitialization();
    private ArrayList<Food> foods = new ArrayList<Food>(Arrays.asList(f.getAppleJuice(), f.getAvocadoMaki(), f.getBlackTea(), f.getBobaMilkTea(), f.getCaliforniaRoll(), f.getCaterpillarRoll(), f.getCocaCola(), f.getDragonRoll(), f.getFanta(), f.getGreenTea(), f.getKappaMaki(), f.getMochi(), f.getOrangeJuice(), f.getRainbowRoll(), f.getSalmonMaki(), f.getSesameBalls(), f.getShrimpTempura(), f.getSprite(), f.getWater()));
    
    private int numOfItems;
    private static ArrayList<Food> items = new ArrayList<Food>();


    // add a RNG chance for customer to spawn as bonus and/or regular (boosts score) - named creators or Mr. Kwong

    public Customer(String n, int l){
        name = n;
        level = l;
    }
    
    public ArrayList<Food> foods(){
        return foods;
    }

    public void setName(){
        String names[] = {"Bob", "Joe", "Carl", "Karen", "Rachel", "Bartholomew", "Gertrude", "Henry", "Ellen", "Isaac", "Bernie", "Napolean", "Julius", "Augustus", "Bertha", "Lux", "Noel", "Adora", "Fleur", "Jacqueline"};
        name = names[rand.nextInt(20)];
    }

    public String getName(){
        return name;
    }

    public void setLevel(int l){
        level = l;
    }

    public int getLevel(){
        return level;
    }

    public int getNumItems(int difficulty){
        
        if(level == 1){
            numOfItems = rand.nextInt(2)+1;
        } else if (level == 2) {
            numOfItems = rand.nextInt(3)+1;
        } else if (level == 3) {
            numOfItems = rand.nextInt(4)+1;
        } else {
            System.out.println("Error: invalid difficulty... please restart game.");
        } return numOfItems;

    }

    public ArrayList<Food> getItems(int numOfItems){
        // int numOfItems = c.getNumItems();
        items.clear();

        
        for (int i = 0; i < numOfItems; i++){
            int num = rand.nextInt(foods.size());
            items.add(foods.get(num));
        } 
        return items;
    }
    
    // test code
    public static void main (String[] args){
        Customer c = new Customer("c", 3);
        c.setName();
        System.out.println(c.getName());

        int numOfItems = c.getNumItems(c.getLevel());
        System.out.println(numOfItems);
        ArrayList<Food> customerItems = c.getItems(numOfItems);

        System.out.println("number of items: " + customerItems.size());
        
        for (int i = 0; i < customerItems.size(); i++){
            System.out.println(customerItems.get(i).getName());
        }
        System.out.println();
    }
}