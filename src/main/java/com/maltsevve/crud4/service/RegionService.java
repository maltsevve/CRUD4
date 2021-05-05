package com.maltsevve.crud4.service;

import com.maltsevve.crud4.model.Region;
import com.maltsevve.crud4.repository.JavaIORegionRepositoryImpl;
import com.maltsevve.crud4.repository.RegionRepository;

import java.util.List;

public class RegionService {
    private final RegionRepository regionRepository = new JavaIORegionRepositoryImpl();

    public Region save(Region region) {
        return regionRepository.save(region);
    }

    public Region update(Region region) {
        return regionRepository.update(region);
    }

    public Region getById(Long aLong) {
        return regionRepository.getById(aLong);
    }

    public List<Region> getAll() {
        return regionRepository.getAll();
    }

    public void deleteById(Long aLong) {
        regionRepository.deleteById(aLong);
    }
}
