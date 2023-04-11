package com.nocountry.backend.service.impl;

import com.nocountry.backend.dto.LocationDto;
import com.nocountry.backend.mapper.ILocationMapper;
import com.nocountry.backend.repository.ILocationsRepository;
import com.nocountry.backend.service.LocationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationsService {

    private final ILocationsRepository locationsRepository;

    private final ILocationMapper locationMapper;

    @Override
    public void savaAll(List<LocationDto> locationDtos) {
        locationsRepository.saveAll(locationDtos.stream().map(locationMapper::toLocation).toList());
    }

    @Override
    public List<LocationDto> findAllLocationsContainingBranches() {
        return this.locationsRepository.findAllByBranchesIsNotNull().stream().map(
                locationMapper::toLocationDto
        ).toList();
    }

    @Override
    public List<LocationDto> findAll() {
        return this.locationMapper.toLocationDtos(this.locationsRepository.findAll());
    }


}