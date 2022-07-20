package com.msb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
/**
 * 需要跨服务器通信，需要序列化接口
 */
public class persion implements Serializable {
    private Integer id;
    private String name;
}
