/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinxo;

import java.util.Date;

/**
 *
 * @author Bijoy
 */
public class moviesData {

    private String title;
    private String genre;
    private String duration;
    private String image;
    private Date date;

    public moviesData(String title, String genre, String duration, String image, Date date) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.image = image;
        this.date = date;

    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public String getImage() {
        return image;
    }

    public Date getDate() {
        return date;
    }

}
