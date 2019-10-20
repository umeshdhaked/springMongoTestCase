package com.stackroute.muzix.servicesTests;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.repository.TrackRepo;
import com.stackroute.muzix.service.MusicTrackService;
import com.stackroute.muzix.service.MusicTrackServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicTrackServiceImplTest {
    @Autowired
    TrackRepo trackRepo;

    private Track track;
    private MusicTrackService musicTrackService;

    @Before
    public void setUp(){

        musicTrackService = new MusicTrackServiceImpl(trackRepo);

        track = new Track(1,"track1","myFav");
    }

    @Test
    public void saveTest() throws TrackAlreadyExistsException, TrackNotFoundException {
        musicTrackService.saveTrack(track);
        assertEquals("track1",track.getTrackName());
        musicTrackService.removeTrack(1);
    }

    @Test
    public void getTrackbyName() throws TrackAlreadyExistsException, TrackNotFoundException {
        musicTrackService.saveTrack(track);
        assertEquals("track1",musicTrackService.trackByName("track1").get(0).getTrackName());
        musicTrackService.removeTrack(1);
    }


}
