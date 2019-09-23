package com.litmus.interview.feature.home;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.litmus.interview.R;
import com.litmus.interview.common.model.PagesItem;
import com.litmus.interview.common.model.SearchResponse;
import com.litmus.interview.common.utils.SearchListAdapter;
import com.litmus.interview.feature.webview.WebviewActivity;
import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends MvpActivity<HomeView, HomePresenter> implements HomeView {

    SearchView searchView;
    RecyclerView recyclerView;
    FrameLayout frame_progress;
    private List<PagesItem> listdata = new ArrayList<>();
    SearchListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Note : Initializing UI*/
        initializeUI();
    }

    @NonNull
    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter(this, this);
    }

    /*Note : Initializing UI*/
    public void initializeUI() {
        /*Note : Initializing UI*/
        searchView = (SearchView) findViewById(R.id.search_view);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        frame_progress = (FrameLayout) findViewById(R.id.frame_progress);

        /*Note : Initializing and Setting Adapter*/
        adapter = new SearchListAdapter(listdata, this, this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        /*Note : Searchview setting initialization*/
        searchView.setIconifiedByDefault(true);
        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.requestFocusFromTouch();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                /*Note : Showing the loading progress bar*/
                showOrHideProgress(true);
                /*Note : Calling search api by passing sarch string*/
                presenter.getSearchList(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                /*Note : Showing the loading progress bar*/
                showOrHideProgress(true);
                /*Note : Calling search api by passing sarch string*/
                presenter.getSearchList(newText);
                return false;
            }
        });
    }

    @Override
    public boolean isNetworkAvailable() {
        /*Note : Checking for internet*/
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    @Override
    public void showOrHideProgress(boolean showOrHide) {
        /*Note : Showing or hiding Progressbar*/
        if (showOrHide) {
            frame_progress.setVisibility(View.VISIBLE);
        } else {
            frame_progress.setVisibility(View.GONE);
        }
    }

    @Override
    public void getResponse(SearchResponse searchResponse) {
        /*Note : Getting the search result and setting into adapter*/
        if (searchResponse != null && searchResponse.getQuery() != null && searchResponse.getQuery().getPages() != null) {
            listdata = searchResponse.getQuery().getPages();
            adapter = new SearchListAdapter(listdata, this, this);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void getClickedPosition(int position) {
        /*Note : On item click, passing search text to display webview*/
        if (listdata.size() > position) {
            Intent intent = new Intent(this, WebviewActivity.class);
            intent.putExtra("searchName", listdata.get(position).getTitle());
            startActivity(intent);
        }
    }
}
