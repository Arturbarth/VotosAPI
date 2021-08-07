package com.arturbarth.VotosAPI.v1.controller.dto.response;

public class ValidaCpfResponse {

    private String status;

     public ValidaCpfResponse(){
         
     }

    public ValidaCpfResponse(String status) {
        this.status = status;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
