import com.google.gdata.client.Service;
import com.google.gdata.client.youtube.YouTubeQuery;
import com.google.gdata.client.youtube.YouTubeService;
import com.google.gdata.data.youtube.VideoEntry;
import com.google.gdata.data.youtube.VideoFeed;
import com.google.gdata.util.ServiceException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Serg
 * Date: 17.01.13
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
public class YoutubeAccessTestHelper extends AYoutubeAccess {

    public YoutubeAccessTestHelper(String service, String url) throws MalformedURLException {
        super(service, url);
    }

    @Override
    public void execute() throws IOException, ServiceException {
        System.out.println("Search by relevance");
        setSearchTag(SEARCH_SKYFALL);
        printRelatedVideos(YouTubeQuery.OrderBy.RELEVANCE);

        System.out.println("Search by rating");
        setSearchTag(SEARCH_WIN8);
        printRelatedVideos(YouTubeQuery.OrderBy.RATING);
    }
}
