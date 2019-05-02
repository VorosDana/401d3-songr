package com.vorosdana.songr.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Song {

    @Id
    @GeneratedValue
    public long id;

    @ManyToOne
    public Album album;

    public String title;
    public String artist;
    public int trackNumber;
    public int length; //seconds
}
