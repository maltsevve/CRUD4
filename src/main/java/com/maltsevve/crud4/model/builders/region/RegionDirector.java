package com.maltsevve.crud4.model.builders.region;

import com.maltsevve.crud4.model.Region;

public class RegionDirector {
    RegionBuilder regionBuilder;

    public void setRegionBuilder(RegionBuilder regionBuilder) {
        this.regionBuilder = regionBuilder;
    }

    public Region buildRegion() {
        regionBuilder.buildRegion();
        regionBuilder.buildName();
        return regionBuilder.getRegion();
    }
}
