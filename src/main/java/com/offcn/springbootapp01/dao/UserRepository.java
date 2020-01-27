package com.offcn.springbootapp01.dao;

import com.offcn.springbootapp01.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
