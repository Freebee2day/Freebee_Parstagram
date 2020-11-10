package com.example.parstagram;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Post")
public class Post extends ParseObject {

    public static final String KEY_USER = "user";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_CREATED_AT= "createdAt";



    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }
    public void setUser(ParseUser ps){
        put(KEY_USER,ps);
    }

    public String getDes(){
        return getString(KEY_DESCRIPTION);
    }

    public void setDes(String des){
        put(KEY_DESCRIPTION,des);
    }

    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile img){
        put(KEY_IMAGE,img);
    }






}
