public class GroceryListLinked implements IGroceryList {
  
  GroceryNode head = null;
  int size = 0;
  
  GroceryListLinked() {}
  
  public boolean add(GroceryItem item) {
    GroceryNode newNode = new GroceryNode(item, head);
    head = newNode;
    size++;
    return true;
  }
  
  
  public boolean checkHead(){
    if(head == null)
      return false;
    return true;
  }
  
  // finds the item for convenience
  public GroceryNode findItem(String name){
    GroceryNode current = head;
    while(current != null){
      if(current.getData().name.equals(name))
        return current;
      current = current.getNext();
    }
    return current;
  }
  
  // method useful for remove coz it finds the item before the itemToBeRemoved.
  public GroceryNode findPriorItem(String name){
    GroceryNode current = head;
    while(current != null){
      if(current.getNext().getData().name == name)
        return current;
      current = current.getNext();
    }
    return current;
  }
   public boolean remove(String name) {
    GroceryNode current = head;
    GroceryNode prev = head;
    if(checkHead() == false) //checking if list is empty
      return false; 
    
    if(current.getData().name.equals(name)){ //this is for removing the head.
      head = current.next;
      prev = null;
      size--;
      return true;
    }else{  //this is for removing anynode in the middle.
      if(findItem(name)!= null){ //checkpoint for item existence
        prev = findItem(name);
        current = findPriorItem(name);
        current.setNext(current.getNext().getNext());
        prev = null;
        size--;
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
     System.out.println(current.getData().toString());
     current = current.next;
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
