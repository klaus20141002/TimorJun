package com.timorjun.home.dto;

import java.util.List;

public class BannerInfoDto {
	List<BannerDto> banners ;

	public List<BannerDto> getBanners() {
		return banners;
	}

	public void setBanners(List<BannerDto> banners) {
		this.banners = banners;
	}

	@Override
	public String toString() {
		return "BannerInfoDto [banners=" + banners + "]";
	}
	

}
