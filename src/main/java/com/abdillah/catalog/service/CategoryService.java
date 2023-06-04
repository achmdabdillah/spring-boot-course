package com.abdillah.catalog.service;

import com.abdillah.catalog.dto.ResultPageResponseDTO;
import com.abdillah.catalog.dto.CategoryDTO.CategoryCreateUpdateRequestDTO;
import com.abdillah.catalog.dto.CategoryDTO.CategoryListResponseDTO;

public interface CategoryService {
    public void createUpdateRequestCategory(CategoryCreateUpdateRequestDTO dto);

    public ResultPageResponseDTO<CategoryListResponseDTO> findCategoryList(Integer pages, Integer limit, String sortBy,
            String direction, String categoryName);
}