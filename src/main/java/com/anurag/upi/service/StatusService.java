package com.anurag.upi.service;

import com.anurag.upi.modals.StatusResponse;
import org.springframework.stereotype.Service;


@Service
public class StatusService {
    public StatusResponse getStatus(){
        return new StatusResponse() ;
    }
}
