package com.ariguter.marketsdk.service;

import static com.ariguter.marketsdk.util.MarketValidator.validate;

import com.ariguter.marketsdk.DTO.MarketDTO;
import com.ariguter.marketsdk.callbacks.Callback;
import com.ariguter.marketsdk.repositories.MarketRepository;
import java.util.List;

public class MarketService {

    private final MarketRepository marketRepository;

    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }


    /**
     * Get all the markets available in the system for the app id.
     * @param callback  the callback to handle success or error
     */
    public void getAllMarkets(Callback<List<MarketDTO>> callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Callback cannot be null");
        }
        marketRepository.getAllMarkets(callback);
    }

    public void getMarket(String marketId, Callback<MarketDTO> callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Callback cannot be null");
        }
        if (marketId == null || marketId.trim().isEmpty()) {
            callback.onError("Market ID cannot be null or empty");
            return;
        }
        marketRepository.getMarket(marketId, callback);
    }
}