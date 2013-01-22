/**
 * Created with IntelliJ IDEA.
 * User: Serg
 * Date: 21.01.13
 * Time: 10:51
 * To change this template use File | Settings | File Templates.
 */
public class VideoData {

    private boolean prime;
    private String title;
    private String description;
    private String href;

    public VideoData(boolean prime, String title, String description, String href) {
        this.prime = prime;
        this.title = title;
        this.description = description;
        this.href = href;
    }

    public boolean isPrime() {
        return prime;
    }

    public void setPrime(boolean prime) {
        this.prime = prime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}

