public class SLNode<T> {

    T data;
    SLNode<T> next;

    SLNode(T data){
        this.data = data;
        this.next = null;
    }
 @Override
    public String toString(){
        return (data + " ");
    }
}
