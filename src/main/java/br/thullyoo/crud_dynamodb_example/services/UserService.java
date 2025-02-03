package br.thullyoo.crud_dynamodb_example.services;

import br.thullyoo.crud_dynamodb_example.entity.User;
import br.thullyoo.crud_dynamodb_example.entity.UserRequest;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private DynamoDbTemplate dynamoDbTemplate;

    public User create(UserRequest userRequest){
        User user = new User(userRequest.name(), userRequest.document(), userRequest.password());
        dynamoDbTemplate.save(user);
        return user;
    }
}

