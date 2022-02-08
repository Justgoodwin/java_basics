package ru.skillbox;

public class Screen {
    private final double screenDiagonal;
    private final ScreenType screenType;
    private final double mass;

    public Screen() {
        screenDiagonal = 0;
        screenType = null;
        mass = 0;
    }

    public Screen(double screenDiagonal, ScreenType screenType, double mass) {
        this.screenDiagonal = screenDiagonal;
        this.screenType = screenType;
        this.mass = mass;
    }

    public Screen NewScreen(double screenDiagonal, ScreenType screenType, double mass) {
        return new Screen(screenDiagonal, null, mass);
    }


    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public ScreenType getScreenType() {
        return screenType;
    }

    public double getMass() {
        return mass;
    }
}
