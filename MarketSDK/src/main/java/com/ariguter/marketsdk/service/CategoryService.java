package com.ariguter.marketsdk.service;

import com.ariguter.marketsdk.DTO.CategoryDTO;
import com.ariguter.marketsdk.DTO.PostDTO;
import com.ariguter.marketsdk.callbacks.Callback;
import com.ariguter.marketsdk.repositories.CategoryRepository;

import java.util.List;
import java.util.Map;

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    /**
     * Retrieves all categories for a given market ID.
     *
     * @param marketId The ID of the market.
     * @param callback The callback to handle the response.
     */
    public void getAllCategories(String marketId, Callback<List<CategoryDTO>> callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Callback cannot be null");
        }
        if (marketId == null || marketId.trim().isEmpty()) {
            callback.onError("Market ID cannot be null or empty");
            return;
        }
        categoryRepository.getAllCategories(marketId, callback);
    }

    /**
     * Retrieves a specific category by its ID for a given market ID.
     *
     * @param marketId The ID of the market.
     * @param categoryId The ID of the category.
     * @param callback The callback to handle the response.
     * @return The CategoryDTO object if found, null otherwise.
     */
    public CategoryDTO getCategory(String marketId, String categoryId, Callback<CategoryDTO> callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Callback cannot be null");
        }
        if (marketId == null || marketId.trim().isEmpty()) {
            callback.onError("Market ID cannot be null or empty");
            return null;
        }
        if (categoryId == null || categoryId.trim().isEmpty()) {
            callback.onError("Category ID cannot be null or empty");
            return null;
        }
        return categoryRepository.getCategory(marketId, categoryId, callback);
    }


    /**
     * Retrieves a categories names and there ids for a given market ID.
     *
     * @param marketId The ID of the market.
     * @param callback The callback to handle the response.
     */
    public void getCategoryByName(String marketId, Callback<Map<String,String>> callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Callback cannot be null");
        }
        if (marketId == null || marketId.trim().isEmpty()) {
            callback.onError("Market ID cannot be null or empty");
            return;
        }
        categoryRepository.getCategoryByName(marketId, callback);
    }


    /**
     * Retrieves posts for a specific category in a given market.
     *
     * @param marketId The ID of the market.
     * @param categoryId The ID of the category.
     * @param callback The callback to handle the response.
     */
    public void getCategoryPosts(String marketId, String categoryId, Callback<List<PostDTO>> callback) {
        if (marketId == null || marketId.isEmpty()) {
            callback.onError("Market ID cannot be null or empty");
        }
        if (categoryId == null || categoryId.isEmpty()) {
            callback.onError("User ID cannot be null or empty");
        }
        categoryRepository.getCategoryPosts(marketId,categoryId,callback);
    }
}