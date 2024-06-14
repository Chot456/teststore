package TestCases;

import java.util.List;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.ExtentManager;
import base.Hooks;

@Listeners(resources.Listeners.class)

public class ListRow extends Hooks {

    public ListRow() throws IOException {
        super();
    }

    @Test
    public void goToYoutube() throws Exception {

        ExtentManager.log("youtube test started...");
        getDriver().get("http://www.youtube.com/");

        // creating an object of the automationtesting.co.uk webpage

        try {

            // Search for a term, e.g., "technology"
            WebElement searchBox = getDriver().findElement(By.name("search_query"));
            searchBox.sendKeys("technology");
            searchBox.submit();

            // Wait for the page to load and display the results
            Thread.sleep(5000); // Wait for 5 seconds

            // Locate video elements
            List<WebElement> videos = getDriver().findElements(By.xpath("//ytd-video-renderer"));

            for (WebElement video : videos) {
                // Get the title of the video
                WebElement titleElement = video.findElement(By.id("video-title"));
                String title = titleElement.getText();

                // Get the view count
                WebElement viewCountElement = video
                        .findElement(By.cssSelector("div#metadata-line > span:nth-of-type(1)"));
                String viewCountText = viewCountElement.getText();

                // Extract the number of views from the text
                int viewCount = extractViews(viewCountText);

                // Check if the view count is more than 100,000
                if (viewCount > 100000) {
                    System.out.println("Title: " + title);
                    System.out.println("Views: " + viewCountText);
                    System.out.println("--------------------");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // Helper method to extract the number of views from the view count text
    private static int extractViews(String viewCountText) {
        // Example viewCountText: "123K views"
        viewCountText = viewCountText.replace(" views", "").replace("K", "000").replace("M", "000000");
        return Integer.parseInt(viewCountText.replaceAll("[^0-9]", ""));
    }

}