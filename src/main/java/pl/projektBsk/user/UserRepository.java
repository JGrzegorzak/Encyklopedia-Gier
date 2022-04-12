package pl.projektBsk.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String userName);
    @Modifying
    @Transactional
    @Query(UPDATE_PASSWORD)
    int changePassword(@Param("password") String password, @Param("id") Long id);



    static final String UPDATE_PASSWORD = "UPDATE User u SET u.password = :password WHERE u.id = :id";
}


