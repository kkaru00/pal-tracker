package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private  Map<String, String> envMap = new HashMap<String,String>();

    public  EnvController(
        @Value("${PORT:NOT SET}") String port,
        @Value("${MEMORY_LIMIT:NOT SET}")String memorylimit,
        @Value("${CF_INSTANCE_INDEX:NOT SET}")String cfInstanceIndex,
        @Value("${CF_INSTANCE_ADDR:NOT SET}")String cfInstanceAddress){
        this.envMap.put("PORT",port);
        this.envMap.put("MEMORY_LIMIT", memorylimit);
        this.envMap.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        this.envMap.put("CF_INSTANCE_ADDR", cfInstanceAddress);
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        return this.envMap;
    }

}