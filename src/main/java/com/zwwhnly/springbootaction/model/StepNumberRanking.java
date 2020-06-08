package com.zwwhnly.springbootaction.model;

import org.springframework.data.redis.core.ZSetOperations;

/**
 * 微信步数排行
 */
public class StepNumberRanking implements ZSetOperations.TypedTuple<String> {
    /**
     * 好友关系
     */
    private String friendRelation;

    /**
     * 步数
     */
    private int stepNumber;

    public StepNumberRanking(String friendRelation, int stepNumber) {
        this.friendRelation = friendRelation;
        this.stepNumber = stepNumber;
    }

    @Override
    public String getValue() {
        return friendRelation;
    }

    @Override
    public Double getScore() {
        return (double) stepNumber;
    }

    @Override
    public int compareTo(ZSetOperations.TypedTuple<String> o) {
        StepNumberRanking o1 = (StepNumberRanking) o;
        return Integer.compare(this.stepNumber, o1.stepNumber);
    }
}
