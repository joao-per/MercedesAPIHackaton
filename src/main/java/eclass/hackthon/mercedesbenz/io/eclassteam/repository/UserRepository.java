package eclass.hackthon.mercedesbenz.io.eclassteam.repository;

import eclass.hackthon.mercedesbenz.io.eclassteam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}