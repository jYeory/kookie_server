package com.jyeory.kookie.rest.usr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jyeory.kookie.rest.entity.Usr;

@Repository
public interface UsrRepository extends JpaRepository<Usr, String> {

	Optional<Usr> findById(String email);
}

