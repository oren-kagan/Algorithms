public class DLNode<T> {

    T data;
    DLNode<T> next;
    DLNode<T> prev;

    DLNode(T data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    @Override
    public String toString(){
        return (data + " ");
    }
}
