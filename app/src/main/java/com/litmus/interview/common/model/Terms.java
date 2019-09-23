package com.litmus.interview.common.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Terms{

	@SerializedName("alias")
	private List<String> alias;

	@SerializedName("description")
	private List<String> description;

	@SerializedName("label")
	private List<String> label;

	public void setAlias(List<String> alias){
		this.alias = alias;
	}

	public List<String> getAlias(){
		return alias;
	}

	public void setDescription(List<String> description){
		this.description = description;
	}

	public List<String> getDescription(){
		return description;
	}

	public void setLabel(List<String> label){
		this.label = label;
	}

	public List<String> getLabel(){
		return label;
	}

	@Override
 	public String toString(){
		return 
			"Terms{" + 
			"alias = '" + alias + '\'' + 
			",description = '" + description + '\'' + 
			",label = '" + label + '\'' + 
			"}";
		}
}