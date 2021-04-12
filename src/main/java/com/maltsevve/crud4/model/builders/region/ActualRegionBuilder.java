package com.maltsevve.crud4.model.builders.region;

public class ActualRegionBuilder extends RegionBuilder{
    String name;

    public ActualRegionBuilder(String name) {
        this.name = name;
    }

    @Override
    public void buildName() {
        region.setName(name);
    }
}
