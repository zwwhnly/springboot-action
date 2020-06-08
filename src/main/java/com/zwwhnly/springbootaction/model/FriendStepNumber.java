package com.zwwhnly.springbootaction.model;

/**
 * 好友步数
 */
public class FriendStepNumber {
    /**
     * 头像地址
     */
    private String profileUrl;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 步数
     */
    private int stepNumber;

    /**
     * 点赞数
     */
    private int likeNum;

    public FriendStepNumber(String profileUrl, String nickName, int stepNumber, int likeNum) {
        this.profileUrl = profileUrl;
        this.nickName = nickName;
        this.stepNumber = stepNumber;
        this.likeNum = likeNum;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }
}
