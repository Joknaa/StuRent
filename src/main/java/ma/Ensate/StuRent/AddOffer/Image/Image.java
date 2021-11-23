package ma.Ensate.StuRent.AddOffer.Image;

import javax.persistence.*;

@Entity(name = "images") // This tells Hibernate to make a table out of this class
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Image_ID;
    private Long Post_ID;
    private String Path;

    public Image() { }
    public Image(Long post_ID, String path) {
        setImage_ID(0L);
        setPost_ID(post_ID);
        setPath(path);
    }
    public Image(Long post_ID, Long image_ID, String path) {
        setPost_ID(post_ID);
        setImage_ID(image_ID);
        setPath(path);
    }


    public Long getImage_ID() {
        return Image_ID;
    }

    public void setImage_ID(Long image_ID) {
        Image_ID = image_ID;
    }

    public Long getPost_ID() {
        return Post_ID;
    }

    public void setPost_ID(Long post_ID) {
        Post_ID = post_ID;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public String ShowDetails() {
        return String.format("%o | %o | %s", Post_ID, Image_ID, Path);
    }
}
