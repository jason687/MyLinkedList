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
    newFinal.setPrev(null);
    newFinal.setNext(null);
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
    } else {
      if (index == 0) {
        start.setPrev(newNode);
        newNode.setNext(start);
        newNode.setPrev(null);
        start = newNode;
        size += 1;
      } else {
        for (int i = 0; i < size() - 1; i++) {
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

  public String get (int index) {
    int counter = 0;
    Node nodeTrack = start;
    if (index >= size()) {
      throw new IndexOutOfBoundsException ("no");
    }
    for (int i = 0; i < size(); i++) {
      if (index != counter) {
        nodeTrack = nodeTrack.getNext();
        counter += 1;
      } else {
        i += size();
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
