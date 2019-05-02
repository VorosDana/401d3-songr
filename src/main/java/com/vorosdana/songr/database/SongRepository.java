package com.vorosdana.songr.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SongRepository extends JpaRepository<Song, Long> {
//    @Query("SELECT t FROM Song s where s.album = :album")
//    public List<Song> findByAlbum(@Param("album") Album album);
}
