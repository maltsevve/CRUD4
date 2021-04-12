package com.maltsevve.crud4.model.builders.region;

import com.maltsevve.crud4.model.Region;

public abstract class RegionBuilder {
    Region region;

    public void buildRegion() {
        region = new Region();
    }

    public void buildName() {

    }

    public Region getRegion() {
        return region;
    }
}
