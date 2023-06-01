package com.anurag.upi.modals;
public class StatusResponse {
    public boolean status;
    public String msg;
    public StatusResponse(){
        this.status = true;
        this.msg = "Server is up and running";
    }

}