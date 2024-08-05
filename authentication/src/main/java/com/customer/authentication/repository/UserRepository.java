package com.customer.authentication.repository;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.customer.authentication.model.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	
	@Autowired
    private DynamoDBMapper dynamoDBMapper;

    public String createUser(User user){
        dynamoDBMapper.save(user);
        return user.getUsername();
    }

    public User getUserById(String id){
        return dynamoDBMapper.load(User.class, id);
    }

}