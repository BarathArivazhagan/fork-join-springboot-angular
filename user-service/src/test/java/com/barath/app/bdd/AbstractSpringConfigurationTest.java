package com.barath.app.bdd;

import java.net.MalformedURLException;
import java.util.Map;

import com.barath.app.UserServiceApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest(classes=UserServiceApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public abstract class AbstractSpringConfigurationTest {

    protected static final String HOST="localhost";
    protected static final String PORT="9000";
    protected static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private TestRestTemplate restTemplate;


    public TestRestTemplate getRestTemplate() {

        return restTemplate !=null ? restTemplate : new TestRestTemplate();
    }


    public ResponseEntity<String> invokeRESTCall(String url, HttpMethod method, HttpEntity<?> requestEntity){

        return getRestTemplate().exchange(url,method,requestEntity, String.class);
    }



    public HttpHeaders getDefaultHttpHeaders(){
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return headers;
    }


    public String buildUrl(String host,String port,String path,Map<String,String> uriVariables){


        UriComponentsBuilder builder=UriComponentsBuilder.fromPath(path)
                .host(host)
                .port(port)
                .scheme("http");
        UriComponents uriComponent= uriVariables !=null && !uriVariables.isEmpty() ?  builder.buildAndExpand(uriVariables) : builder.build();

        return uriComponent.toUri().toString();
    }

    public String buildUrl(String host,String port,String path){

        return buildUrl(host, port, path,null);
    }

    public static Object convertJsonToObject(String json, Class clazz){

        try{
           return mapper.readValue(json,clazz);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static Object convertObjectToJson(Object object){

        try{
            return mapper.writeValueAsString(object);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }






}