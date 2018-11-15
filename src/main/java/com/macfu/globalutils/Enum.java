package com.macfu.globalutils;

/**
 * @Author: liming
 * @Date: 2018/11/15 14:28
 * @Description:
 */
public enum Enum {
    SUCCESS(0, "成功"),

    SERVER_ERROR(1, "服务器内部发生错误,请稍后重试"),
    INVALID_PARAMETER(1, "无效的参数"),
    DATA_NOT_EXIST(5, "数据不存在"),
    REPEAT_REQUEST(101, "重复请求");

    private final int value;
    private final String msg;

    private Enum(int value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getValue() {
        return value;
    }

    public enum Status {
        SUCCESS("SUCCESS"),
        BIZ_ERROR("BIZ_ERROR"),
        SYS_ERROR("SYS_ERROR");

        private String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum ThumbStatus {

        THUMBOK("THUMBOK", "点赞"),
        THUBMCANCLE("THUBMCANCLE", "取消");


        private String code;
        private String msg;

        ThumbStatus(String code, String msg) {
            this.code = code;
            this.msg = msg;

        }

        public static String getBycode(String code) {
            for (ThumbStatus status : ThumbStatus.values()) {
                if (status.code.equals(code)) {
                    return status.getMsg();
                }
            }
            return "";
        }

        public String getValue() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
