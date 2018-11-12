package com.braintech.browsegithub.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Repo {
    @SerializedName("total_count")
    @Expose
    Integer totalCount = 0;
    @SerializedName("incomplete_results")
    @Expose
    Boolean isIncomplete;
    @SerializedName("items")
    @Expose
    List<RepoDetails> repoList;


    public List<RepoDetails> getRepoList() {
        return repoList;
    }
}

