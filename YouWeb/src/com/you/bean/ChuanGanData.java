package com.you.bean;

import java.util.Date;

public class ChuanGanData {
	private int ChuanGanDataId;
	
	private int YanWu;
	private int TuRang;
	private int YuShui;
	private int GuangMin;
	private int WenDu;
	private int ShiDu;
	private String DataTime;
	
	public ChuanGanData(){
		
	}
	
	public int getChuanGanDataId() {
		return ChuanGanDataId;
	}

	public void setChuanGanDataId(int chuanGanDataId) {
		ChuanGanDataId = chuanGanDataId;
	}

	public String getDataTime() {
		return DataTime;
	}

	public void setDataTime(String dataTime) {
		DataTime = dataTime;
	}
	
	public int getYanWu() {
		return YanWu;
	}
	public void setYanWu(int yanWu) {
		YanWu = yanWu;
	}
	public int getTuRang() {
		return TuRang;
	}
	public void setTuRang(int tuRang) {
		TuRang = tuRang;
	}
	public int getYuShui() {
		return YuShui;
	}
	public void setYuShui(int yuShui) {
		YuShui = yuShui;
	}
	public int getGuangMin() {
		return GuangMin;
	}
	public void setGuangMin(int guangMin) {
		GuangMin = guangMin;
	}
	public int getWenDu() {
		return WenDu;
	}
	public void setWenDu(int wenDu) {
		WenDu = wenDu;
	}
	public int getShiDu() {
		return ShiDu;
	}
	public void setShiDu(int shiDu) {
		ShiDu = shiDu;
	}
	

}
