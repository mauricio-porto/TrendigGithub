package com.braintech.browsegithub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.braintech.browsegithub.models.Repo;
import com.braintech.browsegithub.models.RepoDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    GithubSearchAPI githubSearchAPI;

    private LinearLayoutManager layoutMgr;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView();

        createRetrofit();
        fetchRepos();
    }

    private void setupRecyclerView() {
        layoutMgr = new LinearLayoutManager(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(layoutMgr);

        mAdapter = new GitRepoAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });

    }

    private void createRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GithubSearchAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        githubSearchAPI = retrofit.create(GithubSearchAPI.class);
    }

    private void fetchRepos() {
        Call<Repo> callRepos = githubSearchAPI.getTrendingAndroidRepos();
        callRepos.enqueue(new Callback<Repo>() {
            @Override
            public void onResponse(Call<Repo> call, Response<Repo> response) {
                Log.d("TAG", response.code()+"");
                Repo repo = response.body();
                List<RepoDetails>  repoList = repo.getRepoList();
                ((GitRepoAdapter)mAdapter).setRepoList(repoList);
                mAdapter.notifyDataSetChanged();
/*
                for (RepoDetails repoDetails : repoList) {
                    Log.d(TAG, repoDetails.toString());
                }
*/
                Log.d(TAG, "Done");
           }

            @Override
            public void onFailure(Call<Repo> call, Throwable t) {
                call.cancel();
                Log.e(TAG, "Cancelled");
            }
        });

    }

}
