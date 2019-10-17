package com.stackroute.muzix.repository;

import com.stackroute.muzix.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrackRepo extends JpaRepository<Track, Integer> {

    @Query(value = "SELECT * FROM track WHERE track_name=?1", nativeQuery = true)
        //nativeQuery is for SQL only Query
    List<Track> getTrackByName(String string);

}
