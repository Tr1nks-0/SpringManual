package edu.hneu.kpp.lab2.spring.dao.entity;

import javax.persistence.*;
import java.util.Set;

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
    @ManyToMany(mappedBy = "bookEntities", fetch = FetchType.EAGER)
    private Set<PublishingHouseEntity> publishingHouseEntities;

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

    public AuthorEntity getAuthorEntity() {
        return authorEntity;
    }

    public void setAuthorEntity(AuthorEntity authorEntity) {
        this.authorEntity = authorEntity;
    }

    public Set<PublishingHouseEntity> getPublishingHouseEntities() {
        return publishingHouseEntities;
    }

    public void setPublishingHouseEntities(Set<PublishingHouseEntity> publishingHouseEntities) {
        this.publishingHouseEntities = publishingHouseEntities;
    }

    @Override
    public String toString() {
        return "BookEntity [id=" + id + ", title=" + title + ", author=" + authorEntity.toString() + "]";
    }
}
