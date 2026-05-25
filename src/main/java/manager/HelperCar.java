package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperCar extends HelperBase{
    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void searchCurrentMonth(String city, String dateFrom, String dateTo) {
        typeCity(city);
        click(By.id("dates"));

    }

    private void typeCity(String city) {
        type(By.id("city"), city);
        click(By.id("city-suggestions"));
    }
}
