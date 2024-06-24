package com.example.rentacar.business.abstracts;

import com.example.rentacar.business.requests.CreateModelRequest;
import com.example.rentacar.business.responses.GetAllModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
