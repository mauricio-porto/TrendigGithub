package com.braintech.browsegithub.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RepoDetails implements Parcelable {

    @SerializedName("name")
    @Expose
    String title;

    @SerializedName("full_name")
    @Expose
    String fullName;

    @SerializedName("description")
    @Expose
    String description;

    @SerializedName("language")
    @Expose
    String language;

    @SerializedName("watchers")
    @Expose
    String watchers;

    @SerializedName("forks")
    @Expose
    String forks;

    @SerializedName("url")
    @Expose
    String url;

    public RepoDetails() {
        super();
    }

    private RepoDetails(Parcel in) {
        super();
        title = in.readString();
        fullName = in.readString();
        description = in.readString();
        language = in.readString();
        watchers = in.readString();
        forks = in.readString();
        url = in.readString();
    }

    public String getTitle() {
        return title;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public String getWatchers() {
        return watchers;
    }

    public String getForks() {
        return forks;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        StringBuilder bldr = new StringBuilder();
        bldr.append("Title: ").append(title).append(", Fullname: ").append(fullName).append(", Description: ").append(description);
        return bldr.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(fullName);
        dest.writeString(description);
        dest.writeString(language);
        dest.writeString(watchers);
        dest.writeString(forks);
        dest.writeString(url);
    }

    public static final Parcelable.Creator<RepoDetails> CREATOR = new Parcelable.Creator<RepoDetails>() {
        @Override
        public RepoDetails createFromParcel(Parcel in) {
            return new RepoDetails(in);
        }

        @Override
        public RepoDetails[] newArray(int size) {
            return new RepoDetails[size];
        }
    };
}
