import java.util.Hashtable;

/*
 * Represents a library.
 */
public class Library extends Building{

  private Hashtable<String, Boolean> collection;
  private Boolean hasElevator;

  /* Creates a library with the specified parameters.
  * @param name The library's name.
  * @param address The library's first name.
  * @param nFloors number of floors
  * @param collection the library's collection
  */
  public Library(String name, String address, int nFloors, Hashtable<String, Boolean> collection, Boolean elevator){

    super(name, address, nFloors);
    this.collection = collection;
    this.hasElevator = elevator;
    System.out.println("You have built a library: 📖");

    }

  /*
   * Adds title to collection hashTable
   * @param title name of book
   */
  public void addTitle(String title){
    this.collection.put(title, true);
  }

  /*
   * Adds two titles to collection hashTable
   * @param title name of book
   */
  public void addTitle(String title1, String title2){
    this.collection.put(title1, true);
    this.collection.put(title2, true);
  }

  /*
   * Removes title from collection hashTable
   * @param title name of book
   */
  public void removeTitle(String title){
    this.collection.remove(title);
  }

  /*
   * Removes 2 titles from collection hashTable
   * @param title name of book
   */
  public void removeTitle(String title1, String title2){
    this.collection.remove(title1);
    this.collection.remove(title2);
  }

  /*
   * Checks out a book by changing status of book to false or printing that the book is already checked out.
   * @param title name of book 
   */
  public void checkOut(String title){
    if (containsTitle(title) == true){
      this.collection.replace(title, false);
    } else{
      System.out.println("This book has already been checked out.");
    }

  }

  /*
   * Returns the book by changing the boolean value to true if the book is in the collection
   * @param title name of the book.
   */
  public void returnBook(String title){
    if (this.collection.containsKey(title)){
      this.collection.replace(title, true);
    } else {
      System.out.println("Book is not in the collection");
    }
  }

  /*
   * Returns true if the title appears as a key in the Libary's collection, false otherwise.
   * @param title name of book
   * @return boolean whether or not the book is in the hashTable
   */
  public boolean containsTitle(String title){
    return this.collection.containsKey(title);
  }

  /*
   * Returns true if the title is currently available, false otherwise.
   * @param title name of book
   * @return booleans for if book is availible
   */
  public boolean isAvailable(String title){
    try{
      if(this.collection.get(title) == true){
        return this.collection.get(title);
  
      } else {
        return this.collection.get(title);
  
      }
    } catch (NullPointerException e) {
      System.out.println("NullPointerException thrown! This book cannot be found in the collection.");
      return false;
    }
  }

/*
 * prints out the entire collection in an easy-to-read way (including checkout status)
 */
  public void printCollection(){
    // Iterating over keys only
    int count = 0;
    String available;
    for (String key : this.collection.keySet()) {
      count += 1;
      if (isAvailable(key) == true){
        available = "available.";
      } else {
        available = "not available.";
      }
      System.out.println(count + ".)" + key + " is " + available);
    }
  }

  /*
   * Creates String to describe the library
   * @return String describing the library
   */
  public String toString(){
    return this.name + " is a " + this.nFloors + "-story Library located at " + this.address + ". The following is the collection of books and there avalibility status: " + this.collection; 

  }

  /*
   * Evaluates whether Library has an elevator and accordingly manages 
   * ...whether one can move to the desired floor.
   * @param int floorNum desired floor
   */
  public void goToFloor(int floorNum) {
    if(this.hasElevator){
      super.goToFloor(floorNum);
    } else{
      throw new RuntimeException(this.name + " does not have an elevator. Use goUp() or goDown() to move to an adjacent floor.");
    }
  }

  /*Prints options to the console*/
  public void showOptions(){
    super.showOptions();
    System.out.println(" + addTitle(title) \n + removeTitle(title) \n + checkOut(title) \n + returnBook(title) \n + containsTitle(title) \n + isAvailable(title) \n + printCollection()");
  }
   
    public static void main(String[] args) {
      Hashtable<String, Boolean> neilsonCollection = new Hashtable<String, Boolean> ();
      neilsonCollection.put("Grapes of Wrath", true); neilsonCollection.put("Warrior Cats", false); neilsonCollection.put("The Secret Chamber", true);

      Library neilson = new Library("Neilson", "Chapin Way", 4, neilsonCollection, true);

      neilson.showOptions();
      neilson.addTitle("Midnight Sun", "Lolita");
      neilson.printCollection();
      System.out.println(neilson.toString());
      neilson.addTitle("War and Peace");
      System.out.println(neilson.toString());
      neilson.removeTitle("War and Peace");
      System.out.println(neilson.toString());
      System.out.println(neilson.containsTitle("The Secret Chamber"));
      System.out.println(neilson.containsTitle("Th"));
      // neilson.checkOut("The Secret Chamber");
      // neilson.checkOut("The Secret Chmber");
      System.out.println(neilson.collection);
      System.out.println("-----------");
      System.out.println(neilson.isAvailable("The Secret Chamber"));
      System.out.println(neilson.isAvailable("j"));
      neilson.printCollection();
    }
  }