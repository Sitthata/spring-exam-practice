package com.example.springexampractice.service;

import com.example.springexampractice.model.dto.PageDTO;
import com.example.springexampractice.model.dto.ProductDTO;
import com.example.springexampractice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public PageDTO<ProductDTO> findAll(Pageable pageable) {
        Page<ProductDTO> productPage = productRepository.findAll(pageable)
                .map((element) -> modelMapper.map(element, ProductDTO.class));
        return PageDTO.<ProductDTO>builder()
                .content(productPage.getContent())
                .pageable(productPage.getPageable())
                .build();
    }

//    public Page<Product> getProductByPriceAndNameAndSort(double min,double max, String name,int pageNo,int pageSize,String[] sortBy,String[] direction){
//        List<Sort.Order>sortOrder=new ArrayList<>();
//        if(sortBy!=null&&sortBy.length>0){
//            for (int i=0;i< sortBy.length;i++){
//                sortOrder.add(new Sort.Order((direction[i].equalsIgnoreCase("asc")?
//                        Sort.Direction.ASC:Sort.Direction.DESC),sortBy[i]));
//            }
//        }
//
//        Pageable pageable1=PageRequest.of(pageNo,pageSize, Sort.by(sortOrder));
//        return productRepository.findByBuyPriceBetweenAndProductNameContains(min,max,name,pageable1);
//    }
}
