package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperCar extends HelperBase {
    public HelperCar(WebDriver wd) {
        super(wd);
    }


    public void searchCurrentMonth(String city, String dateFrom, String dateTo) {
        typeCity(city);
        click(By.id("dates"));
        //"5/29/2026","5/31/2026"
        String from = dateFrom.split("/")[1];
        By fromLocator = By.xpath(
                "//button[not(contains(@class, 'rdrDayPassive'))][not(contains(@class, 'rdrDayDisabled'))]//span[text()='" + from + "']");
        click(fromLocator);
        String to = dateTo.split("/")[1];
        By toLocator = By.xpath(
                "//button[not(contains(@class, 'rdrDayPassive'))][not(contains(@class, 'rdrDayDisabled'))]//span[text()='" + to + "']");
        click(toLocator);
    }

    private void typeCity(String city) {
        type(By.id("city"), city);
        click(By.id("city-suggestions"));
    }

    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.cssSelector("a.car-container"));
    }

    public void searchCurrentYear(String city, String dateFrom, String dateTo) {
        typeCity(city);
        click(By.id("dates"));
        LocalDate now = LocalDate.now();
        System.out.println(now);
        int month = now.getMonthValue();
        //int year = now.getYear();
        //int day = now.getDayOfMonth();

        LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("M/d/yyyy"));
        int diffMonth = from.getMonthValue() - month;
        if (diffMonth > 0) {
            clickNextMontBtn(diffMonth);
        }
        click(By.xpath("//span[text() = '" + from.getDayOfMonth() + "']"));
        diffMonth = to.getMonthValue() - from.getMonthValue();
        if (diffMonth > 0) {
            clickNextMontBtn(diffMonth);
        }
        click(By.xpath("//span[text()='" + to.getDayOfMonth() + "']"));
    }

    private void clickNextMontBtn(int diffMonth) {
        for (int i = 0; i < diffMonth; i++) {
            click(By.cssSelector(".rdrNextPrevButton.rdrNextButton"));
        }


    }

    public void searchAnyPeriodSuccess(String city, String dateFrom, String dateTo) {
        typeCity(city);
        click(By.id("dates"));
        LocalDate now = LocalDate.now();
        System.out.println(now);
        int month = now.getMonthValue();
        int year = now.getYear();
        //int day = now.getDayOfMonth();

        LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("M/d/yyyy"));
        int diffMonth = from.getMonthValue() - month;
        if (diffMonth > 0) {
            clickNextMontBtn(diffMonth);
        }
        click(By.xpath("//span[text() = '" + from.getDayOfMonth() + "']"));
        diffMonth = to.getMonthValue() - from.getMonthValue();
        if (diffMonth > 0) {
            clickNextMontBtn(diffMonth);
        }
        click(By.xpath("//span[text()='" + to.getDayOfMonth() + "']"));
    }
}
