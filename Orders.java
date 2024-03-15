import java.util.ArrayList;

public class Orders {
    private Customer c;
    private ArrayList<String> fI;
    private ArrayList<Food> o;


    public Orders(ArrayList<String> foodItem, Customer customer, ArrayList<Food> order){
        fI = foodItem;
        c = customer;
        o = order;

    }

    public Boolean correct(int ind){
        Boolean bool = true;

        Food correct = o.get(ind);

        ArrayList<String> ingr = correct.getIngredients();

        if (fI.size() != ingr.size()){
            bool = false;
        } else{
            for (int i = 0; i < fI.size(); i++){
                // if ingredientsubmitted cannot be found in ingredient list, bool = false
                if (ingr.contains(fI.get(i))){
                } else {
                    bool = false;
                }
            }
        }

        return bool;
    }
}