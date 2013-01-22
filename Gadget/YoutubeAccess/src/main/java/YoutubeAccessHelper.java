import com.google.gdata.client.youtube.YouTubeQuery;
import com.google.gdata.util.ServiceException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Serg
 * Date: 17.01.13
 * Time: 14:07
 * To change this template use File | Settings | File Templates.
 */
public class YoutubeAccessHelper extends AYoutubeAccess {

    public YoutubeAccessHelper(String service, String url) throws MalformedURLException {
        super(service, url);
    }

    @Override
    public void execute() throws IOException, ServiceException {
        System.out.println("Press 0 to exit");
        Scanner sc = new Scanner(System.in);
        String search = "";
        while (search != null && sc.hasNext()) {
            search = sc.next();
            if (!search.equals("0")) {
                setSearchTag(search);
                printRelatedVideos(YouTubeQuery.OrderBy.RELEVANCE);
            } else {
                search = null;
            }
        }
    }
}
