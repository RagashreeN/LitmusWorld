package com.litmus.interview.feature.home;

import android.content.Context;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.litmus.interview.common.model.SearchResponse;
import com.litmus.interview.common.model.request.SearchRequest;
import com.litmus.interview.common.utils.LitmusApplication;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter extends MvpBasePresenter<HomeView> {
    HomeView homeView;
    Context context;
    HomePresenter(Context context,HomeView homeView){
        this.context = context;
        this.homeView = homeView;
    }

    public void getSearchList(String searchString){
        if(homeView.isNetworkAvailable()){
            /*SearchRequest searchRequest = new SearchRequest();
            searchRequest.setAction("query");
            searchRequest.setFormat("json");
            searchRequest.setProp("pageimages|pageterms");
            searchRequest.setTitles(searchString);
            searchRequest.setFormatversion("2");*/
            Call call = LitmusApplication.networkService.getNetworkAPI()
                    .getSearchResponse("query","json",
                            "pageimages|pageterms",searchString,"2",
                            "prefixsearch","1","thumbnail",
                            "50","10","description","10");
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    homeView.showOrHideProgress(false);
                    /*ResponseBody responseBody = (ResponseBody) response.body();*/
                    SearchResponse searchResponse = (SearchResponse) response.body();
                    homeView.getResponse(searchResponse);
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    homeView.showOrHideProgress(false);
                }
            });
        }
    }
}
