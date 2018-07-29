package com.barath.app.future;

import com.barath.app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Service
public class FutureUserTaskService {

      private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
      private static final String USER_ID_ENDPOINT = "/users/";

      @Value("${user.service.endpoint}")
      private String userServiceUrl;

      private final RestTemplate restTemplate;

      public FutureUserTaskService(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
      }

      public List<CompletableFuture<User>> getFutures(Long length){

          return  LongStream.range(1,length+1)
                    .mapToObj( value -> {
                        return getFutureUser(value);
                    }).collect(Collectors.toList());

      }

      public CompletableFuture<User> getFutureUser(Long userId){

            if( logger.isInfoEnabled() ) { logger.info("rest invocation to get user by user id {}",userId); }
            return CompletableFuture.supplyAsync(() ->{

                  User user = this.restTemplate.getForObject(this.userServiceUrl+userId,User.class);
                  if( logger.isInfoEnabled() ) { logger.info("rest result with user details {} ",user); }
                  return user;
            });




      }

      @PostConstruct
      public void init(){

            this.userServiceUrl = this.userServiceUrl.concat(USER_ID_ENDPOINT);
            if(logger.isInfoEnabled()) {
                  logger.info("user service url {}"+userServiceUrl);
            }
      }


}
