package ua.vadym.people_book.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_born")
    private int year_born;

    @OneToMany(mappedBy = "person")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
    org.hibernate.annotations.CascadeType.REFRESH})
    private List<Book> bookList;

    public Person() {
    }

    public Person(String name, int year_born) {
        this.name = name;
        this.year_born = year_born;
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

    public int getYear_born() {
        return year_born;
    }

    public void setYear_born(int year_born) {
        this.year_born = year_born;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year_born=" + year_born +
                ", bookList=" + bookList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && year_born == person.year_born && Objects.equals(name, person.name) && Objects.equals(bookList, person.bookList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year_born, bookList);
    }
}
