package com.ariguter.marketsdk.DTO;


import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.*;


/**
 * Data Transfer Object representing a post in the market system.
 * <p>
 * Contains all relevant information about a post, such as its ID, title,
 * description, price, images, user, category, market, location, and creation date.
 * used for transferring data between the server and the application.
 * </p>
 */
public class PostDTO implements Serializable {
    public PostDTO(String postId, String title, String description, double price, List<String> images, String userID, String categoryId, String marketId, String country, String city, Date createdAt) {
        this.postId = postId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.images = images;
        this.userID = userID;
        this.categoryId = categoryId;
        this.marketId = marketId;
        this.country = country;
        this.city = city;
        this.createdAt = createdAt;
    }

    private String postId;
    private String title;
    private String description;
    private double price;
    private List<String> images;
    private String userID;
    private String categoryId;
    private String marketId;
    private String country;
    private String city;
    private Date createdAt;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryIds) {
        this.categoryId = categoryIds;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    @NonNull
    @Override
    public String toString() {
        return "PostDTO{" +
                "postId='" + postId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", images=" + images +
                ", userID='" + userID + '\'' +
                ", categoryIds=" + categoryId +
                ", marketId='" + marketId + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
