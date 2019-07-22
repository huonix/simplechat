package com.huonix.simplechat.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.huonix.simplechat.models.User;

@Repository
public interface UserRepository extends CassandraRepository<User, User> {

	@Query("select * from users where name = ?0")
    Iterable<User> findByName(String name);
	
	@Query(allowFiltering = true)
	Optional<User> findById(UUID id);
	
}
