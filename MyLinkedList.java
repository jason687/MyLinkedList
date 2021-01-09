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
    System.out.println(value);
    System.out.println(size());
    if (size() > 0) {
      end.setNext(newFinal);
      newFinal.setPrev(end);
      end = newFinal;
      size += 1;
    } else {
      newFinal.setPrev(null);
      newFinal.setNext(null);
      end = newFinal;
      start = newFinal;
      size += 1;
    }
    System.out.println(size());
    return true;
  }

  public void add (int index, String value) {
    Node newNode = new Node (value);
    Node next = start;
    int counter = 0;
    System.out.println(value);
    System.out.println(size());
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException ("no");
    } else {
      if (index == size()) {
        add(value);
      } else {
        if (index == 0) {
          start.setPrev(newNode);
          newNode.setNext(start);
          newNode.setPrev(null);
          start = newNode;
          size += 1;
        } else {
          for (int i = 0; i < size(); i++) {
            if (counter == index) {
              next = next.getPrev();
              newNode.setPrev(next);
              newNode.setNext(next.getNext());
              next.setNext(newNode);
              next = newNode.getNext();
              next.setPrev(newNode);
              i = size();
            } else {
              next = next.getNext();
              counter += 1;
            }
          }
          size += 1;
        }
      }
    }
    System.out.println(size());
  }

  public String get (int index) {
    Node nodeTrack = start;
    if (index >= size()) {
      throw new IndexOutOfBoundsException ("no");
    }
    for (int i = 0; i < size(); i++) {
      if (index == i) {
        i += size();
        System.out.println(nodeTrack.getData());
      } else {
        nodeTrack = nodeTrack.getNext();
      }
    }
    return nodeTrack.getData();
  }

  public String set(int index, String value) {
    int counter = 0;
    Node nodeTrack = start;
    String dataOld;
    for (int i = 0; i < size(); i++) {
      if (index != counter) {
        nodeTrack = nodeTrack.getNext();
        counter += 1;
      } else {
        i = size();
      }
    }
    dataOld = nodeTrack.getData();
    nodeTrack.setData(value);
    return dataOld;
  }

  public String toString() {
    String outputStuff = "[";
    if (size() == 0) {
      return "[]";
    }
    for (int i = 0; i < size(); i++) {
      outputStuff += get(i);
      outputStuff += ", ";
      System.out.println(outputStuff);
    }
    if (outputStuff.length() < 2) {
      return "[]";
    }
    outputStuff = outputStuff.substring(0, outputStuff.length() - 2);
    outputStuff += "]";
    return outputStuff;
  }

  public String toStringReversed() {
    String outputStuff = "[";
    if (size() == 0) {
      return "[]";
    }
    for (int i = size() - 1; i >= 0; i--) {
      outputStuff += get(i);
      outputStuff += ", ";
      System.out.println(outputStuff);
    }
    if (outputStuff.length() < 2) {
      return "[]";
    }
    outputStuff = outputStuff.substring(0, outputStuff.length() - 2);
    outputStuff += "]";
    return outputStuff;
  }

}
