import com.google.gdata.util.ServiceException;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Serg
 * Date: 16.01.13
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 */
public class YoutubeSearcher {

    public static final String MODE = "mode";
    public static final String MODE_DEV = "dev";
    public static final String MODE_TEST = "test";

    public static void main(String[] args) throws IOException, ServiceException {
        String mode = System.getProperty(MODE);
        System.out.println("Mode: " + mode);
        mode = (mode != null) ? mode : MODE_TEST;

        AYoutubeAccess youtubeAccess = null;
        if (mode != null && !mode.isEmpty()) {
            if (mode.equals(MODE_DEV)) {
                youtubeAccess = new YoutubeAccessHelper(AYoutubeAccess.SERVICE_NAME, AYoutubeAccess.YOUTUBE_GDATA_URL);
            } else {
                youtubeAccess = new YoutubeAccessTestHelper(AYoutubeAccess.SERVICE_NAME, AYoutubeAccess.YOUTUBE_GDATA_URL);
            }
        }
        if (youtubeAccess != null) {
            youtubeAccess.execute();
        }
    }
}
