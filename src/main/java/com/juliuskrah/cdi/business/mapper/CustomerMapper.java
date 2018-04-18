package com.juliuskrah.cdi.business.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.juliuskrah.cdi.business.dto.CustomerBean;
import com.juliuskrah.cdi.entity.Customer;

@Mapper(componentModel = "cdi")
public interface CustomerMapper {
	@Mapping(target = "telephone", source = "phone")
	CustomerBean toDTO(Customer customer);

	@Mapping(target = "phone", source = "telephone")
	Customer toEntity(CustomerBean dto);

	List<CustomerBean> toDTO(List<Customer> customers);

	List<Customer> toEntity(List<CustomerBean> dtos);
}
