package com.jyeory.kookie.rest.usr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jyeory.kookie.rest.entity.Usr;
import com.jyeory.kookie.rest.entity.UsrRole;
import com.jyeory.kookie.rest.entity.UsrRoleId;

@Repository
public interface UsrRoleRepository extends JpaRepository<UsrRole, UsrRoleId> {
	UsrRole findByUsrEmail(Usr usr);
}
