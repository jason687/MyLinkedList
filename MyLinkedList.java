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
    return true;
  }

  public void add (int index, String value) {
    Node newNode = new Node (value);
    Node next = start;
    int counter = 0;
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
  }

  public String get (int index) {
    Node nodeTrack = start;
    if (index >= size()) {
      throw new IndexOutOfBoundsException ("no");
    }
    for (int i = 0; i < size(); i++) {
      if (index == i) {
        i += size();
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
    }
    if (outputStuff.length() < 2) {
      return "[]";
    }
    outputStuff = outputStuff.substring(0, outputStuff.length() - 2);
    outputStuff += "]";
    return outputStuff;
  }

  public String remove (int index) {
    Node tempNodeBefore;
    Node tempNodeAfter;
    Node tempNode;
    if (size() == 0) {
      throw new IndexOutOfBoundsException ("can't delete anything when there is nothing");
    }
    if (index >= size() || index < 0) {
      throw new IndexOutOfBoundsException ("no");
    }
    if (size() == 1) {
      start = null;
      end = null;
      size = 0;
      return "[]";
    }
    if (index == 0) {
      tempNode = start.getNext();
      tempNode.setPrev(null);
      start = tempNode;
      size -= 1;
      return toString();
    }
    if (index == size() - 1) {
      tempNode = end.getPrev();
      tempNode.setNext(null);
      end = tempNode;
      size -= 1;
      return toString();
    }
    tempNode = start;
    for (int i = 0; i < size(); i++) {
      if (i == index) {
        tempNodeBefore = tempNode.getPrev();
        tempNodeAfter = tempNode.getNext();
        tempNodeBefore.setNext(tempNodeAfter);
        tempNodeAfter.setPrev(tempNodeBefore);
        tempNode.setNext(null);
        tempNode.setPrev(null);
        size -= 1;
        i += size();
      } else {
        tempNode = tempNode.getNext();
      }
    }
    return toString();
  }

  public void extend (MyLinkedList a) {
    if (a.size() == 0) {
      return;
    }
    if (size() == 0) {
      start = a.start;
      end = a.start;
      size += 1;
      a.remove(0);
      if (a.size() == 0) {
        return;
      }
    }
    end.setNext(a.start);
    a.start.setPrev(end);
    size += a.size();
    int aSize = a.size();
    for (int i = 0; i < aSize; i++) {
      a.remove(0);
    }
  }
}
