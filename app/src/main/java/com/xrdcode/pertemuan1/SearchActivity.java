package com.xrdcode.pertemuan1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.xrdcode.pertemuan1.utilities.NetworkUtils;

import java.net.URL;

public class SearchActivity extends AppCompatActivity {

    private EditText searchBox;
    private TextView UrlDisplay, searchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchBox = (EditText) findViewById(R.id.et_search_box);
        UrlDisplay = (TextView) findViewById(R.id.tv_url_display);
        searchResult = (TextView) findViewById(R.id.tv_github_search_results_json);
    }

    private void makeGithubQuery() {
        String githubQuery = searchBox.getText().toString();
        URL githubSearchUrl = NetworkUtils.buildUrl(githubQuery);
        UrlDisplay.setText(githubSearchUrl.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int clicked = item.getItemId();
        switch (clicked) {
            case R.id.action_search:
                makeGithubQuery();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
