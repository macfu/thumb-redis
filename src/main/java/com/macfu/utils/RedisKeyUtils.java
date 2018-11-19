package com.macfu.utils;

/**
 * @Author: liming
 * @Date: 2018/11/19 16:47
 * @Description:
 */
public class RedisKeyUtils {
    /**
     * 拼接被点赞用户的id和点赞人的id作为key
     *
     * @param likedUserId 被点赞人的id
     * @param likedPostId 点赞人的id
     * @return 格式"222::333"
     */
    public static String getLikedKey(String likedUserId, String likedPostId) {
        StringBuilder builder = new StringBuilder();
        builder.append(likedUserId);
        builder.append("::");
        builder.append(likedPostId);
        return builder.toString();
    }
}
