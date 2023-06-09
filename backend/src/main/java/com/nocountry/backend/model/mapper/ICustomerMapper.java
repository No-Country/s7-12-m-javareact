package com.nocountry.backend.model.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.nocountry.backend.model.dto.customer.CustomerDetailsDto;
import com.nocountry.backend.model.dto.customer.CustomerListDto;
import com.nocountry.backend.model.dto.customer.CustomerRegisterDto;
import com.nocountry.backend.model.dto.customer.CustomerUpdateDto;
import com.nocountry.backend.model.entity.Customer;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ICustomerMapper {

    @Mapping(target = "email", ignore = true)
    @Mapping(target = "idLocation", source = "fkLocation")
    CustomerDetailsDto toCustomerDetailsDto(Customer customer);

    List<CustomerListDto> toCustomerListDtos(List<Customer> customers);

    CustomerListDto toCustomerListDtos(Customer customers);

    @Mapping(target = "fkLocation", source = "idLocation")
    void updateCustomer(CustomerUpdateDto customerUpdateDto, @MappingTarget Customer customer);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "bookings", ignore = true)
    @Mapping(target = "location", ignore = true)
    @Mapping(target = "card", ignore = true)
    @Mapping(target = "fkLocation", source = "idLocation")
    Customer toCustomerRegister(CustomerRegisterDto customerDto);
}
