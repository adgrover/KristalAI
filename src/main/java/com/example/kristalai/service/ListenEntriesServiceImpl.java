package com.example.kristalai.service;

import com.example.kristalai.model.RandomNumberModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.example.kristalai.pojo.RandomNumberResponse;
import com.example.kristalai.repository.RandomNumberRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ListenEntriesServiceImpl implements ListenEntriesService {

    public RandomNumberRepository randomNumberRepository;

    @Autowired
    public ListenEntriesServiceImpl(RandomNumberRepository randomNumberRepository) {
        this.randomNumberRepository = randomNumberRepository;
    }

    public static Integer TOTAL_NUMBERS=5;

    @Override
    public RandomNumberResponse checkDB() {

        List<Long> fiveMinutesList = randomNumberRepository.getHistoricalData(new Date(System.currentTimeMillis() - 5 * 60 * 1000L));
        List<Long> tenMinutesList = randomNumberRepository.getHistoricalData(new Date(System.currentTimeMillis() - 10 * 60 * 1000L));
        List<Long> thirtyMinutesList = randomNumberRepository.getHistoricalData(new Date(System.currentTimeMillis() - 30 * 60 * 1000L));

        fiveMinutesList = fiveMinutesList == null ? new ArrayList<Long>() : fiveMinutesList;
        tenMinutesList = tenMinutesList == null ? new ArrayList<Long>() : tenMinutesList;
        thirtyMinutesList = thirtyMinutesList == null ? new ArrayList<Long>() : thirtyMinutesList;

        return new RandomNumberResponse(true, "Success",fiveMinutesList, tenMinutesList, thirtyMinutesList);
    }


    @Scheduled(fixedRate = 1000)
    public void generateRandomNumber(){

        System.out.println("Scheduler Called");

        RandomNumberModel randomNumberModel;
        List<RandomNumberModel> batch=new ArrayList<>();

        for(int i=0; i<TOTAL_NUMBERS; i++) {
            randomNumberModel=new RandomNumberModel((long) (Math.random() * 100000), new Date());
            batch.add(randomNumberModel);
        }
        randomNumberRepository.saveAll(batch);
    }
}
