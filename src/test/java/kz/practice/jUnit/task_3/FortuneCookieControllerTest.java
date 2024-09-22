package kz.practice.jUnit.task_3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FortuneCookieControllerTest {
    private static FortuneCookieController goodFactoryController;
    private static FortuneCookieController badFactoryController;

    @BeforeAll
    public static void setUp() {
        goodFactoryController = create(true);
        badFactoryController = create(false);
    }

    private static FortuneCookieController create(boolean isPositive) {
        FortuneConfig config = new FortuneConfig(isPositive);
        FortuneCookieFactory factory = new FortuneCookieFactory(
                config,
                singletonList("positive"),
                singletonList("negative")
        );
        return new FortuneCookieController(factory);
    }

    @Test
    public void shouldReturnPositiveFortune() {
        FortuneCookie fortuneCookie = goodFactoryController.tellFortune();
        assertEquals("positive", fortuneCookie.getFortuneText());
    }

    @Test
    public void shouldReturnNegativeFortune() {
        FortuneCookie fortuneCookie = badFactoryController.tellFortune();
        assertEquals("negative", fortuneCookie.getFortuneText());
    }
}