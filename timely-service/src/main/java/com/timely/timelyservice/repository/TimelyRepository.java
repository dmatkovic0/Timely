package com.timely.timelyservice.repository;

import com.timely.timelyservice.model.Timely;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TimelyRepository extends PagingAndSortingRepository<Timely, Long>, JpaSpecificationExecutor<Timely> {
}
