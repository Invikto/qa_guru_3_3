package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TemplatePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class ArchiveDepositsTest extends TemplatePage {

  @Test
  @DisplayName("Count of archive deposits is 5")
  void checkArchiveDepositsCount() {

    String  archiveDepositsTabName = "Депозиты";

    open(startUrl + accumulationDir);
    $$(String.format("[href*='%s']", depositsDir)).findBy(visible).click();
    $$(String.format("[href*='%s']", archiveDepositsDir)).findBy(visible).click();
    $("[data-test-id='tabs-list']").$(withText(archiveDepositsTabName)).closest("button").click();

    $$("[data-widget-name='CatalogCard']").shouldHaveSize(5);

  }

}
