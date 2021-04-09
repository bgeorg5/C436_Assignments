/* COSC436 - Section 001 - Assignment 3 - Bethany George */
    public class MenuItem{
        public String ItemName;
        public int Category;
        public boolean HeartHealthy;
        public double Price;
        
        public MenuItem(String n, int c, Boolean h, Double p){
            ItemName = n;
            Category = c;
            HeartHealthy = h;
            Price = p;
        }
        
        public String getName(){
            return this.ItemName;
        }
        public String getCategory(){
            switch (this.Category) {
                case 1:
                    return "APPETIZERS";
                case 2:
                    return "MAIN DISH";
                case 3:
                    return "DESSERT";
                default:
                    return "Undefine Category";
            }
        }
        //public int getCategory(){}                                            //Check if necessary
        public double getPrice(){
            return this.Price;
        }
        public boolean getHeartHelthyStatus(){
            return this.HeartHealthy;
        }
        
        public boolean equals(MenuItem temp){
            return this.Category == temp.Category && this.HeartHealthy == temp.HeartHealthy && this.ItemName.equals(temp.ItemName) && this.Price == temp.Price;
        }
         public boolean isEmpty(){
            return this.ItemName.isEmpty();
        }
    }
