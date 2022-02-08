package ru.skillbox;

public class Processor{

    private final double frequancy;
    private final int core;
    private final CoreMaker coreMaker;
    private final double mass; // gramms

    public Processor() {
        frequancy = 0;
        core = 0;
        coreMaker = null;
        mass = 0;
    }

    public Processor(double frequancy, int core, CoreMaker coreMaker, double mass) {
        this.frequancy = frequancy;
        this.core = core;
        this.coreMaker = coreMaker;
        this.mass = mass;
    }

    public Processor NewProcessor(double frequancy, int core, CoreMaker coreMaker, double mass) {
        return new Processor(frequancy,core,coreMaker,mass);
    }

    public double getFrequancy() {
        return frequancy;
    }

    public int getCore() {
        return core;
    }

    public CoreMaker getCoreMaker() {
        return coreMaker;
    }

    public double getMass() {
        return mass;
    }
}
