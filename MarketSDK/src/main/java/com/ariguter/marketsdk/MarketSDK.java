package com.ariguter.marketsdk;

import com.ariguter.marketsdk.DTO.MarketDTO;
import com.ariguter.marketsdk.callbacks.Callback;
import com.ariguter.marketsdk.repositories.CategoryRepository;
import com.ariguter.marketsdk.repositories.MarketRepository;
import com.ariguter.marketsdk.repositories.PostRepository;
import com.ariguter.marketsdk.service.CategoryService;
import com.ariguter.marketsdk.service.MarketService;
import com.ariguter.marketsdk.service.PostService;

public class MarketSDK {
    private static MarketSDK instance;

    private final PostService postService;
    private final MarketService marketService;
    private final CategoryService categoryService;

    public MarketSDK(String appId) {
        RetrofitClient retrofitClient = new RetrofitClient("http://spring-market-api-env-1.eba-wkfe6epf.eu-north-1.elasticbeanstalk.com/api/"+appId+"/");
        MarketAPI api = retrofitClient.getMarketAPI();

        this.postService = new PostService(new PostRepository(api));
        this.marketService = new MarketService(new MarketRepository(api));
        this.categoryService = new CategoryService(new CategoryRepository(api));
    }
    /**
     * Initializes the MarketSDK singleton .
     * Call this before using getInstance().
     */
    public static synchronized void initialize(String appId) {
        if (instance == null) {
            instance = new MarketSDK(appId);
        }

        
    }
    /**
     * Returns the singleton instance of MarketSDK.
     * @return the MarketSDK instance
     * @throws IllegalStateException if not initialized
     */

    public static MarketSDK getInstance() {
        if (instance == null) {
            throw new IllegalStateException("MarketSDK is not initialized. Call initialize() first.");
        }
        return instance;
    }



    /**
     * Returns the Post Service instance for managing posts.
     * @return the PostService instance
     */
    public PostService getPostService() {
        return postService;
    }
    /**
     * Returns the Market Service instance for managing markets.
     * @return the MarketService instance
     */
    public MarketService getMarketService() {
        return marketService;
    }

    /**
     * Returns the Category Service instance for managing categories.
     * @return the CategoryService instance
     */
    public CategoryService getCategoryService() {
        return categoryService;
    }
}
