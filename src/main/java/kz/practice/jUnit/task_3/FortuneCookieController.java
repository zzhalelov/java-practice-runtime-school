package kz.practice.jUnit.task_3;

public class FortuneCookieController {
    private final FortuneCookieFactory fortuneCookieFactory;

    public FortuneCookieController(FortuneCookieFactory fortuneCookieFactory) {
        this.fortuneCookieFactory = fortuneCookieFactory;
    }

    public FortuneCookie tellFortune() {
        return this.fortuneCookieFactory.bakeFortuneCookie();
    }
}