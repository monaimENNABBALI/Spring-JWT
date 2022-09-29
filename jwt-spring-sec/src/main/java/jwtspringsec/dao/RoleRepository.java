package jwtspringsec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleApp,Long> {

	public RoleApp findByRoleName(String roleName);
}
