package servlets;

import com.google.gson.Gson;
import exception.TableIsEmptyException;
import model.Book;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import service.AdminController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/allbooks"})
public class BooksServlet extends HttpServlet {

    private ApplicationContext applicationContext;
    private AdminController bookService;
    private Gson gson;

    @Override
    public void init() throws ServletException {

        applicationContext =
                (ApplicationContext) getServletContext().getAttribute("spring-context");
        bookService = applicationContext.getBean(AdminController.class);

        gson = applicationContext.getBean(Gson.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setAttribute("books", bookService.getAllBooks());
            req.getRequestDispatcher("WEB-INF/pages/allbooks.jsp").forward(req, resp);
        } catch (TableIsEmptyException e) {
            e.printStackTrace();
            req.setAttribute("errorTitle", "ERROR");
            req.setAttribute("errorMsg", e);
            req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String bookName = req.getParameter("name");
        Book book = null;
        try {
            List<Book> books = bookService.getAllBooks();
            for (Book libraryBook : books) {
                if (libraryBook.getName().equals(bookName)) {
                    book = libraryBook;
                    break;
                }
            }
            if (book != null && !bookName.isEmpty()) {

                book.setName(bookName);
                bookService.updateBook(book);

                String answer = gson.toJson(book);
                resp.getWriter().print(answer);

            } else if (!bookName.isEmpty()) {

                book = new Book(bookName);
                Book newBook = bookService.createBook(book);

                String answer = gson.toJson(newBook);
                resp.getWriter().print(answer);
            }

        } catch (Exception e) {

            e.printStackTrace();
            resp.getWriter().printf("{\"errorTitle\":\"ERROR\",\"errorMsg\":\"%s\"}", e.getMessage());

        }


    }

}
