package com.codingdojo.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>, JpaRepository<Song, Long> {
	// this method retrieves all the books from the database
	List<Song> findAll();

	// this method finds songs with title containing the search string
	List<Song> findByArtistContaining(String search);
	
	List<Song> findByTitleContaining(String search);

	// this method counts how many titles contain a certain string
	Long countByTitleContaining(String search);

	// this method deletes a book that starts with a specific title
	Long deleteByTitleStartingWith(String search);
	
	
//	@Query(value = "SELECT s FROM Song s")
//	List<Song> findAllSongs(Sort sort);
	
	List<Song> findByOrderByRatingDesc();
}
