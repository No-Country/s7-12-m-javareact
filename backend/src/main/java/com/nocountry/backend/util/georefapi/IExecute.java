package com.nocountry.backend.util.georefapi;

import com.nocountry.backend.dto.InformationLocationDto;

import java.util.Map;

public interface IExecute {

    InformationLocationDto execute( Map<String, Object> toMap);

}
