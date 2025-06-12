package com.ariguter.marketsdk.repositories;

import androidx.annotation.NonNull;

import com.ariguter.marketsdk.DTO.PostDTO;
import com.ariguter.marketsdk.MarketAPI;
import com.ariguter.marketsdk.DTO.CategoryDTO;
import com.ariguter.marketsdk.callbacks.Callback;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

public class CategoryRepository {
    private final MarketAPI api;

    public CategoryRepository(MarketAPI api) {
        this.api = api;
    }

    public void getAllCategories(String marketId, Callback<List<CategoryDTO>> callback) {
        api.getAllCategories(marketId).enqueue(new retrofit2.Callback<List<CategoryDTO>>() {
            @Override
            public void onResponse(@NonNull Call<List<CategoryDTO>> call, @NonNull Response<List<CategoryDTO>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("API Error: " + response.code());
                }
            }
            @Override
            public void onFailure(@NonNull Call<List<CategoryDTO>> call, @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public CategoryDTO getCategory(String marketId, String categoryId, Callback<CategoryDTO> callback) {
        api.getCategory(marketId, categoryId).enqueue(new retrofit2.Callback<CategoryDTO>() {
            @Override
            public void onResponse(@NonNull Call<CategoryDTO> call, @NonNull Response<CategoryDTO> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("API Error: " + response.code());
                }
            }
            @Override
            public void onFailure(@NonNull Call<CategoryDTO> call, @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
        return null;
    }

    public void getCategoryByName(String marketId, Callback<Map<String, String>> callback) {
        api.getCategoriesByName(marketId).enqueue(new retrofit2.Callback<Map<String, String>>() {
            @Override
            public void onResponse(@NonNull Call<Map<String, String>> call, @NonNull Response<Map<String, String>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("API Error: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Map<String, String>> call, @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public void getCategoryPosts(String marketId, String categoryId, Callback<List<PostDTO>> callback) {
        api.getCategoryPosts(marketId, categoryId).enqueue(new retrofit2.Callback<List<PostDTO>>() {
            @Override
            public void onResponse(@NonNull Call<List<PostDTO>> call, @NonNull Response<List<PostDTO>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("API Error: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<PostDTO>> call, @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}