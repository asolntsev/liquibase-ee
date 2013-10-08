package ui;

import org.junit.Test;
import play.test.UITest;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PaymentsSpec extends UITest {
  @Test
  public void showsPaymentsHistory() {
    open("/");
    $(byText("Выписка")).click();

    $$("#payments .payment").shouldHave(texts(
        "мама я",
        "я сестра"));

    holdBrowserOpen = true;
  }
}
