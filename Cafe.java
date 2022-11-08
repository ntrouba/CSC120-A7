/* This is a stub for the Cafe class */
public class Cafe extends Building {
    
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    /*
     * Creates cafe
     * @param String name of cafe
     * @param String address of cafe
     * @param int nFloors, numbers of floors the cafe has
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        nCoffeeOunces = 10;
        nSugarPackets = 10;
        nCreams = 10;
        nCups = 0;
        System.out.println("You have built a cafe: ☕");
    }
    /*
     * Determines if there are enough items to sell coffee
     * @param size int coffee cups
     * @param nSugarPackets int number of sugar packets
     * @param nCreams int number of creams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if(this.nCoffeeOunces < size){
            System.out.println("Not enough coffee to make this drink. Restock...!");  
        } 
        else if(this.nSugarPackets < nSugarPackets){
            System.out.println("Not enough sugar to make this drink. Restock...!");     
        }
        else if(this.nCreams < nCreams){
            System.out.println("Not enough creamer to make this drink. Restock...!");    
        }
        else if(this.nCups <= 0){
            System.out.println("Not enough cups to make this drink. Restock...!");     
        }
        else{
            this.nCoffeeOunces-=size;
            this.nSugarPackets-=nSugarPackets;
            this.nCreams-=nCreams;
            this.nCups-=1;
            System.out.println("Sold!");
        }
    }

    public void inventory(){
        System.out.println();
        System.out.println("*** Inventory ***");
        System.out.println("Coffee remaining: "+this.nCoffeeOunces);
        System.out.println("Sugar packets remaining: "+this.nSugarPackets);
        System.out.println("Cream remaining: "+this.nCreams);
        System.out.println("Cups remaining: "+this.nCups);
    }
    /*
     * Restocks items when out.
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        System.out.println("Restocking...");
        this.nCoffeeOunces+=nCoffeeOunces;
        this.nSugarPackets+=nSugarPackets;
        this.nCreams+=nCreams;
        this.nCups+=nCups;
    } 

    /*
     * Restocks coffee when out.
     * @param nCoffeeOunces amount of coffee to add to inventory
     */
    private void restock(int nCoffeeOunces){
        System.out.println("Restocking coffee...");
        this.nCoffeeOunces+=nCoffeeOunces;
    }

/*
     * Determines if there is enough coffee & cups to sell a black coffee
     * @param size ounces of coffee ordered
     */
    public void sellCoffee(int size){
        if(this.nCoffeeOunces < size){
            System.out.println("Not enough coffee to make this drink. Restock...!");  
        } 
        else if(this.nCups <= 0){
            System.out.println("Not enough cups to make this drink. Restock...!");     
        }
        else{
            this.nCoffeeOunces-=size;
            this.nCups-=1;
            System.out.println("Sold!");
        }
    }

    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee(size, nSugarPackets, nCreams)");
    }

    public void goToFloor(int floorNum) {
        if(floorNum != 1){
            throw new RuntimeException("Invalid. You are only allowed on the first floor of the cafe.");
        }
    }
    
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Campus Center Cafe", "100 Elm St, Northampton, MA 01063", 3);
        System.out.println(myCafe);
        System.out.println();
        myCafe.sellCoffee(2, 3, 2);
        myCafe.inventory();
        System.out.println();
        myCafe.restock(0, 0, 0, 5);
        myCafe.inventory();
        System.out.println();
        myCafe.sellCoffee(2, 3, 2);
        myCafe.inventory();
        System.out.println();
        myCafe.sellCoffee(5, 4, 2);
        myCafe.inventory();
        myCafe.restock(2);
        myCafe.inventory();
    }
}
