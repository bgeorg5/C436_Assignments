/*
        //Use return/ enter to traverse menu items
        while(input.hasNext() && flag == false){
            if(input.equals(""){
                flag = true;
            }
            else{
                
            }
        }
*/
/* COSC436 - Section 001 - Assignment 3 - Bethany George */
import java.util.Scanner;

public class Client {
public static final Scanner input = new Scanner(System.in);
public static final String[] Categories = {"Appetizers", "Main Dish", "Dessert"};

    public static void main(String[] args){
        Menu JoesCafe = new Menu();
        boolean MenuFlag = true; 
        int in = 0;
        //String return = input.nextLine();
        JoesCafe = initializeMenu(JoesCafe);
        
        MenuIterator itr;
        MenuItem item = null;

        do{
            printTestingMethods();
            in = input.nextInt();
            /*
            if(){
            }
            catch(){
            
            }
            */
            switch(in){
                /*Exit Menu*/
                case 0: 
                    System.out.println("Exitting Menu");
                    MenuFlag = false;
                    break;
                    
                /*Test 1*/
                case 1:
                    itr = JoesCafe.getAllItemsIterator();
                    System.out.println("ALL MENU ITEMS: ");
                    while(itr.hasNext()){
                        item = itr.next();
                        System.out.println(item.getName() + "  $" + item.getPrice());
                    }
                    break;
                /*Test 3 - Item Iterator - Dessert*/
                case 2:
                    itr = JoesCafe.getItemIterator(Menu.APPETIZERS);	
                    System.out.println("ALL APPETIZER MENU ITEMS: ");
                    while (itr.hasNext()){
                        item = itr.next();
                        System.out.println(item.getName() + "  $" + item.getPrice());
                    }
                    break;
                    
                /*Test 2 - Item Iterator - main dishes*/
                case 3:
                    itr = JoesCafe.getItemIterator(Menu.MAIN_DISH);
                    System.out.println("ALL MAIN DISHES: ");
                    while (itr.hasNext()){
                        item = itr.next();
                        System.out.println(item.getName() + "  $" + item.getPrice());
                    }
                    break;
                    
                /*Test 3 - Item Iterator - Dessert*/
                case 4:
                    itr = JoesCafe.getItemIterator(Menu.DESSERT);	
                    System.out.println("ALL DESSERT MENU ITEMS: ");
                    while (itr.hasNext()){
                        item = itr.next();
                        System.out.println(item.getName() + "  $" + item.getPrice());
                    }
                    break;
                    
                /*Test 4 - Heart Healthy Iterator */
                case 5:
                    itr = JoesCafe. getHeartHealthyIterator();	
                    System.out.println("ALL HEART HEALTHY MENU ITEMS");
                    while (itr.hasNext()){
                        item = itr.next();
                        System.out.println(item.getName() + "  $ "+ item.getPrice());
                    }
                    break;
               
                /*Test 5 - Price iterator*/
                case 6:
                    System.out.println("Please enter a price limit");                   //CHECK THIS OUT
                    String limit = input.next();
                    
                    itr = JoesCafe.getPriceIterator(limit);	
                    System.out.println("ALL ITEMS UNDER "+limit+": ");
                    while (itr.hasNext()){
                       item = itr.next();
                       System.out.println(item.getName() + "  $" + item.getPrice());
                    }
                    break;
                
                /*Test 5 - Add a menu item*/
                case 7:
                    addItems(JoesCafe, item);

                    break;
                
                case 8:
                    itr = JoesCafe.getAllItemsIterator();
                    removeItems(JoesCafe, itr, item);
                    break;
                    
                 /*Default statement*/
                default:
                    System.out.println("default statement");
                    break;
            }
        }while(MenuFlag == true); 
    }
    
    public static void printTestingMethods(){
        System.out.println("\nTesting Menu - Please enter:");
        System.out.println("0: exit menu");
        System.out.println("1: All Item Iterator");
        System.out.println("2: Item Iterator - Appetizer");
        System.out.println("3: Item Iterator - Main Dishes");
        System.out.println("4: Item Iterator - Desserts ");
        System.out.println("5: Heart Helthy Iterator");
        System.out.println("6: Price Iterator");
        System.out.println("7: Add a menu Item");
        System.out.println("8: Remove a menu Item");

    }
    
