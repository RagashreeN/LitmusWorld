package com.litmus.interview.common.rest;

import com.litmus.interview.common.model.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkAPI {

    @GET("/w/api.php")
    Call<SearchResponse> getSearchResponse(@Query("action") String query,
                                                  @Query("format") String jsonString,
                                                  @Query("prop") String propString,
                                                  @Query("gpssearch") String searchTitle,
                                                  @Query("formatversion") String version,
                                           @Query("generator") String generator,
                                           @Query("redirects") String redirects,
                                           @Query("piprop") String thumbnail,
                                           @Query("pithumbsize") String pithumbsize,
                                           @Query("pilimit") String pilimit,
                                           @Query("wbptterms") String wbptterms,
                                           @Query("gpslimit") String gpslimit);

    /*@GET("/w/api.php")
    Call<SearchResponse> getSearchResponse(@Query("action") String query,
                                           @Query("format") String jsonString,
                                           @Query("prop") String propString,
                                           @Query("titles") String searchTitle,
                                           @Query("formatversion") String version);*/

}
