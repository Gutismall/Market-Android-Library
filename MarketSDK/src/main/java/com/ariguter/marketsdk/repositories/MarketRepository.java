package com.ariguter.marketsdk.repositories;

import androidx.annotation.NonNull;
import com.ariguter.marketsdk.MarketAPI;
import com.ariguter.marketsdk.DTO.MarketDTO;
import com.ariguter.marketsdk.callbacks.Callback;
import java.util.List;
import retrofit2.Call;
import retrofit2.Response;

public class MarketRepository {
    private final MarketAPI api;

    public MarketRepository(MarketAPI api) {
        this.api = api;
    }

    public void getAllMarkets(Callback<List<MarketDTO>> callback) {
        String url = api.getAllMarkets().request().url().toString();
        android.util.Log.d("MarketRepository", "Requesting URL: " + url);
        api.getAllMarkets().enqueue(new retrofit2.Callback<List<MarketDTO>>() {
            @Override
            public void onResponse(@NonNull Call<List<MarketDTO>> call, @NonNull Response<List<MarketDTO>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("API Error: " + response.code());
                }
            }
            @Override
            public void onFailure(@NonNull Call<List<MarketDTO>> call, @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public void getMarket(String marketId, Callback<MarketDTO> callback) {
        api.getMarket(marketId).enqueue(new retrofit2.Callback<MarketDTO>() {
            @Override
            public void onResponse(@NonNull Call<MarketDTO> call, @NonNull Response<MarketDTO> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("API Error: " + response.code());
                }
            }
            @Override
            public void onFailure(@NonNull Call<MarketDTO> call, @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}