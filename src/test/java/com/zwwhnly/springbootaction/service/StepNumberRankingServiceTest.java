package com.zwwhnly.springbootaction.service;

import com.alibaba.fastjson.JSON;
import com.zwwhnly.springbootaction.model.FriendStepNumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonbTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StepNumberRankingServiceTest {
    @Autowired
    private StepNumberRankingService stepNumberRankingService;

    @Test
    public void testStepNumberRankingInitialize() {
        String weChat = "zwwhnly";
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        stepNumberRankingService.stepNumberRankingInitialize(weChat, date);
    }

    @Test
    public void testFriendStepNumberInitialize() {
        String weChat = "zwwhnly";
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        stepNumberRankingService.friendStepNumberInitialize(weChat, date);
    }

    @Test
    public void testUpdateFriendStepNumber() {
        String key = "StepNumberRanking:zwwhnly:20200528:yst";
        Map<String, String> stepNumberMap = new HashMap<>();
        stepNumberMap.put("stepNumber", "25462");
        stepNumberMap.put("likeNum", "3");

        stepNumberRankingService.updateFriendStepNumber(key, stepNumberMap);
    }

    @Test
    public void testGetFriendStepNumberRanking() {
        String weChat = "zwwhnly";
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        long start = 0;
        long stop = 4;

        List<FriendStepNumber> friendStepNumberList = stepNumberRankingService.getFriendStepNumberRanking(weChat, date, start, stop);
        System.out.println(JSON.toJSONString(friendStepNumberList));
    }
}