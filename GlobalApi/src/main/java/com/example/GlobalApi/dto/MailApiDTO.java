package com.example.GlobalApi.dto;

import org.springframework.web.multipart.MultipartFile;

public class MailApiDTO {

	private String apiEndPoint;
	private String errorMessage;
	private String currentTimeStamp;
	private String screenName;
	private String requestPayload;
	private String apiResponse;
	private String currentLoggedInUser;
	private MultipartFile screenPrint;
	private String browserName;
	private String comments; //new field

	public String getApiEndPoint() {
		return apiEndPoint;
	}

	public void setApiEndPoint(String apiEndPoint) {
		this.apiEndPoint = apiEndPoint;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getCurrentTimeStamp() {
		return currentTimeStamp;
	}

	public void setCurrentTimeStamp(String currentTimeStamp) {
		this.currentTimeStamp = currentTimeStamp;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getRequestPayload() {
		return requestPayload;
	}

	public void setRequestPayload(String requestPayload) {
		this.requestPayload = requestPayload;
	}

	public String getApiResponse() {
		return apiResponse;
	}

	public void setApiResponse(String apiResponse) {
		this.apiResponse = apiResponse;
	}

	public String getCurrentLoggedInUser() {
		return currentLoggedInUser;
	}

	public void setCurrentLoggedInUser(String currentLoggedInUser) {
		this.currentLoggedInUser = currentLoggedInUser;
	}

	public MultipartFile getScreenPrint() {
		return screenPrint;
	}

	public void setScreenPrint(MultipartFile screenPrint) {
		this.screenPrint = screenPrint;
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments; //new add
	}

	@Override
	public String toString() {
		return "MailApiDTO [apiEndPoint=" + apiEndPoint + ", errorMessage=" + errorMessage + ", currentTimeStamp="
				+ currentTimeStamp + ", screenName=" + screenName + ", requestPayload=" + requestPayload
				+ ", apiResponse=" + apiResponse + ", currentLoggedInUser=" + currentLoggedInUser + ", screenPrint="
				+ screenPrint + ", browserName=" + browserName + ",comments=" + comments + "]";
	}

}
