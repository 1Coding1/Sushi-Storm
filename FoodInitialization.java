import java.util.ArrayList;

public class FoodInitialization {
    // foods
    public Food getCaliforniaRoll(){
        ArrayList<String> californiaRollItems = new ArrayList<String>();
        californiaRollItems.add("Nori");
        californiaRollItems.add("Rice");
        californiaRollItems.add("Crab");
        californiaRollItems.add("Avocado");
        californiaRollItems.add("Cucumber");
        Food californiaRoll = new Food("California Roll", californiaRollItems, 5.25);
        return californiaRoll;
    }

    public Food getDragonRoll(){
        ArrayList<String> dragonRollItems = new ArrayList<String>();
        dragonRollItems.add("Nori");
        dragonRollItems.add("Rice");
        dragonRollItems.add("Avocado");
        dragonRollItems.add("Unagi");
        dragonRollItems.add("Shrimp Tempura");
        Food dragonRoll = new Food("Dragon Roll", dragonRollItems, 11.25);
        return dragonRoll;
    }
    
    public Food getRainbowRoll(){
        ArrayList<String> rainbowRollItems = new ArrayList<String>();
        rainbowRollItems.add("Nori");
        rainbowRollItems.add("Rice");
        rainbowRollItems.add("Avocado");
        rainbowRollItems.add("Shrimp");
        rainbowRollItems.add("Salmon");
        Food rainbowRoll = new Food("Rainbow Roll", rainbowRollItems, 10.75);
        return rainbowRoll;
    }

    public Food getKappaMaki(){
        ArrayList<String> kappaMakiItems = new ArrayList<String>();
        kappaMakiItems.add("Nori");
        kappaMakiItems.add("Rice");
        kappaMakiItems.add("Cucumber");
        Food kappaMaki = new Food("Kappa Maki", kappaMakiItems, 3.95);
        return kappaMaki;
    }

    public Food getCaterpillarRoll(){
        ArrayList<String> caterpillarRollItems = new ArrayList<String>();
        caterpillarRollItems.add("Nori");
        caterpillarRollItems.add("Rice");
        caterpillarRollItems.add("Cucumber");
        caterpillarRollItems.add("Unagi");
        caterpillarRollItems.add("Avocado");
        Food caterpillarRoll = new Food("Caterpillar Roll", caterpillarRollItems, 10.75);
        return caterpillarRoll;
    }

    public Food getAvocadoMaki(){
        ArrayList<String> avocadoMakiItems = new ArrayList<String>();
        avocadoMakiItems.add("Nori");
        avocadoMakiItems.add("Rice");
        avocadoMakiItems.add("Avocado");
        Food avocadoMaki = new Food("Avocado Maki", avocadoMakiItems, 3.95);
        return avocadoMaki;
    }

    public Food getShrimpTempura(){
        ArrayList<String> shrimpTempuraItems = new ArrayList<String>();
        shrimpTempuraItems.add("Shrimp Tempura");
        Food shrimpTempura = new Food("Shrimp Tempura", shrimpTempuraItems, 6.95);
        return shrimpTempura;
    }

    public Food getSalmonMaki(){
        ArrayList<String> salmonMakiItems = new ArrayList<String>();
        salmonMakiItems.add("Nori");
        salmonMakiItems.add("Rice");
        salmonMakiItems.add("Salmon");
        Food salmonMaki = new Food("Salmon Maki", salmonMakiItems, 3.95);
        return salmonMaki;
    }

    // desserts
    public Food getMochi(){
        ArrayList<String> mochiItems = new ArrayList<String>();
        mochiItems.add("Rice Flour");
        mochiItems.add("Red Bean Paste");
        Food mochi = new Food("Mochi", mochiItems, 3.75);
        return mochi;
    }

    public Food getSesameBalls(){
        ArrayList<String> sesameBallItems = new ArrayList<String>();
        sesameBallItems.add("Rice Flour");
        sesameBallItems.add("Red Bean Paste");
        Food sesameBalls = new Food("Sesame Balls", sesameBallItems, 4.95);
        return sesameBalls;
    }

    // drinks
    public Food getWater(){
        ArrayList<String> waterItems = new ArrayList<String>();
        waterItems.add("Water");
        Food water = new Food("Water", waterItems, 1.25);
        return water;
    }

    public Food getSprite(){
        ArrayList<String> spriteItems = new ArrayList<String>();
        spriteItems.add("Sprite");
        Food sprite = new Food("Sprite", spriteItems, 1.25);
        return sprite;
    }

    public Food getCocaCola(){
        ArrayList<String> cocaColaItems = new ArrayList<String>();
        cocaColaItems.add("Coca Cola");
        Food cocaCola = new Food("Coca Cola", cocaColaItems, 1.25);
        return cocaCola;
    }

    public Food getFanta(){
        ArrayList<String> fantaItems = new ArrayList<String>();
        fantaItems.add("Fanta");
        Food fanta = new Food("Fanta", fantaItems, 1.25);
        return fanta;
    }

    public Food getGreenTea(){
        ArrayList<String> greenTeaItems = new ArrayList<String>();
        greenTeaItems.add("Green Tea");
        Food greenTea = new Food("Green Tea", greenTeaItems, 1.95);
        return greenTea;
    }

    public Food getBlackTea(){
        ArrayList<String> blackTeaItems = new ArrayList<String>();
        blackTeaItems.add("Black Tea");
        Food blackTea = new Food("Black Tea", blackTeaItems, 1.95);
        return blackTea;
    }

    public Food getOrangeJuice(){
        ArrayList<String> orangeJuiceItems = new ArrayList<String>();
        orangeJuiceItems.add("Orange Juice");
        Food orangeJuice = new Food("Orange Juice", orangeJuiceItems, 1.75);
        return orangeJuice;
    }

    public Food getAppleJuice(){
        ArrayList<String> appleJuiceItems = new ArrayList<String>();
        appleJuiceItems.add("Apple Juice");
        Food appleJuice = new Food("Apple Juice", appleJuiceItems, 1.75);
        return appleJuice;
    }

    public Food getBobaMilkTea(){
        ArrayList<String> bobaMilkTeaItems = new ArrayList<String>();
        bobaMilkTeaItems.add("Boba Milk Tea");
        Food bobaMilkTea = new Food("Boba Milk Tea", bobaMilkTeaItems, 5.75);
        return bobaMilkTea;
    }

}