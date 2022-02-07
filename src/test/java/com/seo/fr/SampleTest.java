package com.seo.fr;

import RESTAPITesting.Framework.Utils.RestAPIutils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SampleTest {

    @Test
    public void sampletest1(){
        RestAPIutils restutils = new RestAPIutils();
        String url ="http://localhost:8080/app/videogames";
        restutils.get(url);
        System.out.println("sample test done");

    }

    @Test
    public void sampletest2(){
        RestAPIutils restutils = new RestAPIutils();

        String strkey = "id";
        int ivalue =13;
        String url ="http://localhost:8080/app/videogames";
        restutils.getWithPathParam(url,strkey,ivalue);
        System.out.println("sample test2 done");

    }

    @Test
    public void sampletest3(){
        String strkey = "id";
        int ivalue =4;
        RestAPIutils restutils = new RestAPIutils();
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put(strkey,ivalue);
        String url ="http://localhost:8080/app/videogames";
        restutils.getwithMutiplePathParams(url,map);
        System.out.println("sample test2 done");

    }


}
