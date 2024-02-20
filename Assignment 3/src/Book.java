public class Book {


    String Title = "";
    String Author = "";
    double Price = 0;

    public Book(String Title, String Author, double Price){
        this.Title = Title;
        this.Author = Author;
        this.Price = Price;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public double getPrice() {
        return Price;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String toString(){
        if (Title != "") {
            return ("{bookName: " + Title + ", author: " + Author + ", price: " + Price + "}");
        }
        return "";
    }
}
