package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.util.Collection;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.addListener;

public class Highlighter extends AbstractWebDriverEventListener {
  static {
    addListener(new Highlighter());
  }
  
  @Override
  public void beforeClickOn(WebElement element, WebDriver driver) {
    highlight(element, "orange");
  }

  @Override
  public void beforeFindBy(By by, WebElement element, WebDriver driver) {
//    highlight(element, "red");
  }

  @Override
  public void afterFindBy(By by, WebElement element, WebDriver driver) {
    highlight(element, "orange");
  }

  @Override
  public void beforeChangeValueOf(WebElement element, WebDriver driver) {
    highlight(element, "orange");
  }

  public static <T extends WebElement> T highlight(T element) {
    return highlight(element, "orange");
  }

  public static <T extends WebElement> T highlight(T element, final String color) {
    return highlight(element, color, 50);
  }
  
  public static <T extends WebElement> T highlight(T element, final String color, int duration) {
    if (element != null && element.getAttribute("__selenideHighlighting") == null) {
      for (int i = 1; i < 4; i++) {
        transform(element, color, i);
        sleep(duration);
      }
      for (int i = 4; i > 0; i--) {
        transform(element, color, i);
        sleep(duration);
      }
    }
    return element;
  }
  
  public static void highlight(Collection<? extends WebElement> elements) {
    for (WebElement element : elements) {
      highlight(element, "orange", 1);
    }
  }

  private static void transform(WebElement element, String color, int i) {
    executeJavaScript(
        "arguments[0].setAttribute('__selenideHighlighting', 'done'); " + 
        "arguments[0].setAttribute(arguments[1], arguments[2])",
        element,
        "style",
        "border: " + i + "px solid " + color + "; border-style: dotted; " +
        "transform: scale(1, 1." + i + ");");
  }
}
