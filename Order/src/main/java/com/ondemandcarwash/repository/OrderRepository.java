package com.ondemandcarwash.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ondemandcarwash.model.Order;


@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
	
	@Query("{cId:?0}")
	List<Order> findByCustomerId(long cId);
	
	@Query("{wId:?0}")
	List<Order> findByWasherId(long wId);

	@Query("{ status : { $regex : ?0 } }")
	List<Order> findOrderByStatus(String status);

}
