package com.guba.springsecurity.service;

import com.guba.springsecurity.dao.RoleDao;
import com.guba.springsecurity.dao.UserDao;
import com.guba.springsecurity.entity.Role;
import com.guba.springsecurity.entity.User;
import com.guba.springsecurity.crm.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	// need to inject user dao
	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public User findByUserName(String userName) {
		// check the database if the user already exists
		return userDao.findByUserName(userName);
	}

	@Override
	@Transactional
	public void save(CrmUser crmUser) {
		User user = new User();
		 // assign user details to the user object
		user.setUserName(crmUser.getUserName());
		user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
		user.setFirstName(crmUser.getFirstName());
		user.setLastName(crmUser.getLastName());
		user.setEmail(crmUser.getEmail());

		// give user default role of "employee"
		Role roleEmployee = roleDao.findRoleByName("ROLE_EMPLOYEE");

		// the user is always role ROLE_EMPLOYEE o more roles
		if (crmUser.getFormRole().equals("ROLE_EMPLOYEE")) {
			user.setRoles(Arrays.asList(roleEmployee));
		} else {
			user.setRoles(Arrays.asList(
					roleEmployee,
					roleDao.findRoleByName(crmUser.getFormRole())));
		}

		/**
		// give user default role of "employee"
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList();
		authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));

		// if the user selected role other than employee
		// then add that one too (multiple roles)
		String formRole = theCrmUser.getFormRole();
		if (!formRole.equals("ROLE_EMPLOYEE")) {
			authorities.add(new SimpleGrantedAuthority(formRole));
		}

		// create user object (from Spring Security framework)
		User tempUser = new User(userName, encodedPassword, authorities);
		*/

		 // save user in the database
		userDao.save(user);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
