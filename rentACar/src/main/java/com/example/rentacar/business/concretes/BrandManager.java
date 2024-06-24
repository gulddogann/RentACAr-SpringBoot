package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.BrandService;
import com.example.rentacar.business.requests.CreateBrandRequest;
import com.example.rentacar.business.requests.UpdateBrandRequest;
import com.example.rentacar.business.responses.GetAllBrandsResponse;
import com.example.rentacar.business.responses.GetByIdBrandResponse;
import com.example.rentacar.business.rules.BrandBusinessRules;
import com.example.rentacar.core.utilities.mappers.ModelMapperService;
import com.example.rentacar.dataAccess.abstracts.BrandRepository;
import com.example.rentacar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;


    @Autowired
    public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService) {
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandsResponse> brandsResponses = brands.stream().map(brand -> this.modelMapperService.forResponse()
                .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponses;

    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {

        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);

        return response;
    }


    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);

    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);

    }

}
