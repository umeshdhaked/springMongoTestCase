package com.stackroute.muzix.controller;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.service.MusicTrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice
@RestController
@RequestMapping("tracks")
@Api("Track CRUD Operation API")
public class MusicTrackController {

    private MusicTrackService musicTrackService;
    @Autowired
    public MusicTrackController(MusicTrackService musicTrackService)
    {
        this.musicTrackService = musicTrackService;
    }


    @ApiOperation(value = "Saving Track Detail")
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException {

        ResponseEntity responseEntity;
        musicTrackService.saveTrack(track);
        responseEntity = new ResponseEntity<String>("Successful Created", HttpStatus.OK);
        //response.sendRedirect("/index.html");
        return responseEntity;
    }

    @ApiOperation(value = "Reading Tracks Detail")
    @GetMapping("track")
    private ResponseEntity<?> displayAllTrack() throws TrackNotFoundException {

        return new ResponseEntity<List<Track>>(musicTrackService.getAllTrack(), HttpStatus.OK);

    }

    @ApiOperation(value = "Deleting Track")
    @DeleteMapping("track")
    private ResponseEntity<?> deleteTrack(@RequestBody Track track) throws TrackNotFoundException {
        ResponseEntity responseEntity;

        responseEntity = new ResponseEntity<String>(musicTrackService.removeTrack(track.getTrackId()) + "Is deleted", HttpStatus.OK);
        return responseEntity;
    }

    @ApiOperation(value = "Updating Track Comment")
    @PutMapping("track")
    private ResponseEntity<?> updateTrackComment(@RequestBody Track track) throws TrackNotFoundException {
        ResponseEntity responseEntity;

        musicTrackService.updateTrackComment(track);
        responseEntity = new ResponseEntity<List<Track>>(musicTrackService.getAllTrack(), HttpStatus.OK);
        return responseEntity;
    }

    @ApiOperation(value = "Finding Track Detail by Name")
    @GetMapping("byName")
    private ResponseEntity<?> trackByName(@RequestBody Track track) throws TrackNotFoundException {
        ResponseEntity responseEntity;

        responseEntity = new ResponseEntity<List<Track>>(musicTrackService.trackByName(track.getTrackName()), HttpStatus.OK);

        return responseEntity;
    }


}
