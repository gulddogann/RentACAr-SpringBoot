package com.example.rentacar.dataAccess.abstracts;

import com.example.rentacar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository  extends JpaRepository<Brand,Integer> {

boolean existsByName(String name);//spring jpa keywords

}
