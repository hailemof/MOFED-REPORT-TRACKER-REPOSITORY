package net.mofed.reportracking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.mofed.reportracking.app.model.User;

@Repository
public interface MyUserRepository extends JpaRepository <User,Long>{

	User findByUsername(String un);
}
