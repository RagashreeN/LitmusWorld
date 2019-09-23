package com.litmus.interview.feature.home;


import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.litmus.interview.common.model.SearchResponse;

public interface HomeView extends MvpView {
    boolean isNetworkAvailable();
    public void showOrHideProgress(boolean showOrHide);
    public void getResponse(SearchResponse searchResponse);
    public void getClickedPosition(int position);
}
