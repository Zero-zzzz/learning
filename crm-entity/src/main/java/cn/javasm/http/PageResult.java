package cn.javasm.http;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PageResult {

    private Object records;
    private long total;

    public static PageResult instance(Object records,long total){
        return new PageResult(records,total);
    }

}
