package com.nocountry.backend.mapper;

import java.util.List;

import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.nocountry.backend.dto.CategoryDto;
import com.nocountry.backend.model.Category;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {

    CategoryDto CategoryToCategoryDto(Category category);

    Category CategoryDtoToCategory(CategoryDto categoryDto);

    List<CategoryDto> CategoryEntityListToCategoryDTOList(List<Category> allCategories);

    @Mapping(target = "id", ignore = true)
    void updateCategoryFromDto(CategoryDto categoryDto, @MappingTarget Category category);

    @Condition
    default boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }
}