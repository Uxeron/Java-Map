package com.uxeron.map;

import com.badlogic.gdx.graphics.g2d.Sprite;

class Flag {
	private Sprite spr;
	private String country = "";
	private String code = "";
	private String businessName = "";
	private String additionalInfo = "";
	private boolean toBeDeleted = false;


	public Flag(Sprite spr, float posx, float posy) {
		this.spr = spr;
		this.spr.setPosition(posx-3.3f, posy-1);
		this.spr.setSize(10, 10);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public Sprite getSpr() {
		return spr;
	}

	public boolean isToBeDeleted() {
		return toBeDeleted;
	}

	public void setToBeDeleted(boolean toBeDeleted) {
		this.toBeDeleted = toBeDeleted;
	}
}