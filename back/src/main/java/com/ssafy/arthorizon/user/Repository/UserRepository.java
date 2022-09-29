package com.ssafy.arthorizon.user.Repository;

import com.ssafy.arthorizon.user.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserEmail(String userEmail);

    UserEntity findByUserSeq(Long userSeq);

    Optional<UserEntity> findByUserNickname(String nickName);





}