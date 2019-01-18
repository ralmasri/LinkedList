package edu.kit.informatik;

import edu.kit.informatik.Terminal;

public class Main {
  /**
   * Main method to run my program.
   */
  
  public static void main(String [] args) {
    SortedList list = new SortedList();
    String input = Terminal.readLine();
    while (!input.equals("quit")) {
      String[] pos = input.split(" ", -1);
      switch (pos[0]) {
        case "add":
          int number = Integer.parseInt(pos[1]);
          list.add(number);
          break;
        case "print":
          Terminal.printLine(list.toString());
          break;
        case "size":
          Terminal.printLine(list.size());
          break;
        case "isEmpty":
          Terminal.printLine(list.isEmpty());
          break;
        case "clear":
          list.clear();
          break;
        case "get":
          int index = Integer.parseInt(pos[1]);
          Terminal.printLine(list.get(index));
          break;
        case "indexOf":
          int number1 = Integer.parseInt(pos[1]);
          Terminal.printLine(list.indexOf(number1));
          break;
        case "lastIndexOf":
          int number2 = Integer.parseInt(pos[1]);
          Terminal.printLine(list.lastIndexOf(number2));
          break;
        case "remove":
          int number3 = Integer.parseInt(pos[1]);
          Terminal.printLine(list.remove(number3));
          break;
        case "contains":
          int number4 = Integer.parseInt(pos[1]);
          Terminal.printLine(list.contains(number4));
          break;
        default: 
          String s = "command not found";
          Terminal.printError(s);
      }
      input = Terminal.readLine();
    }
    if (input.equals("quit")) {
      list.quit();
    }
  }
}
