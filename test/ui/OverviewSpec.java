package ui;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import play.test.UITest;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class OverviewSpec extends UITest {
  @Test
  public void showsAccountsWithBalance() {
    open("/");
    $("h1").shouldHave(text("Bank overview"));

    $$("#accounts .account").shouldHave(texts(
        "acc-001-001-001 1000",
        "acc-002-002-002 -202"));

    holdBrowserOpen = true;
  }
}
