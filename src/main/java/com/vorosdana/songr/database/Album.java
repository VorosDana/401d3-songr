package com.vorosdana.songr.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Album {

    @Id
    @GeneratedValue
    public long id;

    @OneToMany(mappedBy = "album")
    List<Song> trackList;

    public String title;
    public String artist;
    public int songCount;
    public int length; //seconds
    public String imageURL; // album art
}
