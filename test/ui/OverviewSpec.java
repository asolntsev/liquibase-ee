package ui;

import org.junit.Test;
import play.test.UITest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OverviewSpec extends UITest {
  @Test
  public void showsAccountsWithBalance() {
    open("/");
    $("h1").shouldHave(text("Bank overview"));
  }
}
