package com.example.rentacar.business.rules;

import com.example.rentacar.core.utilities.exception.BusinessException;
import com.example.rentacar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;

    public void checkIfBrandNameExists(String name) {

        if (this.brandRepository.existsByName(name)) {
            throw new BusinessException(("Brand name already exists"));//java exception types
        }
    }
}
