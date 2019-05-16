package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @user hzc
 * @data 2019/5/16 19:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private String username;
    private String password;
    private String email;
    private String code;

}
