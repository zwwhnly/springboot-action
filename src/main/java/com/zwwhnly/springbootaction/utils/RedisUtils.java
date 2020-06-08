package com.zwwhnly.springbootaction.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void zSetAdd(final String key, Set<ZSetOperations.TypedTuple<String>> set) {
        redisTemplate.opsForZSet().add(key, set);
    }

    public Set<String> zSetRange(final String key, long start, long stop) {
        return redisTemplate.opsForZSet().range(key, start, stop);
    }

    public Set<String> zSetReverseRange(final String key, long start, long stop) {
        return redisTemplate.opsForZSet().reverseRange(key, start, stop);
    }

    public boolean zSetIncrementScore(final String key, String member, double score) {
        Double result = redisTemplate.opsForZSet().incrementScore(key, member, score);
        return result != null && result == score;
    }

    public void zHashPutAll(final String key, Map<String, String> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    public BoundHashOperations<String, String, String> boundHashOps(final String key) {
        return redisTemplate.boundHashOps(key);
    }
}
