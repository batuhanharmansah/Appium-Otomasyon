import com.google.common.collect.ImmutableMap;
import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Random;

public class BasePage extends BaseTest {

    @Step("<wait> saniye kadar bekle")
    public void waitForseconds(int wait) throws InterruptedException {
        Thread.sleep(1000 * wait);
    }

    @Step(("<id>Uygulama acıldı"))
    public void openScreen(String id) {
        String kontrol = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("ALIŞVERİŞE BAŞLA", kontrol);
        Logger.info("Uygulama başarıyla açıldı kontrolü sağlandı");

    }

    @Step("<xpath> Kategoriler sayfası kontrolü")
    public void kategorilerKontrol(String xpath) {
        String kontrol = appiumDriver.findElement(By.xpath(xpath)).getText();
        Assertions.assertEquals("Kategoriler", kontrol);
        Logger.info("Kategoriler sayfası kontrolü başarıyla tamamlandı.");

    }


    @Step("<id> Giriş yapma sayfası kontrolü")
    public void girisKontrol(String id) {
        String kontrol = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("Parolamı Unuttum", kontrol);
        Logger.info("Login sayfası kontrolü başarıyla sağlandı");
    }

    @Step("<id> Ürün detay sayfası kontrolü")
    public void urunDetayKontrol(String id) {
        String kontrol = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("En geç 7 Mart'ta", kontrol);
        Logger.info("Ürün sayfası Kontrolü başarıyla sağlandı");

    }

    @Step("id <id> li eleemente tıkla")
    public void clickByid(String id) {
        appiumDriver.findElement(By.id(id)).click();
        System.out.println(id + "eleentine tıklandı");
        Logger.info(id + "İstenilen adrese tıklama işlemi yapıldı");
    }


    @Step("xpath <xpath> elemente tıkla")
    public void clickByXpath(String xpath) {

        appiumDriver.findElement(By.xpath(xpath)).click();
        Logger.info(xpath + "istenilen xpath adresine tıklama işlemi sağlandı");
    }


    @Step("scroll")
    public void scrollyap() throws InterruptedException {
        Thread.sleep(3000);
        TouchAction scroll = new TouchAction(appiumDriver);
        scroll.press(PointOption.point(548, 385)).moveTo(PointOption.point(545, 247)).release().perform();
        Logger.info("Scrol işlemi başarıyla sağlandı");
    }

    @Step("<id> İd'li elemente <text> değerini yaz")
    public void sendKeysid(String id, String text) {
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        Logger.info("istenilen adres bulundu" + text + "İstenilen değer yazdırıldı");
    }

    @Step("Rasgele bir ürün seç")
    public void selectRondamproduct() {
        Random rdn = new Random();
        List<MobileElement> pd = appiumDriver.findElements(By.xpath("//*[@resource-id = 'com.ozdilek.ozdilekteyim:id/recyclerView']/android.widget.FrameLayout"));
        System.out.println("pd" + pd);
        MobileElement element = pd.get(rdn.nextInt(pd.size()));
        element.click();
        Logger.info("Rastgele metodu başarıyla sağlandı");

    }

}
