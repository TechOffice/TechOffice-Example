package com.ittechoffice.webcrawl.fap.hkex.stock.model;

public class Stock {
	private String stockCode;
	private String name;
	private String chiName;
	
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChiName(){
		return chiName;
	}
	public void setChiName(String chiName){
		this.chiName = chiName;
	}
}
