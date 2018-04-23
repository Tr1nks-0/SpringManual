package edu.hneu.kpp.lab2.spring.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "title")
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private AuthorEntity authorEntity;

    public BookEntity() {
    }

    public BookEntity(String title, AuthorEntity authorEntity) {
        this.title = title;
        this.authorEntity = authorEntity;
    }

    public Integer getId() {
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

    public AuthorEntity getAuthor() {
        return authorEntity;
    }

    public void setAuthor(AuthorEntity author) {
        this.authorEntity = author;
    }

    @Override
    public String toString() {
        return "BookEntity [id=" + id + ", title=" + title + ", author=" + authorEntity.toString() + "]";
    }
}
