import javax.swing.*;
import java.util.ArrayList;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.event.*;
import java.text.DecimalFormat;
public class Display {

    private static String ingredients[] = {"Nori", "Rice", "Crab", "Avocado", "Cucumber", "Unagi", "Shrimp Tempura", "Shrimp", "Salmon", "Rice Flour", "Red Bean Paste", "Water", "Sprite", "Coca Cola", "Fanta", "Green Tea", "Black Tea", "Orange Juice", "Apple Juice", "Boba Milk Tea"};
    
    //private static String l;
    
    private static Customer customer;
    private static Player player;
    private static Display p = new Display(customer, player);
    

    private static JFrame frame = new JFrame("Sushi Storm");
    private static JPanel startPanel = new JPanel();
    private static JPanel level = new JPanel();
    private static JPanel how = new JPanel();
    private static JPanel menu = new JPanel();
    private static JPanel game = new JPanel();
    private static JPanel results = new JPanel();

    private static JButton button1 = new JButton("         Play         ");

    private static JButton easy = new JButton("Easy");
    private static JButton med = new JButton("Medium");
    private static JButton hard = new JButton("Hard");

    private static Dimension size = easy.getPreferredSize();
    private static JLabel label1 = new JLabel("SUSHI STORM");
    private static JButton button2 = new JButton("    How to Play?     ");
    private static JLabel diffic = new JLabel("Choose your difficulty...");
    private static JButton main = new JButton("Back to Main Screen");
    private static JButton cont = new JButton("continue");
    private static JButton hint = new JButton("Hint");
    
    private static JLabel order = new JLabel("Hi there, I would like to order: ");
    private static JLabel face = new JLabel("●");
    private static JLabel body = new JLabel("●");
    private static JLabel buttonsPressed = new JLabel("");
    private static int ing = ingredients.length;
    private static ArrayList<String> clicked = new ArrayList<String>();

    private static JLabel name = new JLabel();
    private static JTextArea customerFood = new JTextArea();

    private static JTextArea guideTextArea = new JTextArea(45, 50);
    private static JTextArea menuTextArea = new JTextArea(45, 50);
    private static JButton finalOrder = new JButton("Submit Order");
    private static int numCorrect = 0;
    private static int counter = 0;
    private static int foodIterator = 0;
    private static JButton replay = new JButton("Play Again");

    private static JLabel rating = new JLabel();
    private static JLabel cash = new JLabel();
    private static JLabel orderCompleted = new JLabel();
    private static JLabel orderMistakes = new JLabel();
    private static JLabel orderTotal = new JLabel();
    private static JLabel numHints = new JLabel();
        

    //results panel items:

    
    
    public Display(Customer tempC, Player tempP){
        customer = tempC;
        player = tempP;
    }

    public ArrayList<String> getClicked(){
        return clicked;
    }

    public void setStart(Boolean bool){
        startPanel.setVisible(bool);
        
        if (bool == true){
            bool = false;
        } else {
            bool = true;
        }
        
        how.setVisible(bool);   
        level.setVisible(bool);
        menu.setVisible(bool);
        results.setVisible(bool);
        game.setVisible(bool);

        frame.add(startPanel);

    }

    public void setGuide(Boolean bool){
        how.setVisible(bool);

        if (bool == true){
            bool = false;
        } else {
            bool = true;
        }
        startPanel.setVisible(bool);
        level.setVisible(bool);
        menu.setVisible(bool);
        results.setVisible(bool);
        game.setVisible(bool);

        frame.add(how);
    }

    public void setLevel(Boolean bool){
        level.setVisible(bool);

        if (bool == true){
            bool = false;
        } else {
            bool = true;
        }
        startPanel.setVisible(bool);
        how.setVisible(bool);   
        menu.setVisible(bool);
        results.setVisible(bool);
        game.setVisible(bool);

        frame.add(level);
    }

