package com.perso.udemydemo.model;

import javax.persistence.*;

@Entity
@Table(name="Course", schema = "udemytest")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "chapterCount")
    private int chapterCount;

    public Course() {

    }

    public Course(Long id, String name, int chapterCount) {
        this.id = id;
        this.name = name;
        this.chapterCount = chapterCount;
    }

    public Course(String name, int chapterCount) {
        this.name = name;
        this.chapterCount = chapterCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChapterCount() {
        return chapterCount;
    }

    public void setChapterCount(int chapterCount) {
        this.chapterCount = chapterCount;
    }
}
