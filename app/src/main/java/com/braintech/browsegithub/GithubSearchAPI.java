package com.braintech.browsegithub;

import com.braintech.browsegithub.models.Repo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubSearchAPI {
    String BASE_URL = "https://api.github.com";

    @GET("search/repositories?q=android%20language:java&sort=stars&order=desc&per_page=60")
    Call<Repo> getTrendingAndroidRepos();
}
