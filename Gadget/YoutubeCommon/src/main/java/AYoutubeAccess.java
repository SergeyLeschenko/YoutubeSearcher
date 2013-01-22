import com.google.gdata.client.youtube.YouTubeQuery;
import com.google.gdata.client.youtube.YouTubeService;
import com.google.gdata.data.youtube.VideoEntry;
import com.google.gdata.data.youtube.VideoFeed;
import com.google.gdata.util.ServiceException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Serg
 * Date: 17.01.13
 * Time: 15:16
 * To change this template use File | Settings | File Templates.
 */
public abstract class AYoutubeAccess {

    public static final String SERVICE_NAME = "Test_123";
    public static final String YOUTUBE_GDATA_URL = "http://gdata.youtube.com/feeds/api/videos";
    public static final String YOUTUBE_URL = "http://www.youtube.com/watch?v=";
    public static final String SEARCH_SKYFALL = "StJLvbPIvTw";
    public static final String SEARCH_WIN8 = "0xkvdu1SkEQ";

    protected YouTubeService service;
    protected YouTubeQuery query;
    private String searchTag;

    public AYoutubeAccess(String service, String url) throws MalformedURLException {
        this.service = new YouTubeService(service);
        this.query = new YouTubeQuery(new URL(url));
    }

    protected abstract void execute() throws IOException, ServiceException;

    protected List<VideoData> printRelatedVideos(YouTubeQuery.OrderBy orderBy) throws IOException,
            ServiceException {
        List<VideoData> list = new ArrayList<VideoData>();
        query.setOrderBy(orderBy);
        this.query.setIncludeRacy(true);
        this.query.setVideoQuery(getSearchTag());
        VideoFeed videoFeed = this.service.query(this.query, VideoFeed.class);

        boolean prime = true;
        if (videoFeed.getEntries().size() == 1) {
            prime = false;
            VideoEntry videoEntry = videoFeed.getEntries().get(0);
            VideoData videoData = new VideoData(true, videoEntry.getTitle().getPlainText(),
                    videoEntry.getMediaGroup().getDescription().getPlainTextContent(),
                    videoEntry.getRelatedVideosLink().getHref());
            list.add(videoData);
            System.out.println("\nTitle: " + videoData.getTitle());
            System.out.println(videoData.getDescription());
            System.out.println("URL: " + getUrl(videoData.getHref()) + "\n");
            System.out.println("Search related videos...");

            this.query.setVideoQuery(videoEntry.getRelatedVideosLink().getRel());
            videoFeed = this.service.query(this.query, VideoFeed.class);
        }
        int i = 0;
        for(VideoEntry entry : videoFeed.getEntries()) {
            i++;
            VideoData videoData = new VideoData(prime, entry.getTitle().getPlainText(),
                    entry.getMediaGroup().getDescription().getPlainTextContent(),
                    entry.getRelatedVideosLink().getHref());
            list.add(videoData);
            System.out.println("\n" + i + ") Title: " + entry.getTitle().getPlainText());
            System.out.println(entry.getMediaGroup().getDescription().getPlainTextContent());
            System.out.println("URL: " + getUrl(entry.getRelatedVideosLink().getHref()));
        }
        return list;
    }

    public static String getUrl(String link) {
        String url = "";
        if ((link != null) && link.contains("videos/") && link.contains("/related")) {
            url = link.substring(link.indexOf("videos/") + 7, link.indexOf("/related"));
        }
        return YOUTUBE_URL + url;
    }

    protected String getSearchTag() {
        return searchTag;
    }

    protected void setSearchTag(String searchTag) {
        this.searchTag = searchTag;
    }
}
