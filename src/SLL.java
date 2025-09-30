/**
 * Class to implement a singly linked list
 *
 * @author Caitlyn Kim
 * @version Fall 2025
 */

public class SLL<T> implements Phase1SLL<T>, Phase2SLL<T>, Phase4SLL<T>{

  /** The head node of the list */
  private NodeSL<T> head;
  /** The tail node of the list */
  private NodeSL<T> tail;

  /** Constructs an empty linked list by making head and tail null */
  public SLL(){
    this.head = null;
    this.tail = null;
  }

  /** Constructs a deep copy of a linked list object by looping through the list and copying each node */
  public SLL(SLL<T> orig) {
    if (orig.head == null) {
      head = tail = null;
    } else {
      NodeSL<T> pos = orig.head;
      head = new NodeSL<T>(pos.getData(), null);
      tail = head;
      for (pos = orig.head.getNext(); pos != null; pos = pos.getNext()) {
        tail.setNext(new NodeSL<T>(pos.getData(), null));
        tail = tail.getNext();
      }
    }


  }

  /** 
   *  Accessor for head node
   *  @return the head node
   */
  public NodeSL<T> getHead(){
    return head;
  }

  /** 
   *  Accessor for tail node
   *  @return the tail node
   */
  public NodeSL<T> getTail(){
    return tail;
  }

  /** 
   *  Determines whether a list is empty
   *  @return T/F is the list empty?
   */
  public boolean isEmpty(){
    return head == null;
  }

  /** 
   *  Inserts the given item at the head of the list
   *  @param v item to insert 
   */
  public void addFirst(T v){
    if (isEmpty()) {
      head = new NodeSL<T>(v, null); //create node with data and pointing to null
      tail = head;
    } else {
        NodeSL<T> newNode = new NodeSL<T>(v, head); //create node with data pointing to current head
        head = newNode;
    }
  }
  
  /** Converts to a string representation */
  public String toString(){
    
    if (isEmpty()) {
      return "[]";
    }

    //StringBuilder allows for mutuable sequence of characters
    StringBuilder nodeData = new StringBuilder("[");

    //NodeSL<T> current = head;

    for (NodeSL<T> current = this.head; current.getNext() != null; current = current.getNext()) {
      nodeData.append(current.getData());
      current = current.getNext(); //saves next node into current

      if (current != null) {
        nodeData.append(", ");
      }
    }

    nodeData.append("]");
    return nodeData.toString();
  }

  /** 
   *  Inserts the given item at the tail of the list
   *  @param item to insert 
   */
  public void addLast(T v){
    NodeSL<T> newTail = new NodeSL<T>(v, null);

    if (isEmpty()) {
      head = new NodeSL<T>(v, null); //create node with data and pointing to null
      tail = head;
    }

    NodeSL<T> oldTail = head;
    while (oldTail.getNext() != null) {
      oldTail = oldTail.getNext();
    }
    oldTail.setNext(newTail);
  }

  /** 
   *  Inserts the given item after the specified node
   *  @param here node to insert after
   *  @param v item to insert 
   */
  public void addAfter(NodeSL<T> here, T v){
    
    if (isEmpty()) {
      throw new MissingElementException(); //"Can't insert an item after a node in an empty list."
    }

    if (here == null) {
      throw new IllegalArgumentException("Can't insert an item after a node that is null.");
    }

    //creates new node that points to node after "here"
    NodeSL<T> newNode = new NodeSL<T>(v, here.getNext());
    
    //"here" node points to new node created
    here.setNext(newNode);

    //if new node is inserted after previous tail, new node becomes tail
    if (here.getNext() == null) {
      tail = newNode;
    }
  }

  /** 
   *  Removes the given item from the head of the list
   *  @return v item removed
   */
  public T removeFirst(){

    //if list is empty throw MissingElementException
    if (isEmpty()) {
      throw new MissingElementException();
    }

    //if list has one node, delete it and return null
    if (head.getNext() == null) {
      return null;
    }    

    NodeSL<T> temp = head;
    head = head.getNext();
    T removedItem = temp.getData();
    temp = null;
    return removedItem;
  }

