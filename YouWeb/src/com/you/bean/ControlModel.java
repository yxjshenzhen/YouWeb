package com.you.bean;

import java.sql.Date;

public class ControlModel {
	
	private int ControlModelId;
	private int ControlModelOpen;
	private int ControlModelClose;
	private String ControlModelName;
	private String ControlModelWhere;
	private boolean ControlModelState;
	private Date ControlTime;
	
	public ControlModel(){
		
	}
	
	public int getControlModelId() {
		return ControlModelId;
	}
	public void setControlModelId(int controlModelId) {
		ControlModelId = controlModelId;
	}
	public int getControlModelOpen() {
		return ControlModelOpen;
	}
	public void setControlModelOpen(int controlModelOpen) {
		ControlModelOpen = controlModelOpen;
	}
	public int getControlModelClose() {
		return ControlModelClose;
	}
	public void setControlModelClose(int controlModelClose) {
		ControlModelClose = controlModelClose;
	}
	public String getControlModelName() {
		return ControlModelName;
	}
	public void setControlModelName(String controlModelName) {
		ControlModelName = controlModelName;
	}
	public String getControlModelWhere() {
		return ControlModelWhere;
	}
	public void setControlModelWhere(String controlModelWhere) {
		ControlModelWhere = controlModelWhere;
	}
	public boolean isControlModelState() {
		return ControlModelState;
	}
	public void setControlModelState(boolean controlModelState) {
		ControlModelState = controlModelState;
	}
	public Date getControlTime() {
		return ControlTime;
	}
	public void setControlTime(Date controlTime) {
		ControlTime = controlTime;
	}

}
