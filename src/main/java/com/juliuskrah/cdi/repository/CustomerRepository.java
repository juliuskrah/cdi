package com.juliuskrah.cdi.repository;

import java.util.Optional;
import java.util.UUID;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;

import com.juliuskrah.cdi.entity.Customer;

@Repository
public interface CustomerRepository extends EntityRepository<Customer, UUID> {

	@Query("SELECT c FROM Customer c WHERE c.id = :id")
	Optional<Customer> findOne(@QueryParam("id") UUID id);

}