package com.litmus.interview.common.model.request;

import com.google.gson.annotations.SerializedName;

public class SearchRequest{

	@SerializedName("formatversion")
	private String formatversion;

	@SerializedName("prop")
	private String prop;

	@SerializedName("format")
	private String format;

	@SerializedName("action")
	private String action;

	@SerializedName("titles")
	private String titles;

	public void setFormatversion(String formatversion){
		this.formatversion = formatversion;
	}

	public String getFormatversion(){
		return formatversion;
	}

	public void setProp(String prop){
		this.prop = prop;
	}

	public String getProp(){
		return prop;
	}

	public void setFormat(String format){
		this.format = format;
	}

	public String getFormat(){
		return format;
	}

	public void setAction(String action){
		this.action = action;
	}

	public String getAction(){
		return action;
	}

	public void setTitles(String titles){
		this.titles = titles;
	}

	public String getTitles(){
		return titles;
	}

	@Override
 	public String toString(){
		return 
			"SearchRequest{" + 
			"formatversion = '" + formatversion + '\'' + 
			",prop = '" + prop + '\'' + 
			",format = '" + format + '\'' + 
			",action = '" + action + '\'' + 
			",titles = '" + titles + '\'' + 
			"}";
		}
}