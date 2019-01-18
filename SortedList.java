package edu.kit.informatik;

public class SortedList {
  private int size = 0;
    
  private class List {
    int element;
    List next;
    
    public List(int element, List next) {
      this.element = element;
      this.next = next;
    }
    
    public void setNext(List next) {
      this.next = next;
    }
  }

  private List head;

  public SortedList() {
    this.head = null; // empty list
  }
  /** 
   * Adding an element and sorting it in ascending order.
   * @param number The element we want to add.
   */
  
  public void add(int number) {
    // When the list is empty
    if (this.head == null) {
      this.head = new List(number, null);
      size++;
      return;
    }
    // When the number is smaller than our element
    if (head.element > number) {
      this.head = new List(number, this.head);
      size++;
      return;
    }
    List a = this.head.next;
    List b = this.head;
    while (a != null) {
      if (a.element >= number) {
        b.next = new List(number, a);
        size++;
        return;
      }
      b = a;
      a = a.next;
    }
    b.next = new List(number, null);
    size++;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    // Checks if it's empty
    return head == null;
  }
  /**
   * Removing all elements of the list.
   */
  
  public void clear() {
    // Because of garbage collection this works. Size is set to 0.
    head = null;
    size = 0;
  }
  /**
   * Try to get an element at a specified index within the list.
   * @param index of the element.
   * @return The element at the index.
   */
  
  public int get(int index) {
    List l = this.head;
    List num = this.head;
    for (int i = 0; i < index; i++) {
      num = l.next;
    }
    return num.element;
  }
  /**
   * Get the index of a given element.
   * @param number The element we want to find the index for.
   * @return The index of the element we gave.
   */
  
  public int indexOf(int number) {
    int index = 0;
    for (List l = head; l != null; l = l.next) {
      if (l.element == number) {
        return index;
      }
      index++;
    }
    return -1;
  }
  /**
   * Get the last index of a number.
   * @param number The element we want to find the last index of.
   * @return The last index of the element we gave.
   */
  
  public int lastIndexOf(int number) {
    int index = -1;
    List l = this.head;
    for (int i = 0; l != null; i++, l = l.next) {
      if (l.element == number) {
        index = i;
      }
    }
    return index;
  }
  /**
   * Removes an element.
   * @param number The element we want to remove.
   * @return true if the element is in the list, otherwise false.
   */
  
  public boolean remove(int number) {
    List l = this.head;
    // To check if the first number is the one we want to remove
    if (l != null && l.element == number) {
      this.head = l.next;
      size--;
      return true;
    } else if (l == null) {
      return false;
    }
    // Checking the other numbers
    while (l.next != null) {
      if (l.next.element == number) {
        l.setNext(l.next.next);
        size--;
        return true;
      }
      l = l.next;
    }
    return false;
  }
  /**
   * Checks if an element is in the list.
   * @param number The element we want to check.
   * @return true if the element is in the list, otherwise false.
   */
  
  public boolean contains(int number) {
    for (List l = this.head; l != null; l = l.next) {
      if (l.element == number) {
        return true;
      }
    }
    return false;
  }
  
  public void quit() {
    return;
  }
  /**
   * Printing the list in the format that was asked.
   */
  
  @Override
  
  public String toString() {
    if (head == null) {
      return "[]";
    } else {
      String s = "[" + head.element;
      List list = head.next;
      while (list != null) {
        s += "," + list.element;
        list = list.next;
      }
      return s + "]";
    }
  }
}
