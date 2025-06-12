package com.ariguter.marketsdk.repositories;

import static java.util.Collections.emptyList;

import android.util.Log;

import androidx.annotation.NonNull;
import com.ariguter.marketsdk.MarketAPI;
import com.ariguter.marketsdk.DTO.PostDTO;
import com.ariguter.marketsdk.callbacks.Callback;

import java.util.Collection;
import java.util.List;
import retrofit2.Call;
import retrofit2.Response;

public class PostRepository {

    private final MarketAPI api;

    public PostRepository(MarketAPI api) {
        this.api = api;
    }

    public List<PostDTO> getAllPosts(String marketId, Callback<List<PostDTO>> callback) {
        api.getAllPosts(marketId).enqueue(new retrofit2.Callback<List<PostDTO>>() {
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
        return null;
    }

    public PostDTO getPost(String marketId, String postId, Callback<PostDTO> callback) {
        api.getPost(marketId, postId).enqueue(new retrofit2.Callback<PostDTO>() {
            @Override
            public void onResponse(@NonNull Call<PostDTO> call, @NonNull Response<PostDTO> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("API Error: " + response.code());
                }
            }
            @Override
            public void onFailure(@NonNull Call<PostDTO> call, @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
        return null;
    }

    public void createPost(String marketId, PostDTO dto, Callback<PostDTO> callback) {
        Log.e("PostDTO : ", String.valueOf(dto));
        api.createPost(marketId, dto).enqueue(new retrofit2.Callback<PostDTO>() {
            @Override
            public void onResponse(@NonNull Call<PostDTO> call, @NonNull Response<PostDTO> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("API Error: " + response.code());
                }
            }
            @Override
            public void onFailure(@NonNull Call<PostDTO> call, @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public Response deletePost(String marketId, String postId, Callback<String> callback) {
        api.deletePost(marketId, postId).enqueue(new retrofit2.Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess("Post deleted successfully");
                } else {
                    callback.onError("API Error: " + response.code());
                }
            }
            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
        return null;
    }

    public void updatePost(String marketId, String postId, PostDTO dto, Callback<PostDTO> callback) {
        api.updatePost(marketId, postId, dto).enqueue(new retrofit2.Callback<PostDTO>() {
            @Override
            public void onResponse(@NonNull Call<PostDTO> call, @NonNull Response<PostDTO> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("API Error: " + response.code());
                }
            }
            @Override
            public void onFailure(@NonNull Call<PostDTO> call, @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
    public void getPostByUser(String marketId, String userId, Callback<List<PostDTO>> callback) {
        Log.e("PostRepository", "getPostByUser called with marketId: " + marketId + ", userId: " + userId);
        api.getPostByUser(marketId, userId).enqueue(new retrofit2.Callback<List<PostDTO>>() {
            @Override
            public void onResponse(Call<List<PostDTO>> call, Response<List<PostDTO>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError(null);
                }
            }

            @Override
            public void onFailure(Call<List<PostDTO>> call, Throwable t) {

            }
        });
    }
}
