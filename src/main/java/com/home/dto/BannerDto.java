package com.home.dto;

public class BannerDto {
	
	private String url  ;//路径
	
	private String width ;//宽
	
	private String height ;//高
	
	private String postfix ;//后缀
	
	private String banStatus ;//禁用状态   1 ：禁用， 2 ： 可用

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getPostfix() {
		return postfix;
	}

	public void setPostfix(String postfix) {
		this.postfix = postfix;
	}

	public String getBanStatus() {
		return banStatus;
	}

	public void setBanStatus(String banStatus) {
		this.banStatus = banStatus;
	}
	
	

}
