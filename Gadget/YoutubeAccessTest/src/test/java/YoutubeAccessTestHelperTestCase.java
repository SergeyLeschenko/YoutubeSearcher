import com.google.gdata.client.youtube.YouTubeQuery;
import com.google.gdata.util.ServiceException;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Serg
 * Date: 21.01.13
 * Time: 10:40
 * To change this template use File | Settings | File Templates.
 */
public class YoutubeAccessTestHelperTestCase {

    @Test
    public void testExecution() throws IOException, ServiceException {
        AYoutubeAccess youtubeAccess = new YoutubeAccessTestHelper(AYoutubeAccess.SERVICE_NAME,
                AYoutubeAccess.YOUTUBE_GDATA_URL);
        youtubeAccess.setSearchTag(AYoutubeAccess.SEARCH_WIN8);
        List<VideoData> list = youtubeAccess.printRelatedVideos(YouTubeQuery.OrderBy.RELEVANCE);

        VideoData data = list.get(0);
        Assert.assertEquals(data.isPrime(), true);
        Assert.assertEquals(data.getTitle(), "Microsoft Windows 8 for Tablets - Official Presentation");
        Assert.assertEquals(data.getDescription(), "www.netbooknews.com - check out the official presentation of Windows 8 for tablets.");
        Assert.assertEquals(AYoutubeAccess.getUrl(data.getHref()),
                "http://www.youtube.com/watch?v=0xkvdu1SkEQ");

        data = list.get(1);
        Assert.assertEquals(data.isPrime(), false);
        Assert.assertEquals(data.getTitle(), "President Obama's Remarks from Kissimmee, Florida");
        Assert.assertEquals(AYoutubeAccess.getUrl(data.getHref()),
                "http://www.youtube.com/watch?v=gnSngNASUfg");

        data = list.get(3);
        Assert.assertEquals(data.isPrime(), false);
        Assert.assertEquals(data.getTitle(), "\"Rally\" - Rich Carmona for Arizona");
        Assert.assertEquals(data.getDescription(),"Learn more and join Rich Carmona at carmonaforarizona.com.");
        Assert.assertEquals(AYoutubeAccess.getUrl(data.getHref()),
                "http://www.youtube.com/watch?v=JaCGsTs_dhY");
    }
}
