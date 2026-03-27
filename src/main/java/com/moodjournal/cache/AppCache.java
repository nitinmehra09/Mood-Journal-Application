package com.moodjournal.cache;

import com.moodjournal.entities.ConfigJournalAppEntity;
import com.moodjournal.repos.ConfigJournalAppRepos;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    public enum keys{
        WEATHER_API;
    }

    public Map<String,String> appCache;

    @Autowired
    private ConfigJournalAppRepos configJournalAppRepos;

    @PostConstruct
    public void init(){
        appCache = new HashMap<>();
        List<ConfigJournalAppEntity> all = configJournalAppRepos.findAll();
        for (ConfigJournalAppEntity configJournalAppEntity :all){
            appCache.put(configJournalAppEntity.getKey(), configJournalAppEntity.getValue());
        }
    }

}