    public static Menu initializeMenu(Menu menu){
        menu.add("Fries", Menu.APPETIZERS, Menu.NOT_HEART_HEALTHY, "3.99"); 
        menu.add("Onion Rings", Menu.APPETIZERS, Menu.NOT_HEART_HEALTHY, "3.99"); 
        menu.add("Fried Calamari", Menu.APPETIZERS, Menu.NOT_HEART_HEALTHY, "6.99"); 
        menu.add("Pita and Hummus", Menu.APPETIZERS, Menu.NOT_HEART_HEALTHY, "4.99"); 

        menu.add("Portabella Mushroom Burger", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, "9.99"); 
        menu.add("Vegetarian Burger", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, "8.99"); 
        menu.add("Turkey Wrap", Menu.MAIN_DISH, Menu.HEART_HEALTHY, "10.99"); 
        menu.add("Turkey BLT", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, "8.99"); 
        menu.add("Veggie Wrap", Menu.MAIN_DISH, Menu.HEART_HEALTHY, "9.99"); 
        menu.add("Chicken Salad", Menu.MAIN_DISH, Menu.HEART_HEALTHY, "12.99"); 
        menu.add("House Salad", Menu.MAIN_DISH, Menu.HEART_HEALTHY, "10.99"); 
        menu.add("Chicken noodle soup", Menu.MAIN_DISH, Menu.HEART_HEALTHY, "6.99"); 
        menu.add("Split Pea soup", Menu.MAIN_DISH, Menu.HEART_HEALTHY, "5.99"); 
        menu.add("Miso soup", Menu.MAIN_DISH, Menu.HEART_HEALTHY, "5.99"); 
        menu.add("Reuban", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, "8.99");
        
        menu.add("Flan", Menu.DESSERT, Menu.NOT_HEART_HEALTHY, "4.99"); 
	menu.add("Rice Pudding", Menu.DESSERT, Menu.NOT_HEART_HEALTHY, "3.50");
        menu.add("Chocolate cake", Menu.DESSERT, Menu.NOT_HEART_HEALTHY, "4.99"); 
        menu.add("Vanilla bun", Menu.DESSERT, Menu.NOT_HEART_HEALTHY, "3.50"); 
        menu.add("Grapefruit tart", Menu.DESSERT, Menu.NOT_HEART_HEALTHY, "4.99"); 
        menu.add("Dulce de leche", Menu.DESSERT, Menu.NOT_HEART_HEALTHY, "6.99"); 

        return menu;
    }

    public static void printItr(MenuIterator itr, MenuItem item){
        while (itr.hasNext()){
            item = itr.next();
            System.out.println(item.getName() + "  $" + item.getPrice());
        }
    }   //use me instead
    
    public static void addItems(Menu JoesCafe, MenuItem item){
        String selection = input.nextLine();
        int i = 0; int CategoryStatus = -1;
        String tempName, tempPrice, tempCategory;
        boolean HH;

        /**/
        System.out.println("Please enter the items name");
        tempName = input.next();
        
        /**/
        System.out.println("Please enter the items Category: \n ");
                    
        do{
        System.out.println("Is the Item a "+Categories[i]+" (y/n)");
        tempCategory = input.next();
            if("y".equals(tempCategory) || "Y".equals(tempCategory) || "yes".equals(tempCategory) || "YES".equals(tempCategory)){
                switch(i){
                    case 0:
                        CategoryStatus = Menu.APPETIZERS;
                        break;
                    case 1:
                        CategoryStatus = Menu.MAIN_DISH;
                        break;
                    case 2:
                        CategoryStatus = Menu.DESSERT;
                        break;
                    default:
                        System.out.println("Default case");
                        break;
                    }
            }
            else{
                if(i < Categories.length-1){
                    i++;
                }
                else{
                    i = 0;
                }
            }
        }while(CategoryStatus == -1);
            
        /**/
        System.out.println("Is the item Heart Healthy? (y/n)");                   //CHECK THIS OUT
        String tempHH = input.next();
        if("y".equals(tempHH) || "Y".equals(tempHH) || "yes".equals(tempHH) || "YES".equals(tempHH)){
             HH = Menu.HEART_HEALTHY;
        }
        else{
            HH = Menu.NOT_HEART_HEALTHY;
        }
        
        /**/
        System.out.println("Please enter the items Price");                   //CHECK THIS OUT
        tempPrice = input.next();
        
        JoesCafe.add(tempName, CategoryStatus, HH, tempPrice); 
    }
    
    public static void removeItems(Menu JoesCafe, MenuIterator itr, MenuItem item){
        String selection = input.nextLine();
                   
        System.out.println("Hit 'd' to delete an item");
        
        while(itr.hasNext() && !("d".equals(selection) || "D".equals(selection))){
            item = itr.next();
            System.out.println(item.getName() + "  $" + item.getPrice());
            selection = input.nextLine();
        }
                    
        if((selection.equals("d") || selection.equals("D")) && item != null){
            JoesCafe.delete(item);
            System.out.println("Item deleted");
        } 
        else{
            System.out.println("No items were deleted");
        }
    }
}
