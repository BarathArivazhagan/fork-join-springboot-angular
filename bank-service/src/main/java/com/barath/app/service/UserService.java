package com.barath.app.service;

import com.barath.app.future.FutureUserTaskService;
import com.barath.app.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final FutureUserTaskService futureUserTaskService;

    public UserService(FutureUserTaskService futureUserTaskService) {
        this.futureUserTaskService = futureUserTaskService;
    }

    public List<User> getIndividualUserThroughFuture(Long length){

        length = 5L;
        List<CompletableFuture<User>> futuresList = this.futureUserTaskService.getFutures(length);
        futuresList.forEach(future -> logger.info("future {}",future));
        List<User> users=futuresList.parallelStream().map(CompletableFuture::join).collect(Collectors.toList());
        users.forEach(user -> logger.info("user details {} ", Objects.toString(user)));
        return users;
    }
}
