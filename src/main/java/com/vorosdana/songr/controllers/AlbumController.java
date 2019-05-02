package com.vorosdana.songr.controllers;

import com.vorosdana.songr.AlbumNotFoundException;
import com.vorosdana.songr.SongNotFoundException;
import com.vorosdana.songr.database.Album;
import com.vorosdana.songr.database.AlbumReposity;
import com.vorosdana.songr.database.Song;
import com.vorosdana.songr.database.SongRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    AlbumReposity albumReposity;

    @Autowired
    SongRepository songRepository;

    @GetMapping("")
    public String getAllAlbums(Model model) {
        List<Album> albums = albumReposity.findAll();

        model.addAttribute("albums", albums);

        return "albumList";
    }

    @GetMapping("/{id}")
    public String getAlbum(@PathVariable long id, Model model) {
        Optional<Album> albadoo = this.albumReposity.findById(id);
        if (albadoo.isPresent()) {
            List<Song> songs = songRepository.findAll();

            model.addAttribute("album", albadoo.get());
            model.addAttribute("songs", songs);

            return "oneAlbum";
        } else {
            throw new AlbumNotFoundException();
        }
    }

    @PostMapping("/create")
    public RedirectView postAlbum(@RequestParam String title,
                                  @RequestParam String artist,
                                  @RequestParam String songCount,
                                  @RequestParam String length,
                                  @RequestParam String imageURL) {
        Album album = new Album();
        album.title = title;
        album.artist = artist;
        album.songCount = Integer.parseInt(songCount);
        album.length = Integer.parseInt(length);
        album.imageURL = imageURL;

        album = this.albumReposity.save(album);

        return new RedirectView("/albums/" + album.id);
    }

    @PostMapping("/{id}/song/add")
    public RedirectView addSong(@PathVariable long id,
                                @RequestParam String title,
                                @RequestParam String artist,
                                @RequestParam int trackNumber,
                                @RequestParam int length,
                                Model model) {
        Optional<Album> album = albumReposity.findById(id);
        if (album.isPresent()) {
            Song song = new Song();
            song.album = album.get();
            song.title = title;
            song.artist = artist;
            song.trackNumber = trackNumber;
            song.length = length;

            song = this.songRepository.save(song);

            return new RedirectView("/albums/" + id);
        } else {
            throw new AlbumNotFoundException();
        }


    }

    @GetMapping("/{id}/song/{songid}")
    public String getSong(@PathVariable long id,
                          @PathVariable long songid,
                          Model model) {
        Optional<Song> song = songRepository.findById(songid);

        if (song.isPresent()) {
            Optional<Album> album = albumReposity.findById(id);
            if (album.isPresent()) {
                model.addAttribute("song", song.get());
                model.addAttribute("album", album.get());

                return "oneSong";
            } else {
                throw new AlbumNotFoundException();
            }

        } else {
            throw new SongNotFoundException();
        }
    }

    @PostMapping("/{id}/song/{songid}/update")
    public RedirectView updateSong(@PathVariable long id,
                                   @PathVariable long songid,
                                   @RequestParam String title,
                                   @RequestParam String artist,
                                   @RequestParam int trackNumber,
                                   @RequestParam int length) {
        Optional<Song> song = songRepository.findById(songid);
        if (song.isPresent()) {
            Optional<Album> album = albumReposity.findById(id);
            if (album.isPresent()) {
                song.get().title = title;
                song.get().artist = artist;
                song.get().trackNumber = trackNumber;
                song.get().length = length;

                songRepository.deleteById(songid);
                songRepository.save(song.get());

                return new RedirectView("/albums/" + id);
            } else {
                throw new AlbumNotFoundException();
            }
        } else {
            throw new SongNotFoundException();
        }
    }
}
