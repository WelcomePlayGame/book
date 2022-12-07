package ua.vadym.people_book.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;
    @Column(name = "year_production")
    private int year_production;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;


    public Book() {

    }

    public Book(String title, String author, int year_production) {
        this.title = title;
        this.author = author;
        this.year_production = year_production;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear_production() {
        return year_production;
    }

    public void setYear_production(int year_production) {
        this.year_production = year_production;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && year_production == book.year_production && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(person, book.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, year_production, person);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year_production=" + year_production +
                ", person=" + person +
                '}';
    }
}
