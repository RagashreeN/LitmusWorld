package com.litmus.interview.common.model;


import com.google.gson.annotations.SerializedName;


public class PagesItem{

	@SerializedName("thumbnail")
	private Thumbnail thumbnail;

	@SerializedName("pageimage")
	private String pageimage;

	@SerializedName("ns")
	private int ns;

	@SerializedName("terms")
	private Terms terms;

	@SerializedName("pageid")
	private int pageid;

	@SerializedName("title")
	private String title;

	public void setThumbnail(Thumbnail thumbnail){
		this.thumbnail = thumbnail;
	}

	public Thumbnail getThumbnail(){
		return thumbnail;
	}

	public void setPageimage(String pageimage){
		this.pageimage = pageimage;
	}

	public String getPageimage(){
		return pageimage;
	}

	public void setNs(int ns){
		this.ns = ns;
	}

	public int getNs(){
		return ns;
	}

	public void setTerms(Terms terms){
		this.terms = terms;
	}

	public Terms getTerms(){
		return terms;
	}

	public void setPageid(int pageid){
		this.pageid = pageid;
	}

	public int getPageid(){
		return pageid;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"PagesItem{" + 
			"thumbnail = '" + thumbnail + '\'' + 
			",pageimage = '" + pageimage + '\'' + 
			",ns = '" + ns + '\'' + 
			",terms = '" + terms + '\'' + 
			",pageid = '" + pageid + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}