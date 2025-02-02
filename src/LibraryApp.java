import java.util.ArrayList;

class LibraryResource {}
class Book extends LibraryResource { }
class EBook extends Book { }

public class LibraryApp {
    public static void main(String[] args) {
        ArrayList<LibraryResource> resources = new ArrayList<>();
        
        // sample data
        resources.add(new Book());
        resources.add(new EBook());
    }
}
