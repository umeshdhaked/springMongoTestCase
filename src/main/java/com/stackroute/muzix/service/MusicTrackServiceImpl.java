package com.stackroute.muzix.service;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.repository.TrackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MusicTrackServiceImpl implements MusicTrackService {

    TrackRepo trackRepo;

    @Autowired
    public MusicTrackServiceImpl(TrackRepo trackRepo) {
        this.trackRepo = trackRepo;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        Track track1 = new Track();
        if (!trackRepo.existsById(track.getTrackId())) {
            track1 = trackRepo.save(track);

        } else {
            throw new TrackAlreadyExistsException("Track Already Exist");
        }
        return track1;
    }

    @Override
    public List<Track> getAllTrack() throws TrackNotFoundException {
        List<Track> tracks = trackRepo.findAll();
        if (tracks.size() == 0) {
            throw new TrackNotFoundException("There are no Tracks in your List");
        }

        return tracks;
    }

    @Override
    public Track removeTrack(int trackId) throws TrackNotFoundException {
        Track track = new Track();
        if (trackRepo.existsById(trackId)) {
            track = trackRepo.findById(trackId).get();
            trackRepo.deleteById(trackId);
        } else {
            throw new TrackNotFoundException("Track not found");
        }
            return track;
    }

    @Override
    public void updateTrackComment(Track track) throws TrackNotFoundException {
        //    trackRepo.findAll();
        Track track1;
        if (trackRepo.existsById(track.getTrackId())) {
            track1 = trackRepo.findById(track.getTrackId()).get();
            track1.setTrackComment(track.getTrackComment());

        } else {
            throw new TrackNotFoundException("Track not found");
        }


        trackRepo.save(track1);

    }

    @Override
    public List<Track> trackByName(String name) throws TrackNotFoundException {
        //trackRepo.findAll();

        List<Track> tracks = trackRepo.getTrackByName(name);
        if (tracks.size() == 0) {
            throw new TrackNotFoundException("Track is No Track Named : " + name);
        }

        return tracks;
    }

}
