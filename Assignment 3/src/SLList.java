public class SLList<T> {

    private SLNode<T> head;
    private int length = 0;

    SLList(){
        this.head = null;
    }

    void listAdd(T data){
        SLNode<T> temp = new SLNode<T>(data);
        if(this.head == null){
            head = temp;
        }
        else{
            SLNode<T> index = head;
            while (index.next != null){
                index = index.next;
            }
            index.next = temp;
        }
        length++;
    }

    void listRemove(T k){
        SLNode<T> curr = head;
        boolean nodePresent = false;
        if (head.data == k){
            head = head.next;
            nodePresent = true;
        }
        while(curr.next != null && curr.next.data != k){
            curr = curr.next;
        }
        if (curr.next != null){
            curr.next = curr.next.next;
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
        SLNode<T> curr = head;
        String output = "";
        while (curr != null){
            output += curr.toString() + "\n";
            curr = curr.next;
        }
        return output;
    }
}
