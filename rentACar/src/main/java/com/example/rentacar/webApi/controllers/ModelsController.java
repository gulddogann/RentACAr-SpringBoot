package com.example.rentacar.webApi.controllers;

import com.example.rentacar.business.abstracts.ModelService;
import com.example.rentacar.business.requests.CreateModelRequest;
import com.example.rentacar.business.responses.GetAllModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;

    @GetMapping
    public List<GetAllModelResponse> getAll() {
        return modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }


}
