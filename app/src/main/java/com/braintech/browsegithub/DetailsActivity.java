package com.braintech.browsegithub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.braintech.browsegithub.models.RepoDetails;

public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = DetailsActivity.class.getSimpleName();

    private TextView vTitle;
    private TextView vFullname;
    private TextView vDescription;
    private TextView vWatchers;
    private TextView vForks;
    private TextView vLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_details);

        this.vTitle = (TextView) findViewById(R.id.repo_title);
        this.vFullname = (TextView) findViewById(R.id.repo_full_name);
        this.vDescription = (TextView) findViewById(R.id.repo_description);
        this.vWatchers = (TextView) findViewById(R.id.repo_watchers);
        this.vForks = (TextView) findViewById(R.id.repo_forks);
        this.vLanguage = (TextView) findViewById(R.id.repo_language);

        Intent intent = this.getIntent();
        RepoDetails repoDetails = intent.getParcelableExtra(GitRepoAdapter.REPO_KEY);

        refreshContent(repoDetails);

    }

    private void refreshContent(RepoDetails repo) {
        this.vTitle.setText(repo.getTitle());
        this.vFullname.setText(repo.getFullName());
        this.vDescription.setText(repo.getDescription());
        this.vWatchers.setText(repo.getWatchers());
        this.vForks.setText(repo.getForks());
        this.vLanguage.setText(repo.getLanguage());
    }
}
