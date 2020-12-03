package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TemplatePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DepositInsuranceTest extends TemplatePage {

  @Test
  @DisplayName("The deposit insurance page has some text")
  void checkDepositInsurancePageIsNotEmpty() {

    open(startUrl);
    $(byText("Вклады")).hover();
    $(byText("Депозиты")).closest("span").sibling(0).$("a").click();
    $("#footer").preceding(0).$(byText("Страхование вкладов")).parent().click();
    $("#footer").preceding(0).$(byText("Подробнее")).click();

    $("h1").shouldHave(text("Страхование вкладов"));
    $("p[data-widget-name='Text']").should(exist);
    $("p[data-widget-name='Text']").shouldNotBe(empty);

  }

}
