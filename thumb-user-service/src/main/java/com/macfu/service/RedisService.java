package com.macfu.service;

/**
 * @Author: liming
 * @Date: 2018/11/21 15:27
 * @Description: RedisService接口
 */
public interface RedisService {
    /**
     * 点赞，状态为1
     *
     * @param likedUserId
     * @param likedPostId
     */
    public void saveLiked2Redis(String likedUserId, String likedPostId);

    /**
     * 取消点赞，状态将变为0
     *
     * @param likeedUserId
     * @param likedPostId
     */
    public void unLikeFromRedis(String likeedUserId, String likedPostId);

    /**
     * 从Redis中删除一条点赞数据
     *
     * @param likedUserId
     * @param likedPostId
     */
    public void deleteLikedFromReis(String likedUserId, String likedPostId);

    /**
     * 该用户的点赞数加1
     *
     * @param likedUserId
     */
    public void incrementLikedCount(String likedUserId);

    /**
     * 该用户的点赞数减1
     *
     * @param likedUserId
     */
    public void decrementLikedCount(String likedUserId);

    /**
     * 获取Redis中的存储的所有点赞数据
     *
     * @return
     */
    public List<UserLike> getLikedDataFromRedis();

    /**
     * 获取Redis中存储的所有点赞数量
     *
     * @return
     */
    public List<LikedCountDto> getLikedCountFromRedis();

}
