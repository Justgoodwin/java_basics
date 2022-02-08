package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Processor processor = new Processor();
        RandomAccessMemory randomAccessMemory = new RandomAccessMemory();
        InformationStorage informationStorage = new InformationStorage();
        Screen screen = new Screen();
        Keyboard keyboard = new Keyboard();

        Computer computer = new Computer("HP",
                "Victus",
                processor.NewProcessor(3.6,8,CoreMaker.INTEL,0.113),
                randomAccessMemory.NewRAMMemory(RAMMemoryType.DDR4,16,0.170),
                informationStorage.NewInformationStorage(InformationStorageType.SSD,1024,0.230),
                screen.NewScreen(23.7,ScreenType.IPS,1.7),
                keyboard.NewKeyboard(KeyboardType.MECHANICAL,KeyboardIllumination.YES,0.370));

        System.out.println(computer);
        System.out.println("Mass of all components in computer: " + computer.getWeightOfAllComputerComponents() + " Kg");
    }
}