  /** 
   *  Removes the given item from the tail of the list
   *  @return item removed
   */
  public T removeLast(){

    //if list is empty throw MissingElementException
    if (isEmpty()) {
      throw new MissingElementException();
    }

    //if list has one node, delete it and return null
    if (head.getNext() == null) {
      return null;
    }

    NodeSL<T> secondLast = head;

    while (secondLast.getNext().getNext() != null) {
      secondLast = secondLast.getNext(); //saves next node into secondLast
    }
    T removedItem = secondLast.getNext().getData();
    secondLast.setNext(null);
    tail = secondLast;
    return removedItem;
  }

  /** 
   *  Removes the node after the given position
   *  @param here marks position to remove after
   *  @return item removed
   */
  public T removeAfter(NodeSL<T> here){
    if (isEmpty()) {
      throw new MissingElementException(); //"Can't remove an item after a node in an empty list."
    }

    if (here == null) {
      throw new IllegalArgumentException("Can't remove an item after a node that is null.");
    }

    if (here.getNext() == null){
      throw new IllegalArgumentException("There is no node to remove after the given node.");
    }

    NodeSL<T> nodeToRemove = here.getNext();
    T removedItem = nodeToRemove.getData();
    here.setNext(nodeToRemove.getNext());

    //if node that is removed is the tail, "here" node becomes tail
    if (nodeToRemove == tail) {
      tail = here;
    }

    return removedItem;
  }

  /**
   *  Returns a count of the number of elements in the list
   *  @return current number of nodes
   */
  public int size(){
    int count = 0;

    NodeSL<T> currentNode = head;

    //iterates through all elements and counts them
    while (currentNode != null){
      count ++;
      currentNode.getNext();
    }

    return count;
  }

  /** 
   *  Makes a copy of elements from the original list
   *  @param here  starting point of copy
   *  @param n  number of items to copy
   *  @return the copied list
   */
  public SLL<T> subseqByCopy(NodeSL<T> here, int n){
    SLL<T> subSeqList = new SLL<T>();
    
    NodeSL<T> current = here; //begin at starting point
    int counter = 0; //count how many nodes we pass
    int nodesCopied = 0; //count how many nodes are copied to subsequence

    while (current != null && counter < n) {
      counter ++;
      current = current.getNext();
    }

    if (counter < n) {
        throw new SelfInsertException();
    }
    
    current = here; //restart current to given starting point

    while (nodesCopied < n) {
      subSeqList.addLast(current.getData());
      current = current.getNext();
      nodesCopied ++;
    }

    return subSeqList;

  }

  /**
   *  Places copy of the provided list into this after the specified node.
   *  @param list  the list to splice in a copy of
   *  @param afterHere  marks the position in this where the new list should go
   */
  public void spliceByCopy(SLL<T> list, NodeSL<T> afterHere){
    SLL<T> copiedList  = new SLL<T>(list); //deep copy of list
    
    if (afterHere == null) {
      copiedList.getTail().setNext(this.head); //connects tail of copiedList to the current head of this
      this.head = copiedList.getHead(); //updates this.head to point to the head of copiedList
    } else {
      NodeSL<T> whatComesNext = afterHere.getNext();
      copiedList.getTail().setNext(whatComesNext);
      afterHere.setNext(copiedList.getHead());
    }

  }

  /** 
   *  Extracts a subsequence of nodes and returns them as a new list
   *  @param afterHere  marks the node just before the extraction
   *  @param toHere  marks the node where the extraction ends
   *  @return  the new list
   */
  public SLL<T> subseqByTransfer(NodeSL<T> afterHere, NodeSL<T> toHere){
    SLL<T> bob = new SLL<T>();
    return bob;
  }

  /** 
   *  Takes the provided list and inserts its elements into this
   *  after the specified node.  The inserted list ends up empty.
   *  @param list  the list to splice in.  Becomes empty after the call
   *  @param afterHere  Marks the place where the new elements are inserted
   */
  public void spliceByTransfer(SLL<T> list, NodeSL<T> afterHere){

  }


}
