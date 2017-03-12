package com.xu.eventbusdemo.event;

/**
 * 创建者     伍碧林
 * 创建时间   2017/3/8 23:26
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class EventMsg {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public EventMsg(String msg) {
        this.msg = msg;
    }
}
