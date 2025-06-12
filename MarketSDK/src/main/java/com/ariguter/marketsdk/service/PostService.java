package com.ariguter.marketsdk.service;

import static com.ariguter.marketsdk.util.PostValidator.validate;

import android.util.Log;

import com.ariguter.marketsdk.DTO.PostDTO;
import com.ariguter.marketsdk.callbacks.Callback;
import com.ariguter.marketsdk.repositories.PostRepository;

import java.util.List;

public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    /**
     * Retrieves all posts for a given market ID.
     *
     * @param marketId The ID of the market.
     * @param callback The callback to handle the response.
     */
    public void getAllPosts(String marketId, Callback<List<PostDTO>> callback) {
        if (marketId == null || marketId.isEmpty()) {
            callback.onError("Market ID cannot be null or empty");
            return;
        }
        postRepository.getAllPosts(marketId, callback);
    }

    /**
     * Retrieves a specific post by its ID for a given market ID.
     *
     * @param marketId The ID of the market.
     * @param postId   The ID of the post.
     * @param callback The callback to handle the response.
     * @return The PostDTO object if found, null otherwise.
     */
    public PostDTO getPost(String marketId, String postId, Callback<PostDTO> callback) {
        if (marketId == null || marketId.isEmpty()) {
            callback.onError("Market ID cannot be null or empty");
            return null;
        }
        if (postId == null || postId.isEmpty()) {
            callback.onError("Post ID cannot be null or empty");
            return null;
        }
        return postRepository.getPost(marketId, postId, callback);
    }

    /**
     * Creates a new post in the specified market.
     *
     * @param marketId The ID of the market where the post will be created.
     * @param dto      The PostDTO object containing the post details.
     * @param callback The callback to handle the response.
     */
    public void createPost(String marketId, PostDTO dto, Callback<PostDTO> callback) {
        try {
            validate(dto);
            postRepository.createPost(marketId, dto, callback);
        } catch (IllegalArgumentException e) {
            callback.onError(e.getMessage());
        }
    }

    /**
     * Deletes a post by its ID in the specified market.
     *
     * @param marketId The ID of the market.
     * @param postId   The ID of the post to be deleted.
     * @param callback The callback to handle the response.
     */
    public void deletePost(String marketId, String postId, Callback<String> callback) {
        if (marketId == null || marketId.isEmpty()) {
            callback.onError("Market ID cannot be null or empty");
            return;
        }
        if (postId == null || postId.isEmpty()) {
            callback.onError("Post ID cannot be null or empty");
            return;
        }
        postRepository.deletePost(marketId, postId, callback);
    }

    /**
     * Updates an existing post in the specified market.
     *
     * @param marketId The ID of the market where the post exists.
     * @param postId   The ID of the post to be updated.
     * @param dto      The PostDTO object containing the updated post details.
     * @param callback The callback to handle the response.
     */
    public void updatePost(String marketId, String postId, PostDTO dto, Callback<PostDTO> callback) {
        try {
            validate(dto);
            postRepository.updatePost(marketId, postId, dto, callback);
        } catch (IllegalArgumentException e) {
            callback.onError(e.getMessage());
        }
    }

    /**
     * Retrieves all posts created by a specific user in a given market.
     *
     * @param marketId The ID of the market.
     * @param userId   The ID of the user whose posts are to be retrieved.
     * @param callback The callback to handle the response.
     */
    public void getPostByUser(String marketId, String userId, Callback<List<PostDTO>> callback) {
        Log.e("PostService", "getPostByUser called with marketId: " + marketId + ", userId: " + userId);
        if (marketId == null || marketId.isEmpty()) {
            callback.onError("Market ID cannot be null or empty");

        }
        if (userId == null || userId.isEmpty()) {
            callback.onError("User ID cannot be null or empty");

        }
        postRepository.getPostByUser(marketId, userId, callback);
    }
}