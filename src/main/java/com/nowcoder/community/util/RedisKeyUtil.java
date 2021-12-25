package com.nowcoder.community.util;

/**
 * @author xh
 * @create 2021-12-20 11:38
 */
public class RedisKeyUtil {

    private static final String SPLIT = ":";
    private static final String PREFIX_ENTITY_LIKE = "like:entity";
    private static final String PREFIX_USER_LIKE = "like:user";
    private static final String PREFIX_FOLLOWEE = "followee";
    private static final String PREFIX_FOLLOWER = "follower";
    private static final String PREFIX_KEYPATH = "kaptcha";
    private static final String PREFIX_TICKET = "ticket";
    private static final String PREFIX_USER = "user";

    /**
     * 某个实体的赞
     * like:entity:entityType:entityId -> set(userId)
     */
    public static String getEntityLikeKey(int entityType, int entityId) {
        return PREFIX_ENTITY_LIKE + SPLIT + entityType + SPLIT +entityId;
    }

    /**
     * 某个用户的赞
     * like:user:userId -> int
     */
    public static String getUserLikeKey(int userId) {
        return PREFIX_USER_LIKE +SPLIT + userId;
    }

    /**
     * 某个用户关注的实体 (用户、帖子)
     * followee:userId:entityType -> zset(entityId, now)
     */
    public static String getFolloweeKey(int userId, int entityType) {
        return PREFIX_FOLLOWEE + SPLIT + userId + SPLIT + entityType;
    }

    /**
     * 某个实体（用户、帖子）拥有的粉丝
     * follower:entityType:entityId -> zset(userId, now)
     */
    public static String getFollowerKey(int entityType, int entityId) {
        return PREFIX_FOLLOWER + SPLIT + entityType + SPLIT + entityId;
    }

    /**
     * 登录验证码
     * owner: 用户的临时凭证
     */
    public static String getKaptchKey(String owner) {
        return PREFIX_KEYPATH + SPLIT + owner;
    }

    /**
     * 登录的凭证
     * 替代login-ticket表
     */
    public static String getTicketKey(String ticket) {
        return PREFIX_TICKET + SPLIT +ticket;
    }

    /**
     * 用户
     */
    public static String getUserKye(int userId) {
        return PREFIX_USER + SPLIT + userId;
    }
}














