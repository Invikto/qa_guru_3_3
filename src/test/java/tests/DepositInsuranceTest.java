package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TemplatePage;

import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DepositInsuranceTest extends TemplatePage {

  @Test
  @DisplayName("The deposit insurance page has some text")
  void checkDepositInsurancePageIsNotEmpty() {

    open(startUrl);
    $(String.format("[href$='%s']", accumulationDir)).click();
    open(Objects.requireNonNull($(byText("Все вклады застрахованы")).parent().$("a").attr("href")));

    $("[data-test-id='mainBanner']").shouldHave(text("Страхование вкладов"));
    $("p[data-widget-name='Text']").should(exist);
    $("p[data-widget-name='Text']").shouldNotBe(empty);

  }

}
