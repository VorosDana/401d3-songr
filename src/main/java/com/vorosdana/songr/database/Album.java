package com.vorosdana.songr.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.URL;

@Entity
public class Album {

    @Id
    @GeneratedValue
    public long id;

    public String title;
    public String artist;
    public int songCount;
    public int length; //seconds
    public String imageURL; // album art
}
