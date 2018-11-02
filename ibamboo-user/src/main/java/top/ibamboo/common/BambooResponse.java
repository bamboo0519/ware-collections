package top.ibamboo.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.PipedReader;

/**
 * Created by Administrator on 2018/11/2/002.
 */
@Data
@NoArgsConstructor
public class BambooResponse<T> {
    private final static Integer SUCCESS = 200;
    private static BambooResponse okResponse = new BambooResponse(SUCCESS);

    public BambooResponse(Integer code) {
        this.code = code;
    }
    Integer code;
    String msg;
    T data;

    public Boolean success() {
        return code == 200;
    }

    public static BambooResponse ok() {
        return okResponse;
    }
}
