package sg.edu.rp.webservices.song;

import java.io.Serializable;

public class Song implements Serializable {

    private int id;
    private String title;
    private String singers;
    private int years;
    private int stars;

    public Song(int id,String title,String singers,int years,int stars) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.years = years;
        this.stars = stars;
    }

    public int getId() {  return id;  }
    public int getYears() { return years; }
    public int getStars() { return stars; }
    public String getTitle() {  return title;  }
    public String getSingers() {  return singers;  }


    public void setTitle(String title) {
        this.title = title;
    }
    public void setSingers(String singers) {
        this.singers = singers;
    }
    public void setYears(int years) {
        this.years = years;
    }
    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() { return "ID:" + id + ", " + title ;  }

}
