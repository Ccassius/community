package com.nowcoder.community.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xh
 * @create 2021-12-26 17:46
 */
public class Event {

    private String topic;           // 事件类型
    private int userId;             // 触发者
    private int entityType;         // 实体类型（帖子、评论）
    private int entityId;
    private int entityUserId;       // 实体类型作者
    private Map<String, Object> data = new HashMap<String, Object>();

    public String getTopic() {
        return topic;
    }

    public Event setTopic(String topic) {
        this.topic = topic;
        return this;                        // 返回当前对象
    }

    public int getUserId() {
        return userId;
    }

    public Event setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public int getEntityType() {
        return entityType;
    }

    public Event setEntityType(int entityType) {
        this.entityType = entityType;
        return this;
    }

    public int getEntityId() {
        return entityId;
    }

    public Event setEntityId(int entityId) {
        this.entityId = entityId;
        return this;
    }

    public int getEntityUserId() {
        return entityUserId;
    }

    public Event setEntityUserId(int entityUserId) {
        this.entityUserId = entityUserId;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    // 传递key-value，把值存储到map
    public Event setData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
}
