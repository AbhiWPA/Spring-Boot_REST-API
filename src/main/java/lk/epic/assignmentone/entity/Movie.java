package lk.epic.assignmentone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Movie {

    @Id
    private String imdb;
    private String title;
    private String description;
    private double rating;
    private String category;
    private int year;
    private String imgUrl;

}
