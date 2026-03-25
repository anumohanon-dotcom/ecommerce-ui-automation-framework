package com.utility;

import java.io.File;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environments;

public class JSONUtility {

    public static Environments jsonReader(Env env){

        Gson gson = new Gson();

        File file = new File(System.getProperty("user.dir") + "/config/config.json");

        try {
            FileReader fr = new FileReader(file);

            Config config = gson.fromJson(fr, Config.class);

            Environments environments = config.getEnvironments().get(env.name());

            return environments;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}