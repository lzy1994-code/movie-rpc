package com.bw.movie.utils;

import com.alibaba.fastjson.JSONObject;
import com.bw.movie.rpc.pojo.UserMessagePush;
import com.bw.movie.service.UserMessagePushService;
import com.bw.mq.pojo.PushData;
import com.bw.mq.producer.IMqHandler;
import com.bw.mq.producer.factory.MqHandlerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xyj on 2018/8/13.
 */
public class MqUtil {

    private static Map<String, IMqHandler> mqMap = new HashMap<>();

    private static Logger logger = LoggerFactory.getLogger(MqUtil.class);

    private static void send(String queueName, PushData pushData) {
        IMqHandler mqHandler = mqMap.get(queueName);
        if (mqHandler == null) {
            mqHandler = MqHandlerProvider.getMqHandler(queueName);
            mqMap.put(queueName, mqHandler);
        }
        mqHandler.sendMsg(JSONObject.toJSONString(pushData));
    }

    public static synchronized void sendMsg(String queueName, int userId, String title, String content) {
        UserMessagePushService userMessagePushService = (UserMessagePushService) SpringUtil.getBean("userMessagePushService");
        UserMessagePush userMessagePush = userMessagePushService.getUserMessagePush(userId);
        if (userMessagePush != null) {
            PushData pushData = new PushData();
            pushData.setToken(userMessagePush.getToken());
            pushData.setProduct(Constants.MQ_PRODUCT);
            pushData.setTitle(title);
            pushData.setContent(content);
            try {
                send(queueName, pushData);
            } catch (Exception e) {
                logger.error("刷新mqHandler");
                mqMap.remove(queueName);
                send(queueName, pushData);
            }
        }
    }

}
