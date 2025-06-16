# 📦 MarketSDK

**MarketSDK** is an Android library module that simplifies interaction with your Market backend. It provides:

- 3 DTO classes (`MarketDTO`, `CategoryDTO`, `PostDTO`) defining the data models.
- Repository-style service classes to perform API operations: fetch data, create, update, delete.
- Configurable `MarketSDK.initialize(...)` to set your API key and endpoint before use.

## 🔄 Basic Structure

```
com.ariguter.marketsdk
├── MarketSDK.java          // Singleton initializer
├── DTO/
│   ├── MarketDTO.java
│   ├── CategoryDTO.java
│   └── PostDTO.java
├── callbacks/
│   └── Callback.java       // Generic async callback interface
├── repositories/
│   ├── MarketRepository.java
│   ├── CategoryRepository.java
│   └── PostRepository.java
└── services/
    └── MarketAPI.java     // Retrofit interface defining endpoints
```

## 🧩 How the Data Flow Works

1. Define your DTOs in `DTO/` to mirror your backend JSON models.
2. `MarketAPI` maps HTTP endpoints using Retrofit annotations.
3. Repositories wrap network calls into async methods:  
   ```java
   postRepository.getAllPosts(marketId, callback);
   ```
4. Data returns asynchronously via the `Callback<T>`.

### DTO Class Overview

#### 1. `UserDTO`
Represents a user entity used for SDK authentication and identification.
```ts
interface UserDTO {
  email: string;
  appId: string;
}
```

#### 2. `MarketDTO`
Represents a market object retrieved or sent to the server.
```ts
interface MarketDTO {
  id: string;
  appId: string;
  name: string;
  description: string;
  createdAt: string;
}
```

#### 3. `PostDTO`
Represents an individual post in a market.
```ts
interface PostDTO {
  id: string;
  marketId: string;
  title: string;
  description: string;
  price: number;
  imageUrl: string;
  createdAt: string;
}
```

## Service Classes Overview



These classes expose public functions for developers to interact with the SDK.

### `MarketService`
- `getAllMarkets(callback)`: Fetches all markets related to the appId.
- `getMarket(marketId, callback)`: Fetches a specific market by its ID.

### `PostService`
- `getAllPosts(marketId, callback)`: Fetches all posts in a given market.
- `getPost(marketId, postId, callback)`: Fetches a specific post by ID.
- `createPost(marketId, dto, callback)`: Creates a new post in the market.
- `deletePost(marketId, postId, callback)`: Deletes a post by its ID.
- `updatePost(marketId, postId, dto, callback)`: Updates a post.
- `getPostByUser(marketId, userId, callback)`: Retrieves all posts created by a specific user.

### `CategoryService`
- `getAllCategories(marketId, callback)`: Retrieves all categories for a market.
- `getCategory(marketId, categoryId, callback)`: Retrieves a specific category.
- `getCategoryByName(marketId, callback)`: Fetches category names and IDs.
- `getCategoryPosts(marketId, categoryId, callback)`: Fetches all posts under a specific category.

---