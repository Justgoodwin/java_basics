package ru.skillbox;

public class InformationStorage {
    private final InformationStorageType informationStorageType;
    private final int informationStorageCapacity; //Gigabytes
    private final double mass; // grams

    public InformationStorage() {
        informationStorageType = null;
        informationStorageCapacity = 0;
        mass = 0;
    }

    public InformationStorage (InformationStorageType informationStorageType, int informationStorageCapacity, double mass) {
        this.informationStorageType = informationStorageType;
        this.informationStorageCapacity = informationStorageCapacity;
        this.mass = mass;
    }

    public InformationStorage NewInformationStorage (InformationStorageType informationStorageType, int informationStorageCapacity, double mass) {
        return new InformationStorage(informationStorageType, informationStorageCapacity, mass);
    }

    public InformationStorageType getInformationStorageType() {
        return informationStorageType;
    }

    public int getInformationStorageCapacity() {
        return informationStorageCapacity;
    }

    public double getMass() {
        return mass;
    }
}
