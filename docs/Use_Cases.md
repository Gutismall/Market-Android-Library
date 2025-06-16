# 📘 SDK Usage Examples

This document provides common use cases of the MarketSDK for Android.

---

## 🟩 1. Initialize the SDK

Before making any calls, initialize the SDK with the app ID:

```java
MarketSDK.initialize("your-app-id");
```

---

## 🟦 2. Fetch All Markets

Used to fetch all markets available for an app:

```java
marketSDK.getMarketService().getAllMarkets(new Callback<List<MarketDTO>>() {
    @Override
    public void onSuccess(List<MarketDTO> data) {
        // Save or display market data
    }

    @Override
    public void onError(String errorMessage) {
        // Handle error
    }
});
```

---

## 🟨 3. Create a New Post

Used to create a post within a category:

```java
PostDTO post = new PostDTO("All DTO Content");
marketSDK.getPostService().createPost("marketId", post, new Callback<PostDTO>() {
    @Override
    public void onSuccess(PostDTO createdPost) {
        // Get back the post that was created with all its new variables 
    }

    @Override
    public void onError(String error) {
        // Handle failure
    }
});
```

---

## 🟪 4. Get All Categories for a Market

```java
marketSDK.getCategoryService().getAllCategories("marketId", new Callback<List<CategoryDTO>>() {
    @Override
    public void onSuccess(List<CategoryDTO> categories) {
        // Handle category list
    }

    @Override
    public void onError(String error) {
        // Handle error
    }
});
```

---

## 🟥 5. Fetch Posts by User

```java
marketSDK.getPostService().getPostByUser("marketId", "userId", new Callback<List<PostDTO>>() {
    @Override
    public void onSuccess(List<PostDTO> posts) {
        // Show posts
    }

    @Override
    public void onError(String error) {
        // Handle error
    }
});
```
