import com.google.gdata.client.youtube.YouTubeQuery;
import com.google.gdata.util.ServiceException;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Serg
 * Date: 21.01.13
 * Time: 10:39
 * To change this template use File | Settings | File Templates.
 */
public class YoutubeAccessHelperTestCase {

    @Test
    public void testExecution() throws IOException, ServiceException {
        AYoutubeAccess youtubeAccess = new YoutubeAccessHelper(AYoutubeAccess.SERVICE_NAME,
                AYoutubeAccess.YOUTUBE_GDATA_URL);
        youtubeAccess.setSearchTag("watermellon attack");
        List<VideoData> list = youtubeAccess.printRelatedVideos(YouTubeQuery.OrderBy.RATING);

        VideoData data = list.get(0);
        Assert.assertEquals(data.getTitle(), "Krs One - My Philosophy - 1988?");
        Assert.assertEquals(data.getDescription(), "Krs One My Philosophy Hip Hop");
        Assert.assertEquals(AYoutubeAccess.getUrl(data.getHref()),
                "http://www.youtube.com/watch?v=zzU7jJBMElM");

        data = list.get(1);
        Assert.assertEquals(data.getTitle(), "BIG CAT SUMMER!");
        Assert.assertEquals(AYoutubeAccess.getUrl(data.getHref()),
                "http://www.youtube.com/watch?v=asOVKZ-fYzA");

        data = list.get(2);
        Assert.assertEquals(data.getTitle(), "The Mario Bros. U - New Super Mario Bros. U Time Attack Challenges Gameplay w/ SSoHPKC Part 3 - Mountain of Pain");
        Assert.assertEquals(AYoutubeAccess.getUrl(data.getHref()),
                "http://www.youtube.com/watch?v=ewJgtlOIVxk");

        data = list.get(3);
        Assert.assertEquals(data.getTitle(), "Zaboo gets soul-mated; Vork occupies Swordlandia - The Guild S6 ep. 6: Into the Breach");
        Assert.assertEquals(AYoutubeAccess.getUrl(data.getHref()),
                "http://www.youtube.com/watch?v=RMY42y2AEec");

        data = list.get(4);
        Assert.assertEquals(data.getTitle(), "GIANT KILLER GOOSE (6.21.10 - Day 417)");
        Assert.assertEquals(AYoutubeAccess.getUrl(data.getHref()),
                "http://www.youtube.com/watch?v=zVFgxRcB1nY");
    }
}
