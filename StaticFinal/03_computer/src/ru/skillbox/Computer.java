package ru.skillbox;

public class Computer {
    private final String computerVendor;
    private final String computerName;
    private final Processor processor;
    private final RandomAccessMemory randomAccessMemory;
    private final InformationStorage informationStorage;
    private final Screen screen;
    private final Keyboard keyboard;

    public Computer() {
        computerVendor = "";
        computerName = "";
        processor = new Processor();
        randomAccessMemory = new RandomAccessMemory();
        informationStorage = new InformationStorage();
        screen = new Screen();
        keyboard = new Keyboard();

    }

    public Computer(String computerVendor,
                    String computerName,
                    Processor processor,
                    RandomAccessMemory randomAccessMemory,
                    InformationStorage informationStorage,
                    Screen screen,
                    Keyboard keyboard) {
        this.computerVendor = computerVendor;
        this.computerName = computerName;
        this.processor = processor;
        this.randomAccessMemory = randomAccessMemory;
        this.informationStorage = informationStorage;
        this.screen = screen;
        this.keyboard = keyboard;
    }

    public Computer setProcessor (Processor processor) {
        return new Computer(computerVendor,
                computerName,
                processor,
                randomAccessMemory,
                informationStorage,
                screen,
                keyboard);
    }
    public Computer setRandomAccessMemory (RandomAccessMemory randomAccessMemory) {
        return new Computer(computerVendor,
                computerName,
                processor,
                randomAccessMemory,
                informationStorage,
                screen,
                keyboard);
    }
    public Computer setInformationStorage (InformationStorage informationStorage) {
        return new Computer(computerVendor,
                computerName,
                processor,
                randomAccessMemory,
                informationStorage,
                screen,
                keyboard);
    }
    public Computer setScreen (Screen screen) {
        return new Computer(computerVendor,
                computerName,
                processor,
                randomAccessMemory,
                informationStorage,
                screen,
                keyboard);
    }
    public Computer setKeyboard (Keyboard keyboard) {
        return new Computer(computerVendor,
                computerName,
                processor,
                randomAccessMemory,
                informationStorage,
                screen,
                keyboard);
    }

    public String getComputerVendor() {
        return computerVendor;
    }

    public String getComputerName() {
        return computerName;
    }

    public Processor getProcessor() {
        return processor;
    }

    public RandomAccessMemory getRandomAccessMemory() {
        return randomAccessMemory;
    }

    public InformationStorage getInformationStorage() {
        return informationStorage;
    }

    public Screen getScreen() {
        return screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public double getWeightOfAllComputerComponents() {
        return processor.getMass() +
                randomAccessMemory.getMass() +
                informationStorage.getMass() +
                screen.getMass() +
                keyboard.getMass();
    }

    public String toString(){
        return "Computer information:" + "\n" +
                "   Vendor: " + computerVendor + "\n" +
                "   Name: " + computerName + "\n" +
                "About processor: " + "\n" +
                "   Maker: " + processor.getCoreMaker() + "\n" +
                "   Core number: " + processor.getCore() + "\n" +
                "   Core frequency: " + processor.getFrequancy() + " GHz"  + "\n" +
                "   Processor weight: " + processor.getMass() + " grams" + "\n" +
                "About RAM:" + "\n" +
                "   RAM type: " + randomAccessMemory.getRamMemoryType() + "\n" +
                "   RAM capacity: " + randomAccessMemory.getMemoryCapacity() + " Gigabytes" + "\n" +
                "   RAM weight: " + randomAccessMemory.getMass() + " grams" + "\n" +
                "   About memory: " + "\n" +
                "   Memory type: " + informationStorage.getInformationStorageType() + "\n" +
                "   Memory capacity: " + informationStorage.getInformationStorageCapacity() + " Gigabytes" + "\n" +
                "   Memory weight: " + informationStorage.getMass() + " grams" + "\n" +
                "About screen:" + "\n" +
                "   Screen diagonal: " + screen.getScreenDiagonal() + " inch" + " / " + screen.getScreenDiagonal() * 2.5 + " cm" + "\n" +
                "   Screen matrix type: " + screen.getScreenType() + "\n" +
                "   Screen weight: " + screen.getMass() + " Kg" + "\n" +
                "About keyboard: " + "\n" +
                "   Keyboard type: " + keyboard.getKeyboardType() + "\n" +
                "   Illumination presence: " + keyboard.getKeyBoardIllumination() + "\n" +
                "   Keyboard weight: " + keyboard.getMass() + " grams";
    }

}

