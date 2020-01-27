package com.offcn.springbootapp01.impl;

import com.offcn.springbootapp01.dao.UserRepository;
import com.offcn.springbootapp01.po.User;
import com.offcn.springbootapp01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userDao;

    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.saveAndFlush(user);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public User findOne(Long id) {
        Optional<User> optional = userDao.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> list = userDao.findAll();
        if (list!=null && list.size()>0){
            return list;
        }
        return null;
    }
}
