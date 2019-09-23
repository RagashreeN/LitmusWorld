package com.litmus.interview.common.model;


import com.google.gson.annotations.SerializedName;


public class SearchResponse{

	@SerializedName("batchcomplete")
	private boolean batchcomplete;

	@SerializedName("query")
	private Query query;

	public void setBatchcomplete(boolean batchcomplete){
		this.batchcomplete = batchcomplete;
	}

	public boolean isBatchcomplete(){
		return batchcomplete;
	}

	public void setQuery(Query query){
		this.query = query;
	}

	public Query getQuery(){
		return query;
	}

	@Override
 	public String toString(){
		return 
			"SearchResponse{" + 
			"batchcomplete = '" + batchcomplete + '\'' + 
			",query = '" + query + '\'' + 
			"}";
		}
}