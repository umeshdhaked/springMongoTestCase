package com.stackroute.muzix.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.muzix.controller.MusicTrackController;
import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.service.MusicTrackService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MuzixControllerTests {

    private Track track;
    private MockMvc mockMvc;

    @Mock
    MusicTrackService musicTrackService;

    @InjectMocks
    MusicTrackController musicTrackController;

    @Before
    public void setUp(){
        musicTrackController = new MusicTrackController(musicTrackService);
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(this.musicTrackController).build();

        track = new Track(1,"track1","myFav");
    }


    @Test
    public void saveHandlerTest() throws Exception {
        //   when(musicTrackService.saveTrack(any())).thenReturn(true);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(track);
        mockMvc.perform(post("/tracks/track").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated()).andReturn();

    }








}
