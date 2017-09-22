public class GroceryListLinked implements IGroceryList {
  
  GroceryNode head = null;
  int size = 0;
  
  GroceryListLinked() {}
  
  public boolean add(GroceryItem item) {
    GroceryNode newNode = new GroceryNode(item, head);
    head = newNode;
    return true;
  }
  public boolean checkHead(){
    if(head == null)
      return false;
    return true;
  }
  public boolean checkItem(String name){//checks if item exists in the list
    GroceryNode current = head;
    if(current.getData().name == name)
      return true;
    else{
      current = findPriorItem(name);
      if(current != null)
        return true;
      else
        return false;
    }
  }
  public GroceryNode findItem(String name){
    GroceryNode current = head;//finds the item for convenience
    while(current != null){
      if(current.getData().name == name)
        return current;
      current = current.getNext();
    }
    return current;
  }
  public GroceryNode findPriorItem(String name){
    GroceryNode current = head;//method useful for remove coz it finds the item before the itemToBeRemoved.
    while(current != null){
      if(current.getNext().getData().name == name)
        return current;
      current = current.getNext();
    }
    return current;
  }
  public boolean remove(String name) {
    GroceryNode current = head;
    if(checkHead() == false)//checking if list is empty
      return false; 
    
    if(current.getData().name == name){//this is for removing the head.
      head = current.next;
      return true;
      
    
    }else{  //this is for removing anynode in the middle.
      if(checkItem(name)){ //checkpoint for item existence
        current = findPriorItem(name);
        current.setNext(current.getNext().getNext());
        return true;
      }
      else return false; //this is if the item doesn't exist and returns false directly.
    }
  }
  
  public boolean markAsBought(String name) {
    GroceryNode current = findItem(name);
    if(current != null){
      current.getData().isBought = true;
      return true;
    }
    return false;
  }
  
   public void display() {
    GroceryNode current = head;
    System.out.println("Grocery Items: ");
    while(current != null){
      if(current.getData().isBought == true){
        System.out.println("[x] " + current.getData().name + " " + current.getData().quantity);
        current = current.getNext();
      }else{
        System.out.println("[ ] "+ current.getData().name + " " + current.getData().quantity);
        current = current.getNext();
      }
      }
  }
}

class GroceryNode {
  GroceryItem data;
  GroceryNode next;
  
  GroceryNode(GroceryItem data, GroceryNode next) {
    this.data = data;
    this.next = next;
  }
  
  public GroceryItem getData(){
    return data;
  }
  
  public void setData(GroceryItem data){
    this.data = data;
  }
  
  public GroceryNode getNext(){
    return next;
  }
  
  public void setNext(GroceryNode next){
    this.next = next;
  }
}
