package com.zwwhnly.springbootaction.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.zwwhnly.springbootaction.model.FriendStepNumber;
import com.zwwhnly.springbootaction.model.StepNumberRanking;
import com.zwwhnly.springbootaction.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

@Service
public class StepNumberRankingService {
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 步数排行榜初始化
     *
     * @param weChat
     * @param date
     */
    public void stepNumberRankingInitialize(String weChat, String date) {
        String stepNumberRankingKey = getStepNumberRankingKey(weChat, date);
        Set<ZSetOperations.TypedTuple<String>> stepNumberRankingSet = getStepNumberRankingSet();

        redisUtils.zSetAdd(stepNumberRankingKey, stepNumberRankingSet);
    }

    /**
     * 好友步数初始化
     *
     * @param weChat
     * @param date
     */
    public void friendStepNumberInitialize(String weChat, String date) {
        Map<String, Map<String, String>> map = getFriendStepNumberMap(weChat, date);
        for (String key : map.keySet()) {
            redisUtils.zHashPutAll(key, map.get(key));
        }
    }

    /**
     * 更新好友步数
     *
     * @param key
     * @param map
     */
    public void updateFriendStepNumber(String key, Map<String, String> map) {
        redisUtils.zHashPutAll(key, map);
    }

    public List<FriendStepNumber> getFriendStepNumberRanking(String weChat, String date, long start, long stop) {
        List<FriendStepNumber> friendStepNumberList = new ArrayList<>();

        String key = getStepNumberRankingKey(weChat, date);
        Set<String> friendStepNumberRankingSet = redisUtils.zSetReverseRange(key, start, stop);

        for (String friend : friendStepNumberRankingSet) {
            BoundHashOperations<String, String, String> boundHashOperations = redisUtils.boundHashOps(key + ":" + friend);
            FriendStepNumber friendStepNumber = JSON.parseObject(JSON.toJSONString(boundHashOperations.entries()), FriendStepNumber.class);
            friendStepNumberList.add(friendStepNumber);
        }

        return friendStepNumberList;
    }


    private String getStepNumberRankingKey(String weChat, String date) {
        return "StepNumberRanking:" + weChat + ":" + date;
    }

    private Set<ZSetOperations.TypedTuple<String>> getStepNumberRankingSet() {
        Set<ZSetOperations.TypedTuple<String>> set = new HashSet<>();

        ZSetOperations.TypedTuple<String> stepNumberRanking1 = new StepNumberRanking("yst", 25452);
        ZSetOperations.TypedTuple<String> stepNumberRanking2 = new StepNumberRanking("zq", 23683);
        ZSetOperations.TypedTuple<String> stepNumberRanking3 = new StepNumberRanking("ljx", 23599);
        ZSetOperations.TypedTuple<String> stepNumberRanking4 = new StepNumberRanking("yyq", 20391);
        ZSetOperations.TypedTuple<String> stepNumberRanking5 = new StepNumberRanking("XxZz", 19628);
        ZSetOperations.TypedTuple<String> stepNumberRanking6 = new StepNumberRanking("lxx", 18261);
        ZSetOperations.TypedTuple<String> stepNumberRanking7 = new StepNumberRanking("zcc", 16636);
        ZSetOperations.TypedTuple<String> stepNumberRanking8 = new StepNumberRanking("clc", 16555);
        ZSetOperations.TypedTuple<String> stepNumberRanking9 = new StepNumberRanking("fl", 16098);

        set.add(stepNumberRanking1);
        set.add(stepNumberRanking2);
        set.add(stepNumberRanking3);
        set.add(stepNumberRanking4);
        set.add(stepNumberRanking5);
        set.add(stepNumberRanking6);
        set.add(stepNumberRanking7);
        set.add(stepNumberRanking8);
        set.add(stepNumberRanking9);

        return set;
    }

