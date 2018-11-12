package com.braintech.browsegithub;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.braintech.browsegithub.models.RepoDetails;

import java.util.ArrayList;
import java.util.List;

public class GitRepoAdapter extends RecyclerView.Adapter<GitRepoAdapter.RepoViewHolder> {

    public static final String REPO_KEY = "REPO_KEY";

    private List<RepoDetails> repoList = new ArrayList<RepoDetails>();

    public class RepoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTitleView;
        public TextView mFullname;
        public TextView mWatchersCount;

        public RepoDetails repo = null;

        public RepoViewHolder(View v) {
            super(v);
            mTitleView = (TextView) v.findViewById(R.id.repoTitle);
            mFullname = (TextView) v.findViewById(R.id.repoFullname);
            mWatchersCount = (TextView) v.findViewById(R.id.repo_watchers);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra(REPO_KEY, repo);
            context.startActivity(intent);
        }
    }

    public GitRepoAdapter() {
        super();
    }

    public void setRepoList(List<RepoDetails> repoList) {
        this.repoList = repoList;
    }

    @Override
    public GitRepoAdapter.RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.repo_row_item, parent, false);
        RepoViewHolder vh = new RepoViewHolder(rootView);
        return vh;
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.mTitleView.setText(repoList.get(position).getTitle());
        holder.mFullname.setText(repoList.get(position).getFullName());
        holder.mWatchersCount.setText(repoList.get(position).getWatchers());
        holder.repo = repoList.get(position);
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }
}
