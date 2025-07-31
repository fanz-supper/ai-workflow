package com.ai.manager.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

/**
 * @title: ID
 * @description:
 * @author: zhangfan
 */
public class ID {

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String primaryId() {
        return dateTimeFormate1() + randomLen3();
    }

    public static String groupId() {
        return dateTimeFormate1() + randomLen3();
    }

    public static String dateTimeFormate1() {

        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    public static int randomLen3() {
        return new Random().nextInt(100, 999);
    }

}
