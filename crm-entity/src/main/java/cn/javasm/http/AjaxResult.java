package cn.javasm.http;

import java.util.HashMap;

public class AjaxResult extends HashMap<String, Object> {

    public static final String STATUS = "status";
    public static final String MESSAGE = "message";
    public static final String DATA = "data";

    public AjaxResult(AjaxStatus ajaxStatus) {
        put(STATUS,ajaxStatus.getStatus());
        put(MESSAGE,ajaxStatus.getMessage());
    }

    //成功的方法
    public static AjaxResult success(){
        return new AjaxResult(AjaxStatus.OK);
    }

    public static AjaxResult success(AjaxStatus ajaxStatus){
        return new AjaxResult(ajaxStatus);
    }

    public static AjaxResult success(Object data){
        AjaxResult ajaxResult = success();
        ajaxResult.put(DATA,data);
        return ajaxResult;
    }



    //失败的方法
    public static AjaxResult error(){
        return new AjaxResult(AjaxStatus.ERROR);
    }

    public static AjaxResult error(AjaxStatus ajaxStatus){
        return new AjaxResult(ajaxStatus);
    }


}
