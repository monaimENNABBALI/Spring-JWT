package jwtspringsec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserApp,Long> {

	public UserApp findByUsername(String username);
}