    private Map<String, Map<String, String>> getFriendStepNumberMap(String weChat, String date) {
        Map<String, Map<String, String>> friendStepNumberMap = new HashMap<>();
        String stepNumberRankingKey = getStepNumberRankingKey(weChat, date);
        String profileUrl = "https://pic.cnblogs.com/avatar/424537/20190625132829.png";

        String hashKey1 = stepNumberRankingKey + ":yst";
        Map<String, String> stepNumberMap1 = new HashMap<>();
        stepNumberMap1.put("profileUrl", profileUrl);
        stepNumberMap1.put("nickName", "yst");
        stepNumberMap1.put("stepNumber", "25452");
        stepNumberMap1.put("likeNum", "1");

        String hashKey2 = stepNumberRankingKey + ":zq";
        Map<String, String> stepNumberMap2 = new HashMap<>();
        stepNumberMap2.put("profileUrl", profileUrl);
        stepNumberMap2.put("nickName", "zq");
        stepNumberMap2.put("stepNumber", "23683");
        stepNumberMap2.put("likeNum", "4");

        String hashKey3 = stepNumberRankingKey + ":ljx";
        Map<String, String> stepNumberMap3 = new HashMap<>();
        stepNumberMap3.put("profileUrl", profileUrl);
        stepNumberMap3.put("nickName", "ljx");
        stepNumberMap3.put("stepNumber", "23599");
        stepNumberMap3.put("likeNum", "2");

        String hashKey4 = stepNumberRankingKey + ":yyq";
        Map<String, String> stepNumberMap4 = new HashMap<>();
        stepNumberMap4.put("profileUrl", profileUrl);
        stepNumberMap4.put("nickName", "yyq");
        stepNumberMap4.put("stepNumber", "20391");
        stepNumberMap4.put("likeNum", "8");

        String hashKey5 = stepNumberRankingKey + ":XxZz";
        Map<String, String> stepNumberMap5 = new HashMap<>();
        stepNumberMap5.put("profileUrl", profileUrl);
        stepNumberMap5.put("nickName", "XxZz");
        stepNumberMap5.put("stepNumber", "19628");
        stepNumberMap5.put("likeNum", "0");

        String hashKey6 = stepNumberRankingKey + ":lxx";
        Map<String, String> stepNumberMap6 = new HashMap<>();
        stepNumberMap6.put("profileUrl", profileUrl);
        stepNumberMap6.put("nickName", "lxx");
        stepNumberMap6.put("stepNumber", "18261");
        stepNumberMap6.put("likeNum", "2");

        String hashKey7 = stepNumberRankingKey + ":zcc";
        Map<String, String> stepNumberMap7 = new HashMap<>();
        stepNumberMap7.put("profileUrl", profileUrl);
        stepNumberMap7.put("nickName", "zcc");
        stepNumberMap7.put("stepNumber", "16636");
        stepNumberMap7.put("likeNum", "8");

        String hashKey8 = stepNumberRankingKey + ":clc";
        Map<String, String> stepNumberMap8 = new HashMap<>();
        stepNumberMap8.put("profileUrl", profileUrl);
        stepNumberMap8.put("nickName", "clc");
        stepNumberMap8.put("stepNumber", "16555");
        stepNumberMap8.put("likeNum", "3");

        String hashKey9 = stepNumberRankingKey + ":fl";
        Map<String, String> stepNumberMap9 = new HashMap<>();
        stepNumberMap9.put("profileUrl", profileUrl);
        stepNumberMap9.put("nickName", "fl");
        stepNumberMap9.put("stepNumber", "16098");
        stepNumberMap9.put("likeNum", "4");

        friendStepNumberMap.put(hashKey1, stepNumberMap1);
        friendStepNumberMap.put(hashKey2, stepNumberMap2);
        friendStepNumberMap.put(hashKey3, stepNumberMap3);
        friendStepNumberMap.put(hashKey4, stepNumberMap4);
        friendStepNumberMap.put(hashKey5, stepNumberMap5);
        friendStepNumberMap.put(hashKey6, stepNumberMap6);
        friendStepNumberMap.put(hashKey7, stepNumberMap7);
        friendStepNumberMap.put(hashKey8, stepNumberMap8);
        friendStepNumberMap.put(hashKey9, stepNumberMap9);

        return friendStepNumberMap;
    }
}
