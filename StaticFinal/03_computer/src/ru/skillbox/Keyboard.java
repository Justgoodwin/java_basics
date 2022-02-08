package ru.skillbox;

public class Keyboard {
    private final KeyboardType keyboardType;
    private final KeyboardIllumination keyboardIllumination;
    private  final double mass;

    public Keyboard() {
        keyboardType = null;
        keyboardIllumination = KeyboardIllumination.NO;
        mass = 0;
    }

    public Keyboard(KeyboardType keyboardType, KeyboardIllumination keyBoardIllumination, double mass) {
        this.keyboardType = keyboardType;
        this.keyboardIllumination = keyBoardIllumination;
        this.mass = mass;
    }

    public Keyboard NewKeyboard(KeyboardType keyboardType, KeyboardIllumination keyboardIllumination, double mass) {
        return new Keyboard(keyboardType, keyboardIllumination, mass);
    }

    public KeyboardType getKeyboardType() {
        return keyboardType;
    }

    public KeyboardIllumination getKeyBoardIllumination() {
        return keyboardIllumination;
    }

    public double getMass() {
        return mass;
    }
}
