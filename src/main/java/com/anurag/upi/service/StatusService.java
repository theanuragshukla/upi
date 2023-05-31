package com.anurag.upi.service;

import com.anurag.upi.Status;
import org.springframework.stereotype.Service;


@Service
public class StatusService {
    public Status getStatus(){
        return new Status() ;
    }
}
