package com.ariguter.marketsdk;

import com.ariguter.marketsdk.DTO.CategoryDTO;
import com.ariguter.marketsdk.DTO.MarketDTO;
import com.ariguter.marketsdk.DTO.PostDTO;

import kotlin.ParameterName;
import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;
import java.util.Map;

public interface MarketAPI {

    // MarketController Endpoints
    @GET("markets")
    Call<List<MarketDTO>> getAllMarkets();

    @GET("{marketId}")
    Call<MarketDTO> getMarket(@Path("marketId") String marketId);

    // CategoryController Endpoints
    @GET("{marketId}/category")
    Call<List<CategoryDTO>> getAllCategories( @Path("marketId") String marketId);

    @GET("{marketId}/category/{categoryId}")
    Call<CategoryDTO> getCategory( @Path("marketId") String marketId, @Path("categoryId") String categoryId);


    // PostController Endpoints
    @GET("markets/{marketId}/posts")
    Call<List<PostDTO>> getAllPosts(@Path("marketId") String marketId);

    @GET("markets/{marketId}/posts/{postId}")
    Call<PostDTO> getPost(@Path("marketId") String marketId, @Path("postId") String postId);

    @POST("markets/{marketId}/posts")
    Call<PostDTO> createPost(@Path("marketId") String marketId, @Body PostDTO post);

    @DELETE("markets/{marketId}/posts/{postId}")
    Call<Void> deletePost(@Path("marketId") String marketId, @Path("postId") String postId);

    @POST("markets/{marketId}/posts/{postId}")
    Call<PostDTO> updatePost(@Path("marketId") String marketId, @Path("postId") String postId, @Body PostDTO post);

    @GET("markets/{marketId}/posts")
    Call<List<PostDTO>> getPostByUser(@Path("marketId") String marketId, @Query("userId") String userId);

    @GET("{marketId}/category/names")
    Call<Map<String,String>> getCategoriesByName(@Path("marketId") String marketId);

    @GET("{marketId}/category/{categoryId}/posts")
    Call<List<PostDTO>> getCategoryPosts(@Path("marketId") String marketId, @Path("categoryId") String categoryId);
}