    public void setMenu(Boolean bool){
        menu.setVisible(bool);

        if (bool == true){
            bool = false;
        } else {
            bool = true;
        }
        startPanel.setVisible(bool);
        how.setVisible(bool);   
        level.setVisible(bool);
        results.setVisible(bool);
        game.setVisible(bool);

        frame.add(menu);
    }

    public void setResults(Boolean bool){
        getResult();
        if (bool == true){
            bool = false;
        } else {
            bool = true;
        }
        startPanel.setVisible(bool);
        how.setVisible(bool);   
        level.setVisible(bool);
        menu.setVisible(bool);
        game.setVisible(bool);

        //p.getResult();
        frame.add(results);
        results.setVisible(true);
    }

    public void setGame(Boolean bool){
        game.setVisible(bool);

        if (bool == true){
            bool = false;
        } else {
            bool = true;
        }
        startPanel.setVisible(bool);
        how.setVisible(bool);   
        level.setVisible(bool);
        menu.setVisible(bool);
        results.setVisible(bool);

        frame.add(game);
    }

    public void initPanel(){
        ArrayList <Food> testing = customer.getItems(customer.getLevel());
        Orders o = new Orders(clicked, customer, testing);
        for (int i = 0; i < testing.size(); i++){
            System.out.println(testing.get(i).getName());
        }

        frame.setSize(1440, 792);
        startPanel.setBackground(new Color(216, 215, 242));
        level.setLayout(null);
        level.setBackground(new Color(216, 215, 242));
        how.setLayout(null);
        how.setBackground(new Color(216, 215, 242));
        menu.setLayout(null);
        menu.setBackground(new Color(216, 215, 242));
        game.setLayout(null);
        game.setBackground(new Color(216, 215, 242));
        results.setLayout(null);
        results.setBackground(new Color(216, 215, 242));

        replay.setBounds(610, 600, size.width+60, size.height);
        replay.setFont(new Font("verdana", Font.BOLD, 17));
        results.add(replay);

        replay.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    rating.setText("");
                    cash.setText("");
                    orderCompleted.setText("");
                    orderMistakes.setText("");
                    orderTotal.setText("");
                    numHints.setText("");
                    player.playerReset();
                    p.setStart(true);
                    counter = 0;
                    customerFood.setText("");
                    p.newCustomer();
                    
                }
        });

        button1.setBounds(650, 290, size.width+87, size.height);
        label1.setFont(new Font("Verdana", Font.BOLD, 20));
        label1.setBounds(650, 200, size.width+200, size.height);
        button2.setBounds(650, 350, size.width+87, size.height);
        diffic.setFont(new Font("Verdana", Font.PLAIN, 20));
        diffic.setBounds(625, 200,size.width+250,size.height);

        main.setBounds(600,742,size.width+87, size.height);
        main.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    how.setVisible(false);
                    startPanel.setVisible(true);
                    frame.add(startPanel);
                }
        });

        //guide.setBounds(160,10, size.width+30, size.height);
        cont.setBounds(640,744, size.width+20, size.height);

        order.setBounds(700,60,size.width+200, size.height);
        order.setFont(new Font("verdana", Font.PLAIN, 15));
        hint.setBounds(1200, 210, size.width+20, size.height+20);
        hint.setFont(new Font("verdana", Font.BOLD, 17));
        hint.setForeground(new Color(79, 99, 229));
        game.add(hint);
        finalOrder.setBounds(950,100,size.width+70, size.height+30);
        finalOrder.setLocation(1150,130);
        finalOrder.setFont(new Font("verdana", Font.BOLD, 17));
        finalOrder.setForeground(new Color(79, 99, 229));
        game.add(finalOrder);


        hint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                p.setMenu(true);
                player.addHint();
            }
        });

        finalOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                p.newCustomer();
                // check order correctness
                foodIterator = 0;
                numCorrect = 0;
            }
        });

        

        for (int i = 0; i < ing; i++){
            JButton b = new JButton(ingredients[i]);
            if (i>= 0 && i<= 4){
                b.setBounds((i*250)+150,380,size.width+70, size.height+30);
            } else if (i>= 5 && i<=9){
                b.setBounds(((i-5)*250)+150,470,size.width+70, size.height+30);
            } else if (i>=10 && i<=14){
                b.setBounds(((i-10)*250)+150,560,size.width+70, size.height+30);
            } else{
                b.setBounds(((i-15)*250)+150,650,size.width+70, size.height+30);
            }
            game.add(b);
            
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    String n = b.getText();
                    //JButton o = (JButton)e.getSource();
                    //String name = o.getName();
                    clicked.add(n);
                    buttonsPressed.setText(clicked.toString());
                    buttonsPressed.setBounds(400,50,size.width+300,size.height);
                    game.add(buttonsPressed);
                
                }
            });

        }    //make undo function

            JButton submit = new JButton("Submit Item"); //submit the food
            submit.setBounds(1140, 270, size.width+80, size.height+20);
            submit.setFont(new Font("verdana", Font.BOLD, 17));
            submit.setForeground(new Color(79, 99, 229));
            game.add(submit);
            submit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){    
                    System.out.println(clicked);
                    if (clicked.size() == 0){
                        buttonsPressed.setText("");
                        clicked.clear();
                    } else if (o.correct(foodIterator)){
                        player.addCash(testing.get(foodIterator).getPrice());
                        // update the guide screen
                        System.out.println("correct");
                        numCorrect++;

                    } else {
                        System.out.println("incorrect");
                    }
                    buttonsPressed.setText("");
                    clicked.clear();

                    if (foodIterator < testing.size()){
                        if (numCorrect == testing.size()){
                            player.addServed();
                        }
                        System.out.println("food iterator: " + foodIterator);
                        foodIterator++;
                        System.out.println("food iterator #2: " + foodIterator);
                    }
                }
            });
            
        Dimension s = guideTextArea.getPreferredSize();
        guideTextArea.setBounds(400, 0, s.width, s.height);
        guideTextArea.setLocation(390, 5);
        guideTextArea.setEditable(false);
        Font font = new Font("Segoe Script", Font.PLAIN, 11);
        guideTextArea.setFont(font);
        how.add(guideTextArea);
        
        guideTextArea.setText("\t   \t  \tGUIDEBOOK: HOW TO PLAY\n"
        + "\n   -- BASIC INFORMATION --\n"
        + "   Difficulties - <Easy, Medium, Hard>\n"
        + "       - Easy:        1-2 items per order       [5 rounds]\n"
        + "       - Medium:   1-3 items per order      [10 rounds]\n"
        + "       - Hard:        1-4 items per order      [15 rounds]\n"
        + "\n   -- GAMEPLAY --\n"
        + "       Press [play] button to start the game (after exiting this guide page).\n"
        + "           > Select your desired difficulty ( Easy / Medium / Hard ).\n\n"
        + "       A [Menu] page will pop up and show a list of all items in the game (foods, desserts,\n       and beverages). It is HIGHLY RECOMMENDED that you read everything in this page\n       before you continue onto the actual game as it provides a list of ingredients for each\n       food item that you may need to serve in the game.\n          > Press the [continue] button to begin a game of Sushi Storm.\n\n"
        + "       The game will begin based on your selected difficulty (see [Basic Information] above).\n       Customers will appear one at a time and give you their order. You must make the foods\n       chronologically according to their order by selecting the correct ingredients for each\n       and click the button corresponding with each of them. After you have clicked the\n       ingredients for one item, there will be a [Submit Item] button for you to click to serve\n       the individual food item you have just made. Once you've finished serving each item,\n       you need to click the [Submit Order] in order to move on.\n"
        + "          > By completing an order, you gain the food order's cash value.\n          > If you make any mistakes (clicked the wrong ingredient(s)) on an order, the\n          entire order will be counted as a mistake and deduct from your score at the end of\n          the game.\n\n"
        + "       If you forget the ingredients, don't worry! There is a [hint] button on the right\n       of your screen which you may refer to.\n\n"
        + "       At the end of the game, your statistics will be displayed for you to see.\n\n"
        + "          > Rating (in stars)\n          > Amount of Cash earned\n          > Number of Orders completed correctly\n          > Number of Mistakes made\n          > Number of Orders attempted\n          > Hints used\n\n"
        + "   You are now ready master the arts of minimum-wage sushi restaurant employee. Get cooking!");
        guideTextArea.setLineWrap(true);
        guideTextArea.setWrapStyleWord(true);


        
        Dimension mS = guideTextArea.getPreferredSize();
        menuTextArea.setBounds(400, 0, mS.width, mS.height+90);
        menuTextArea.setLocation(390, 5);
        menuTextArea.setEditable(false);
        Font font2 = new Font("Segoe Script", Font.PLAIN, 9);
        menuTextArea.setFont(font2);
        menu.add(menuTextArea);
        
        menuTextArea.setText("\t    \t  \t\tGUIDEBOOK: MENU\n\n"
        + "   -- MAIN ENTREES --\n"
        + "   California Roll [5.25]\n       - Nori, Rice, Crab, Avocado, Cucumber\n\n   Dragon Roll [11.25]\n       - Nori, Rice, Avocado, Unagi, Shrimp Tempura\n\n   Rainbow Roll [10.75]\n       - Nori, Rice, Avocado, Shrimp, Salmon\n\n   Caterpillar Roll [10.75]\n       - Nori, Rice, Avocado, Cucumber, Unagi\n\n   Kappa Maki [3.95]\n       - Nori, Rice, Cucumber\n\n   Avocado Maki [3.95]\n       - Nori, Rice, Avocado\n\n   Salmon Maki [3.95]\n       - Nori, Rice, Salmon\n\n   Shrimp Tempura [6.95]\n       - Shrimp Tempura\n\n"
        + "\n   -- DESSERTS --\n"
        + "   Mochi [3.75]\n       - Rice Flour, Red Bean Paste\n\n   Sesame Balls [4.95]\n       - Rice Flour, Red Bean Paste\n\n"
        + "\n   -- BEVERAGES --\n"
        + "   Water [1.25]\n       - Water\n\n   Sprite [1.25]\n       - Sprite\n\n   Coca Cola [1.25]\n       - Coca Cola\n\n   Fanta [1.25]\n       - Fanta\n\n   Green Tea [1.95]\n       - Green Tea\n\n   Black Tea [1.95]\n       - Black Tea\n\n   Boba Milk Tea [5.75]\n       - Boba Milk Tea\n\n   Orange Juice [1.75]\n       - Orange Juice\n\n   Apple Juice [1.75]\n       - Apple Juice\n\n");
        menuTextArea.setLineWrap(true);
        menuTextArea.setWrapStyleWord(true);

        game.add(order);
        
        
        
        face.setBounds(255, 160, size.width+250, size.height+250);
        face.setFont(new Font("Verdana", Font.PLAIN, 175));
        face.setLocation(240, 20);

        
        body.setBounds(200, 100, size.width+400, size.height+50);
        body.setLocation(190, 200);
        body.setFont(new Font("Verdana", Font.PLAIN, 350));
        easy.setBounds(550, 400,size.width, size.height);
        med.setBounds(700, 400,size.width, size.height);
        hard.setBounds(850, 400,size.width, size.height);


        game.add(face);
        game.add(body);
        startPanel.setLayout(null);
        startPanel.add(label1);
        startPanel.add(button1);
        startPanel.add(button2);
        level.add(diffic);
        level.add(easy);
        level.add(med);
        level.add(hard);
        //how.add(guide);
        how.add(main);
        menu.add(cont);
        menu.add(menuTextArea);
        frame.add(startPanel);
        frame.setVisible(true);
        game.setVisible(false);

        

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                p.setLevel(true);
                //level.setVisible(true);
            }
        });
        
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                p.setGuide(true);

            }
        });


        easy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                customer.setLevel(1);
                player.setTotalCustomers(5);
                p.setMenu(true);
                
            }
        });
        med.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                customer.setLevel(2);
                player.setTotalCustomers(10);
                p.setMenu(true);
                
            }
        });
        hard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                customer.setLevel(3);
                player.setTotalCustomers(15);
                p.setMenu(true);
                
            }
        });

        cont.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                p.setGame(true);
            }
        });

    }

    public void newCustomer(){
        name.setText("");
        

        customer.setName();
        int numItems = customer.getNumItems(counter);
        ArrayList<Food> customerOrder = customer.getItems(numItems);
        
       
        
        customerFood.setBounds(0, 0, 150, 100);
        customerFood.setLocation(600, 100);

        String customerOrderItems = "";

        for (int i = 0; i < customerOrder.size(); i++){
            customerOrderItems += "\n   " + customerOrder.get(i).getName();
            
        }
        customerOrderItems += "\n";

        customerFood.setText(customerOrderItems);
        customerFood.setEditable(false);
        System.out.println(customerOrderItems);

        Font foodFont = new Font("Segoe Script", Font.PLAIN, 11);
        customerFood.setFont(foodFont);

        
        name.setText(customer.getName());
        
        
        name.setBounds(80,0,size.width+100, size.height+100);
        name.setLocation(250,30);
        name.setFont(new Font("Verdana", Font.PLAIN, 22));
        
        counter ++;
        if (customer.getLevel() == 1 && counter == 6){
            p.setResults(true);
        } if (customer.getLevel() == 2 && counter == 11){
            p.setResults(true);
        } if (customer.getLevel() == 3 && counter == 16){
            p.setResults(true);;
        }
        game.add(customerFood);
        game.add(name);
    }

    public void getResult(){
        JLabel rating = new JLabel("Rating: "+ player.getRating());
        
        DecimalFormat df2 = new DecimalFormat("#.##");
        cash.setText("Cash: $" + df2.format(player.getCash()));
        orderCompleted.setText("Correct Orders: " + player.getServed());
        orderMistakes.setText("Mistaken Orders: " + player.getMistakes());
        orderTotal.setText("Total Orders: " + player.getTotalCustomers());
        numHints.setText("Hints: " + player.getHints());

        rating.setBounds(500,125,size.width+100, size.height);
        cash.setBounds(500,200, size.width+100, size.height);
        orderCompleted.setBounds(500, 275, size.width+100, size.height);
        orderMistakes.setBounds(500,350,size.width+100, size.height);
        orderTotal.setBounds(500,425,size.width+100, size.height);
        numHints.setBounds(500,500,size.width+100, size.height);

        rating.setFont(new Font("verdana", Font.PLAIN, 15));
        cash.setFont(new Font("verdana", Font.PLAIN, 15));
        orderCompleted.setFont(new Font("verdana", Font.PLAIN, 15));
        orderMistakes.setFont(new Font("verdana", Font.PLAIN, 15));
        orderTotal.setFont(new Font("verdana", Font.PLAIN, 15));
        numHints.setFont(new Font("verdana", Font.PLAIN, 15));

        results.add(rating);
        results.add(cash);
        results.add(orderCompleted);
        results.add(orderMistakes);
        results.add(orderTotal);
        results.add(numHints);

        startPanel.setVisible(false);
        how.setVisible(false);   
        level.setVisible(false);
        menu.setVisible(false);
        game.setVisible(false);
        
        frame.add(results);
        results.setVisible(true);
    }

    public static void main(String[] args) {
        Customer c = new Customer("Bob", 1);
        Player p = new Player(0,0,0,0,0,0);
        
        Display d = new Display(c, p);
        d.initPanel();
        d.newCustomer();
        
        
   }
}