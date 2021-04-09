/* COSC436 - Section 001 - Assignment 3 - Bethany George */
import java.util.Iterator;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Menu{                                                              /*Change the hasNext() in all iterators to 1 line if functional*/
    public static final int APPETIZERS = 1;                                     /*Change public to protected and private where appropriate*/
    public static final int MAIN_DISH = 2;                                      /*Deletion method*/
    public static final int DESSERT = 3;
    public static final boolean HEART_HEALTHY = true;
    public static final boolean NOT_HEART_HEALTHY = false;

    public ArrayList<MenuItem> Items = new ArrayList();
    //public int index;
    
    /*Constructors*/
    public Menu(){}
    public Menu(ArrayList<MenuItem> i){
        Items = i;
    }
    
    /*Add methods*/
    public void add(MenuItem i){/*Optional Method*/
        int temp = size();
        Items.add(i);
    }
    public void add(String n, int c, Boolean h, String s){
        double p = Double.parseDouble(s);
        MenuItem i = new MenuItem(n, c, h, p);
        
        Items.add(i);
        
        int temp = size()-1;                                                    //for testing
    }
    
    /*Delete methods*/  
    public void delete(int index){/*Optional Method*/
        Items.remove(index);
    }
    public void delete(MenuItem i){                                          
        Items.remove(i);
    }                                
    public void delete(Iterator it, String name){/*Optional Method*/
        int index = -1; int currentSize = this.size();
        try{
            MenuItem temp = (MenuItem) it.next();
            while(!temp.ItemName.equals(name)){
                temp = (MenuItem) it.next();
            }
            if(index >= 0 && index <= currentSize){
                Items.get(index);
                Items.remove(index);
            }
        }
        catch(Exception e){
            System.out.println("delete() Error: "+e.toString());
        }

    }
    public void delete(String name){
        AllItemsIterator i = new AllItemsIterator(this.Items);
        MenuItem temp = i.next();
        
        while(!temp.ItemName.equals(name)){
            temp = i.next();
        }
    }                               //optional, delete this probably
    
    public int size(){
        return Items.size();
    }
    
    /*Iterators*/
    public MenuIterator getAllItemsIterator(){
        return new AllItemsIterator(Items);
    }
    public MenuIterator getItemIterator(int type){                              //make string --> int switch statement?
        return new ItemIterator(Items, type);
    }
    public MenuIterator getHeartHealthyIterator(){
        return new HeartHealthyIterator(Items);
    }
    public MenuIterator getPriceIterator(double Price){
        return new PriceIterator(Items, Price);
    }             //check to see if necessary
    public MenuIterator getPriceIterator(String priceString) throws InputMismatchException{
        double Price = Double.parseDouble(priceString);
        return new PriceIterator(Items, Price);
    }
       
    public class AllItemsIterator implements MenuIterator{
        public int count = 0;
        public ArrayList<MenuItem> list;
        
        public AllItemsIterator(ArrayList<MenuItem> i){
            list = i;
        }
        
        @Override
        public boolean hasNext() {
            if(list.isEmpty()){
                System.out.println("There are no Items that fit this Category.");
                return false;
            }
            return !(count >= list.size() || list.get(count) == null);
        }

        @Override
        public MenuItem next() {
            MenuItem temp = list.get(count);
            count++;
            return temp;        
        }   
    }
    
    public class ItemIterator implements MenuIterator{
        public int count = 0;
        public ArrayList<MenuItem> list = new ArrayList();
        //public int ItemType;
        
        public ItemIterator(ArrayList<MenuItem> i, int ItemType){
            //ItemType = t;
            MenuItem TempItem;
            
            for(int j = 0; j <= i.size()-1; j++){
                if(i.get(j).Category == ItemType){
                    TempItem = i.get(j);
                    list.add(TempItem);
                }
            }
        }
        
        @Override
        public boolean hasNext() {
            if(list.isEmpty()){
                System.out.println("There are no Items that fit this Category.");
                return false;
            }
            return !(count >= list.size() || list.get(count) == null);
        }

        @Override
        public MenuItem next() {
            MenuItem temp = list.get(count);
            count++;
            return temp;        
        }
    }
        
    public class HeartHealthyIterator implements MenuIterator{
        public int count = 0;
        public ArrayList<MenuItem> list = new ArrayList();
        
        public HeartHealthyIterator(ArrayList<MenuItem> i){
            MenuItem TempItem;
            for(int j = 0; j <= i.size()-1; j++){
                if(i.get(j).getHeartHelthyStatus() == true){
                    TempItem = i.get(j);                    
                    list.add(TempItem);
                }
            }
        }
        
        @Override
        public boolean hasNext() {
            if(list.isEmpty()){
                System.out.println("There are no Items that fit this Category.");
                return false;
            }
            return !(count >= list.size() || list.get(count) == null);
        }

        @Override
        public MenuItem next() {
            MenuItem temp = list.get(count);
            count++;
            return temp;
        }
    }   
    
    public class PriceIterator implements MenuIterator{
        public int count = 0;
        public ArrayList<MenuItem> list = new ArrayList();
        //public double priceLimit;
        
        public PriceIterator(ArrayList<MenuItem> i, double priceLimit){
            //priceLimit = max;
            MenuItem TempItem;
            for(int j = 0; j <= i.size()-1; j++){
                if(i.get(j).getPrice() < priceLimit){
                    TempItem = i.get(j);                  
                    list.add(TempItem);
                }
            }        
        }
        
        @Override
        public boolean hasNext() {
            if(list.isEmpty()){
                System.out.println("There are no Items that fit this Category.");
                return false;
            }
            return !(count >= list.size() || list.get(count) == null);
        }

        @Override
        public MenuItem next() {
            MenuItem temp = list.get(count);
            count++;
            return temp;        
        }
    }   
}
