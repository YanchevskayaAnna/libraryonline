package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
@NamedQuery(name = "Book.getAll", query = "SELECT b from Book b")
public class Book {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

//    @ManyToMany(fetch = FetchType.LAZY)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bookauthors",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")})
    private List<Author> authorList;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, List<Author> authorList) {
        this.name = name;
        this.authorList = authorList;
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

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    @Override
    public String toString() {
        return name;
    }
}