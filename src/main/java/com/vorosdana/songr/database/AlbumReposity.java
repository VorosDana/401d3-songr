package com.vorosdana.songr.database;

import org.springframework.data.repository.CrudRepository;

public interface AlbumReposity  extends CrudRepository<Album, Long> {
}
