/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package service.user.param;

import lombok.Data;

/**
 * @author fyh
 * @version V1.0
 * @since 2018-09-09
 */
@Data
public class UserParam {

    private String nick;
    private String name;
    private String password;
    private String confirm;
}
