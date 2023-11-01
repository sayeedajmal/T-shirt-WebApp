package com.Strong.Tshirt_Web.Utils;

/**
 * TShirtErrorResponse
 */
public class TShirtErrorResponse {

    private Integer Status;
    private String Message;
    private long Timestamp;

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public long getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(long timestamp) {
        Timestamp = timestamp;
    }

}