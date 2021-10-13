package com.phisoft.springreactiveredisone.repositories;

import com.phisoft.springreactiveredisone.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY="USER";



    @Override
    public boolean saveUser(User user) {
        try{
            System.out.println("here dao");
            redisTemplate.opsForHash().put(KEY,user.getId().toString(),user);

            return true;
        }catch (Exception e){
            System.out.println("here dao failed");

            e.getStackTrace();
            return false;
        }
    }

    @Override
    public List<User> fetchAllUsers() {
        return redisTemplate.opsForHash().values(KEY);
    }

    @Override
    public User fetchUserById(Long id) {
        return (User)redisTemplate.opsForHash().get(KEY,id.toString());
    }

    @Override
    public boolean deleteUserById(Long id) {
        try {
       Long del=redisTemplate.opsForHash().delete(KEY, id.toString());
       if(del> 0){
           return true;
       }else {
           return false;
       }
        }catch (Exception e){
            e.getStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUserById(Long id) {
        try{
        User user=   (User) redisTemplate.opsForHash().get(KEY,id.toString());
        user.setId(id);
        redisTemplate.opsForHash().put(KEY,id.toString(),user);
        return true;
        }catch (Exception e){
            e.getStackTrace();
            return false;
        }
    }
}
