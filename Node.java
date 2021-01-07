public class Node {
  private String data;
  private Node next,prev;

  public Node (String value) {
    data = value;
  }

  public String getData () {
    return data;
  }

  public Node getNext () {
    return next;
  }

  public Node getPrev () {
    return prev;
  }

  public String setData (String newData) {
    String a = data;
    data = newData;
    return a;
  }

  public Node setNext (Node newNext) {
    Node a = next;
    data = newNext;
    return a;
  }

  public Node setPrev (Node newPrev) {
    Node a = prev;
    data = newPrev;
    return a;
  }
}
