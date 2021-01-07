public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList () {
    size = 0;
  }

  public int size () {
    return size;
  }

  public boolean add (String value) {
    Node newFinal = new Node (value);
    MyLinkedList linky = new MyLinkedList ();
    if (size() > 0) {
      end.setNext(newFinal);
      newFinal.setPrev(end);
      end = newFinal;
      size += 1;
      return true;
    }
    newFinal.setPrev(newFinal);
    newFinal.setNext(newFinal);
    end = newFinal;
    start = newFinal;
    size += 1;
    return true;
  }

  public void add (int index, String value) {
    Node newNode = new Node (value);
    Node next = start;
    int counter = 0;
    if (index == size()) {
      add(value);
      System.out.println(toString());
    }
    for (int i = 0; i < size() - 1; i++) {
      if (counter == index) {
        newNode.setPrev(next);
        newNode.setNext(next.getNext());
        next.setNext(newNode);
        next = newNode.getNext();
        next.setPrev(newNode);
        i = size();
        System.out.println(toString());
      } else {
        next = next.getNext();
        counter += 1;
      }
    }
    size += 1;
  }

  public String get (int index) {
    int counter = 0;
    Node nodeTrack = start;
    for (int i = 0; i < size(); i++) {
      if (index != counter) {
        nodeTrack = nodeTrack.getNext();
        counter += 1;
      } else {
        i = size();
      }
    }
    return nodeTrack.getData();
  }

  public String set(int index, String value) {
    int counter = 0;
    Node nodeTrack = start;
    Node nodeOld;
    for (int i = 0; i < size(); i++) {
      if (index != counter) {
        nodeTrack = nodeTrack.getNext();
        counter += 1;
      } else {
        i = size();
      }
    }
    nodeOld = nodeTrack;
    nodeTrack.setData(value);
    return nodeOld.getData();
  }

  public String toString() {
    Node nodeTrack = start;
    String outputStuff = "[";
    for (int i = 0; i < size(); i++) {
      outputStuff += nodeTrack.getData();
      nodeTrack = nodeTrack.getNext();
      outputStuff += ", ";
    }
    if (size() == 0) {
      return "[]";
    }
    outputStuff = outputStuff.substring(0, outputStuff.length() - 2);
    outputStuff += "]";
    return outputStuff;
  }
}