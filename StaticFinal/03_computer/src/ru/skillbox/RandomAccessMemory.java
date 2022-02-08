package ru.skillbox;

public class RandomAccessMemory {
    private final RAMMemoryType ramMemoryType;
    private final int memoryCapacity; // gigabytes
    private final double mass; // grams

    public RandomAccessMemory() {
        ramMemoryType = null;
        memoryCapacity = 0;
        mass = 0;

    }

    public RandomAccessMemory(RAMMemoryType ramMemoryType, int memoryCapacity, double mass) {
        this.ramMemoryType = ramMemoryType;
        this.memoryCapacity = memoryCapacity;
        this.mass = mass;
    }

    public RandomAccessMemory NewRAMMemory(RAMMemoryType ramMemoryType, int memoryCapacity, double mass){
        return new RandomAccessMemory(ramMemoryType, memoryCapacity,mass);
    }
    public RAMMemoryType getRamMemoryType() {
        return ramMemoryType;
    }

    public int getMemoryCapacity() {
        return memoryCapacity;
    }

    public double getMass() {
        return mass;
    }
}
