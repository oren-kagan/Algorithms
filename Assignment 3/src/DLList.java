public class DLList <T>{

    private DLNode<T> head;
    private int length = 0;
    DLList(){
        this.head = null;
    }
    void listAdd(T data){
        DLNode<T> temp = new DLNode<T>(data);
        DLNode<T> index = new DLNode<T>(null);
        if(this.head == null){
            head = temp;
        }
        else{
            index = head;
            while (index.next != null){
                index = index.next;
            }
            index.next = temp;
            temp.prev = index;
        }
        length++;
    }

    void listRemove(T k){
        DLNode<T> curr = head;
        DLNode<T> temp = new DLNode<T>(null);
        boolean nodePresent = false;
        if (head.data == k){
            head = head.next;
            head.prev = null;
            nodePresent = true;
        }
        while(curr.next != null && curr.next.data != k){
            curr = curr.next;
        }
        if (curr.next != null){
            curr.next = curr.next.next;
            curr.next.prev = curr;
            nodePresent = true;
        }
        if (!nodePresent){
            System.out.println("Node not found.");
        }
    }
    public String toString(){
        if(length == 0){
            return "Empty List\n";
        }
        DLNode<T> curr = head;
        String output = "";
        while (curr != null){
            output += curr.toString() + "\n";
            curr = curr.next;
        }
        return output;
    }
}
