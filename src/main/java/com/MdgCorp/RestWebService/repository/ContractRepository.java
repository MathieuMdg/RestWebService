package com.MdgCorp.RestWebService.repository;

import org.springframework.data.repository.CrudRepository;
import com.MdgCorp.RestWebService.entity.Contract;

public interface ContractRepository extends CrudRepository<Contract, Long> {
}
