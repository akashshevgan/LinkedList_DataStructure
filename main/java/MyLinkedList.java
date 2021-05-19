public class MyLinkedList<K extends Comparable> {

    public INode head;
    public INode tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(INode newNode) {
        if (this.tail == null)
            this.tail = newNode;
        if (this.head == null)
            this.head = newNode;
        else {
            INode tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);
        }
    }

//print linked list
    public void printMyNodes(){
        StringBuffer myNodes = new StringBuffer("My Nodes: ");
        INode tempNode = head;
        while (tempNode.getNext()!=null){
            myNodes.append(tempNode.getKey());
            if(!tempNode.equals(tail))
                myNodes.append("->");
            tempNode=tempNode.getNext();
        }
        myNodes.append(tempNode.getKey());
        System.out.println(myNodes);
    }

    public void append(INode newNode) {
        if(this.head == null)
            this.head = newNode;
        if(this.tail == null)
            this.tail = newNode;
        else {
            INode tempNode = this.tail;
            this.tail = newNode;
            tempNode.setNext(newNode);
        }
    }

    public void insert(INode myNode, INode newNode) {
        this.head.setNext(myNode);
        myNode.setNext(newNode);
    }

    //delete first element in linkedlist
    public INode pop() {
        INode  tempNode = this.head;
        this.head = head.getNext();
        return tempNode;
    }

    public INode popLast() {
        INode tempNode = head;
        while (!tempNode.getNext().equals(tail)) {
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tempNode = null;
        return tempNode;
    }

    public void search(INode myNode){   //  search given element
        INode tempNode = head;
        while (tempNode.getNext()!=myNode){
            tempNode=tempNode.getNext();
        }
        tempNode = tempNode.getNext();
        System.out.println(" Element is = " +tempNode.getKey());
    }

    public void delete(INode deleteNode) {
        INode tempNode1 = head;
        while (tempNode1.getNext() != deleteNode) {
            tempNode1 = tempNode1.getNext();
        }
        INode tempNode2 = tempNode1;
        tempNode1 = tempNode1.getNext();
        tempNode1 = tempNode1.getNext();
        tempNode2.setNext(tempNode1);
    }

    public void size(INode head) {
        int count = 0;
        INode node = head;
        while (node != null) {
            count++;
            node = node.getNext();
        }
        System.out.println("Size : " + count);
    }
    // uc 10 Sorted LinkedList
    public void sortedLinkedList(INode<K> newNode) {
        INode tempNode = head;
        INode prevNode = null;
        while (tempNode != null && (newNode.getKey()).compareTo((K) tempNode.getKey()) > 0) {
            prevNode = tempNode;
            tempNode = tempNode.getNext();
        }
        if (prevNode == null) {
            this.head = newNode;
        } else {
            prevNode.setNext(newNode);
        }
        newNode.setNext(tempNode);
        tempNode =head;
        while (tempNode!=null){
            this.tail=tempNode;
            tempNode=tempNode.getNext();
        }
    }
}
