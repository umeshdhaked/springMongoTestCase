package com.stackroute.muzix.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {
    @Id
    private Integer trackId;
    private String trackName;
    private String trackComment;
}
