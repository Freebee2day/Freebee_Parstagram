package com.example.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);


        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("p3vYNPv3BpmeW4B8t6dCulSHupTepZcoYo2kFaJu")
                .clientKey("zerll8aP9gc3r3RoFPUwHQDftxAoEJRxYGJvL8tS")
                .server("https://parseapi.back4app.com")
                .build()
        );


    }
}
