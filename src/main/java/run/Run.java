package run;

import exception.TableIsEmptyException;
import factory.ApplicationContextFactory;
import model.Author;
import model.Book;
import org.springframework.context.ApplicationContext;
import service.AdminController;

import java.util.Arrays;
import java.util.List;

public class Run {

    public static void main(String[] args)  {

        ApplicationContext applicationContext = ApplicationContextFactory.getInstance();

        AdminController bookService = applicationContext.getBean(AdminController.class);

        try {
            bookService.getAllAuthors();
        } catch (TableIsEmptyException e) {
            try {
                List<Author> authorList = createAuthors(bookService);
                createBooks(bookService, authorList);
            } catch (TableIsEmptyException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static List<Book> createBooks(AdminController adminController, List<Author> authors) throws TableIsEmptyException {
    /*    Ayn Rand
        1936 We the Living
        1943 The Fountainhead
        1957 Atlas Shrugged

        Jerome David "J. D." Salinger
        1951  The Catcher in the Rye

        1928
        I. Ilf and E. Petrov «The Twelve Chairs"*/

        Book book1 = new Book("The Catcher in the Ry", Arrays.asList(authors.get(1)));
        adminController.createBook(book1);

        Book book2 = new Book("We the Living", Arrays.asList(authors.get(0)));
        adminController.createBook(book2);

        Book book3 = new Book("The Fountainhead", Arrays.asList(authors.get(0)));
        adminController.createBook(book3);

        Book book4 = new Book("Atlas Shrugged", Arrays.asList(authors.get(0)));
        adminController.createBook(book4);

        Book book5 = new Book("The Twelve Chairs", Arrays.asList(authors.get(2), authors.get(3)));
        adminController.createBook(book5);

        return adminController.getAllBooks();
    }

    private static List<Author> createAuthors(AdminController adminController) throws TableIsEmptyException {

        /*
        Ayn Rand
        Jerome David "J. D." Salinger
        I. Ilf and E. Petrov */

        Author author1 = new Author("Ayn Rand");
        adminController.createAuthor(author1);

        Author author2 = new Author("Jerome Salinger");
        adminController.createAuthor(author2);

        Author author3 = new Author("I. Ilf");
        adminController.createAuthor(author3);

        Author author4 = new Author("E. Petrov");
        adminController.createAuthor(author4);

        return adminController.getAllAuthors();
    }


}
