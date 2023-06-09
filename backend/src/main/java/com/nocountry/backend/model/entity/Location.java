package com.nocountry.backend.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LOCATIONS")
public class Location {

    @Id
    @Column(name = "ID_LOCATION")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BRANCH")
    private String branch;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "location")
    private List<Car> cars;
}
