package com.nocountry.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nocountry.backend.model.Location;

public interface ILocationRepository extends JpaRepository<Location, Long> {

}