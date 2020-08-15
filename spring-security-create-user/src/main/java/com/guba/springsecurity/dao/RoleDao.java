package com.guba.springsecurity.dao;

import com.guba.springsecurity.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
