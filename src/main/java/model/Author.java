package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
@NamedQuery(name = "Author.getAll", query = "SELECT a from Author a")
public class Author {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "authorList", fetch = FetchType.LAZY)
    private List<Book> bookList;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public Author(String name, List<Book> bookList) {
        this.name = name;
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return name;
    }
}
