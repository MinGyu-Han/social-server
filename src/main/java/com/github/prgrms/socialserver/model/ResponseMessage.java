package com.github.prgrms.socialserver.model;

public class ResponseMessage {
    private boolean success;
    private String response;

    public ResponseMessage(boolean success, String response) {
        this.success = success;
        this.response = response;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
