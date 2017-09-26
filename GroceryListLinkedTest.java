import junit.framework.TestCase;

public class GroceryListLinkedTest extends TestCase {
  GroceryListLinked gll = new GroceryListLinked();
    GroceryItem a = new GroceryItem("Milk", 1);
    GroceryItem b = new GroceryItem("Sugar", 2);
    GroceryItem c = new GroceryItem("Spice", 3);
    GroceryItem d = new GroceryItem ("Rice", 4);
    GroceryItem e = new GroceryItem("Meat", 5);
    GroceryItem f = new GroceryItem("Meat", 6);
    GroceryItem g = new GroceryItem("Potato", 7);
    GroceryItem h = new GroceryItem("Tomato", 8);
    GroceryItem i = new GroceryItem("Orange", 9);
    GroceryItem j = new GroceryItem("Apple", 10);
    GroceryItem k = new GroceryItem("Cabbage", 11);
    GroceryItem l = new GroceryItem("Carrot", 12);
    GroceryItem m = new GroceryItem("Soap", 13);
    GroceryItem n = new GroceryItem("Shampoo", 14);
   

  public void testAddLessThanTen() {
    assertTrue(gll.add(a));
    assertTrue(gll.add(b));
    assertTrue(gll.add(c));
    assertTrue(gll.add(d));
    assertTrue(gll.add(e));
    assertTrue(gll.add(f));
    assertTrue(gll.add(g));
    assertTrue(gll.add(h));
    assertTrue(gll.add(i));
    assertTrue(gll.add(j)); 
  }

  public void testRemoveUnexistingItem(){ 
    gll.add(a);
    gll.add(b);
    assertFalse(gll.remove(c.name));
  }
  public void testRemoveFromEmptyList(){
    assertFalse(gll.remove(a.name));
  }
  public void testRemoveFirst(){
    gll.add(a);
    gll.add(b);
    gll.add(c);
    gll.add(d);
    gll.add(e);
    assertTrue(gll.remove(e.name));
  }
  public void testRemoveMid(){
    gll.add(a);
    gll.add(b);
    gll.add(c);
    gll.add(d);
    gll.add(e);
    assertTrue(gll.remove(c.name)); 
  }
  public void testRemoveLast(){ 
    gll.add(a);
    gll.add(b);
    gll.add(c);
    gll.add(d);
    gll.add(e);
    assertTrue(gll.remove(e.name));
  }
  
  public void testRemoveOneElement(){
    gll.add(a);
    assertTrue(gll.remove(a.name));
  }
  public void testIsBought(){
    gll.add(a);
    gll.add(b);
    gll.add(c);
    gll.add(d);
    gll.add(n);
    assertTrue(gll.markAsBought("Milk")); 
    assertTrue(gll.markAsBought("Shampoo"));
  }

}