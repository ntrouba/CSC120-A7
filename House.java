//import javax.management.RuntimeErrorException;
import java.util.ArrayList;

/*
 * Represents a house.
 */
public class House extends Building{

  private ArrayList<String> residents;
  private Boolean hasDiningRoom;
  private Boolean hasElevator;

  /* Creates a house with the specifed parameters.
  * @param name The house's name.
  * @param address The house's first name.
  * @param nFloors number of floors
  * @param residents list of house residents 
  * @param hDR if the house has a dining hall or not
  */
  public House(String name, String address, int nFloors, ArrayList<String> residents, Boolean hDR, Boolean elevator) {

    super(name, address, nFloors);
    this.residents = residents;
    this.hasDiningRoom = hDR;
    this.hasElevator = elevator;
    
    System.out.println("You have built a house: 🏠");
  }

/*
 * Finds the number of residents in the house.
 * @return This houses number of residents.
 */
public int nResidents(){
  return this.residents.size();
}

/*
 * Checks if the house has a dining room.
 * @return Boolean for whether house has a dining room.
 */
public boolean hasDiningRoom(){
  return this.hasDiningRoom;
}

/*
 * Removes resident from the house.
 * @param residentName string residents name that moved out.
 */
public String moveOut(String residentName){
  int indexOfResident = this.residents.indexOf(residentName);
  this.residents.remove(indexOfResident);
  return residentName;
}

/*
 * Moves in resident.
 * @param residentName string residents name that moved in.
 */
public void moveIn(String residentName){
  this.residents.add(residentName);
}

/*
 * Moves in two residents.
 * @param residentName string residents name that moved in.
 */
public void moveIn(String residentName1, String residentName2){
  this.residents.add(residentName1);
  this.residents.add(residentName2);
}

/*
 * Moves in three residents.
 * @param residentName string residents name that moved in.
 */
public void moveIn(String residentName1, String residentName2, String residentName3){
  this.residents.add(residentName1);
  this.residents.add(residentName2);
  this.residents.add(residentName3);
}

/*
 * Determines if person is resident of a house.
 * @param person string person who is or isn't a resident
 */
public boolean isResident(String person){
  return this.residents.contains(person);
}

/*
 * Gives information about house
 */
public String toString(){
  String diningHall;
  if (hasDiningRoom() == true){
    diningHall = "a dining Hall.";
  } else {
    diningHall = "no dining Hall.";
  }
  return this.name + " house is a " + this.nFloors + "-story building located at " + this.address + " with " + nResidents() + " residents and " + diningHall;
}

/*
 * Evaluates whether House has an elevator and accordingly manages
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
public void showOptions() {
  super.showOptions();
  System.out.println(" + nResidents() \n + hasDiningRoom() \n + moveOut(residentName) \n + moveIn(residentName) \n +isResident(person)");
}

  public static void main(String[] args) {
    ArrayList<String> cushingResidents = new ArrayList<String>();
    cushingResidents.add("Nathalie"); cushingResidents.add("Lara"); cushingResidents.add("Clare"); cushingResidents.add("Bena");

    House cushing = new House("Cushing", "10 Elm St Northampton MA, 01063", 4, cushingResidents, true, true);

    cushing.showOptions();
    System.out.println(cushing.toString());  

    System.out.println(cushing.isResident("Nathalie"));
    System.out.println(cushing.isResident("Lara"));
    cushing.moveIn("Lily", "Charlotte");
    System.out.println(cushing.isResident("Charlotte"));
  }
}