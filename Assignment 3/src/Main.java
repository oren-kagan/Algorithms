public class Main<T> {
    public static void main(String[] args) {
        AList booksList = new AList();
        AListTest(booksList);
        SLList booksSLL = new SLList();
        SLListTest(booksSLL);
        DLList booksDLL = new DLList();
        DLListTest(booksDLL);
    }

    static void AListTest(AList list){
        System.out.println("AList Test");
        Book book1 = new Book("The Lord of the Rings: Fellowship of the Ring", "J. R. R. Tolkien", 31.99);
        Book book2 = new Book("Jujutsu Kaisen, Vol. 7", "Gege Akutami", 8.79);
        System.out.println(list.toString());
        list.listAdd(book1);
        list.listAdd(book1);
        list.listAdd(book2);
        list.listAdd(book1);
        System.out.println(list.toString());
        list.listRemove(1);
        System.out.println(list.toString());
    }
    static void SLListTest(SLList list){
        System.out.println("SLList Test");
        System.out.println(list.toString());
        Book book1 = new Book("The Lord of the Rings: Fellowship of the Ring", "J. R. R. Tolkien", 31.99);
        Book book2 = new Book("Jujutsu Kaisen, Vol. 7", "Gege Akutami", 8.79);
        list.listAdd(book1);
        list.listAdd(book1);
        list.listAdd(book2);
        list.listAdd(book1);
        System.out.println(list.toString());
        list.listRemove(book1);
        System.out.println(list.toString());
    }
    static void DLListTest(DLList list){
        System.out.println("DLList Test");
        System.out.println(list.toString());
        Book book1 = new Book("The Lord of the Rings: Fellowship of the Ring", "J. R. R. Tolkien", 31.99);
        Book book2 = new Book("Jujutsu Kaisen, Vol. 7", "Gege Akutami", 8.79);
        list.listAdd(book1);
        list.listAdd(book1);
        list.listAdd(book2);
        list.listAdd(book1);
        System.out.println(list.toString());
        list.listRemove(book1);
        System.out.println(list.toString());
    }
}