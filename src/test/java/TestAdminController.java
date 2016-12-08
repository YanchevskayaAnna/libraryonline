
import exception.TableIsEmptyException;
import model.Author;
import model.Book;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.AdminController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/app-test-context.xml"})
public class TestAdminController {

    @Autowired
    private AdminController adminController;

//    @Before
//    public void beforeTest() throws TableIsEmptyException {
//
//        //AUTHORS
//        List<Author> authors = createAuthors();
//
//        //BOOKS
//        List<Book> books = createBooks(authors);
//
//    }

//    @After
//    public void afterTest() {
//
//        adminController.deleteAllAuthors();
//        adminController.deleteAllBooks();
//
//    }

    private List<Book> createBooks(List<Author> authors) throws TableIsEmptyException {
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

    private List<Author> createAuthors() throws TableIsEmptyException {

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

    @Test
    public void getAllBooks() throws TableIsEmptyException {

        List<Book> bookList = adminController.getAllBooks();
        Assert.assertNotNull(bookList);

    }

    @Test
    public void getBooksByName() throws TableIsEmptyException {

        List<Book> bookList = adminController.getBooksByName("We the Living");
        Assert.assertNotNull(bookList);
        Assert.assertEquals(1, bookList.size());

    }

    @Test
    public void getBooksByAuthor() throws TableIsEmptyException {

        Author author = new Author("Ayn Rand");
        List<Book> bookList = adminController.getBooksByAuthor(author);
        Assert.assertNotNull(bookList);
        Assert.assertEquals(3, bookList.size());

    }

    @Test
    public void getBookByAuthorName() throws TableIsEmptyException {

        Author author = new Author("Ayn Rand");
        Book book = adminController.getBookByAuthorName(author, "We the Living");
        Assert.assertNotNull(book);
        Assert.assertEquals("We the Living", book.getName());

    }

}
