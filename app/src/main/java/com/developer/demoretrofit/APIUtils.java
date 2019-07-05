package com.developer.demoretrofit;

public class APIUtils {
    public static final String Base_Url="https://reqres.in";
    public static DataClient    getData(){
        return RetrofitClient.getRetrofitClient(Base_Url).create(DataClient.class);
    }
}
