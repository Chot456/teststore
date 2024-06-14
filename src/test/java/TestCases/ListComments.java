package TestCases;

import java.util.List;
import java.time.Duration;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.ExtentManager;
import base.Hooks;

@Listeners(resources.Listeners.class)

public class ListComments extends Hooks {

    public ListComments() throws IOException {
        super();
    }

    @Test
    public void goToYoutube() throws Exception {

        ExtentManager.log("youtube test started...");
        getDriver().get("http://www.youtube.com/watch?v=lg6hkvzlUlw");

        try {

            // Wait for the page to load
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("comments")));

            // Scroll down to load comments
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,1000)", "");

            // Sleep for 10 seconds to allow comments to load
            Thread.sleep(10000);

            // Locate comment elements
            List<WebElement> comments = getDriver().findElements(By.xpath("//ytd-comment-thread-renderer"));

            System.out.println("The number of comments are " + comments.size() + "");

            for (WebElement comment : comments) {
                // Get the name of the commentator
                WebElement nameElement = comment.findElement(By.id("author-text"));
                String name = nameElement.getText();

                // Get the like count of the comment
                WebElement likeElement = comment.findElement(By.xpath(".//span[@id='vote-count-middle']"));
                String likeText = likeElement.getText();

                // Extract the number of likes from the text
                int likeCount = extractLikes(likeText);

                // Check if the like count is more than 10
                if (likeCount > 50) {
                    System.out.println("Commentator Name: " + name);
                    System.out.println("Likes: " + likeCount);
                    System.out.println("--------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Helper method to extract the number of likes from the like count text
    private static int extractLikes(String likeText) {
        // Example likeText: "10" or "10K" or "10M"
        likeText = likeText.replace("K", "000").replace("M", "000000");
        return Integer.parseInt(likeText.replaceAll("[^0-9]", ""));
    }

}