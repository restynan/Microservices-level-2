package io.javabrains.moviecatalogservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
@Service
public class MovieRating {

    @Autowired
   private  RestTemplate restTemplate;




   @HystrixCommand(fallbackMethod ="getFallbackUserRating",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
            })
    public   UserRating getUserRatings(@PathVariable("userId") String userId){

     return  restTemplate.getForObject("http://movie-rating-service/rating/users/"+ userId, UserRating.class);

    }

    public  UserRating getFallbackUserRating(@PathVariable("userId") String userId){
        return new  UserRating( Arrays.asList(new Rating("50",600)));
    }
}
