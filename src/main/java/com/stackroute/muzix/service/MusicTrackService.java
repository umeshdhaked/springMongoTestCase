package com.stackroute.muzix.service;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import com.stackroute.muzix.model.Track;

import java.util.List;

public interface MusicTrackService {
    Track saveTrack(Track track) throws TrackAlreadyExistsException;
    List<Track> getAllTrack() throws TrackNotFoundException;
    Track removeTrack(int trackId) throws TrackNotFoundException;
    void updateTrackComment(Track track) throws TrackNotFoundException;
    List<Track> trackByName(String name) throws TrackNotFoundException;
}
