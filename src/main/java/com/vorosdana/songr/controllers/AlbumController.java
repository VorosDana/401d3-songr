package com.vorosdana.songr.controllers;

import com.vorosdana.songr.AlbumNotFoundException;
import com.vorosdana.songr.database.Album;
import com.vorosdana.songr.database.AlbumReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    AlbumReposity data;


    @GetMapping("/{id}")
    public Album getAlbum(@PathVariable long id) {
        Optional<Album> albadoo = this.data.findById(id);
        if (albadoo.isPresent()) {
            return albadoo.get();
        } else {
            throw new AlbumNotFoundException();
        }
    }

    @PostMapping("/")
    public Album postAlbum(@RequestBody Album album) {
        album = this.data.save(album);

        return album;
    }

}
