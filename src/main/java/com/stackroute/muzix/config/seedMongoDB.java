package com.stackroute.muzix.config;

import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.repository.TrackRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = TrackRepo.class)
@Configuration
public class seedMongoDB {

    @Bean
    CommandLineRunner commandLineRunner(TrackRepo trackRepo){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                trackRepo.save(new Track(1,"one","Comment"));
//                trackRepo.save(new Track(2,"two","no Comment"));
            }
        };

    }

}
