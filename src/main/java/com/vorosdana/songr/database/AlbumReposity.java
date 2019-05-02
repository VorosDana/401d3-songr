package com.vorosdana.songr.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumReposity extends JpaRepository<Album, Long> {
}
