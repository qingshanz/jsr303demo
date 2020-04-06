/**
 * @(#)User, 2020年04月05日.
 */
package com.example.jsr303demo.vo;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

import com.example.jsr303demo.ano.IsMobile;
import com.example.jsr303demo.ano.ListNotHasNull;
import com.example.jsr303demo.valid.AddGroup;
import com.example.jsr303demo.valid.QueryGroup;

/**
 * @author qingshanz
 */
@Setter
@Getter
public class UserVO {

    @NotNull(message = "不能为空", groups = {QueryGroup.class})
    @Null(groups = {AddGroup.class})
    private Long id;

    @NotEmpty(groups = {AddGroup.class})
    private String name;

    // 自定义手机号校验
    @IsMobile.List({@IsMobile(message = "{user.mobile}", groups = {AddGroup.class})
    })
    //@IsMobile
    private String mobile;

    // 自定义集合判断
    @ListNotHasNull
    private List<String> addressList;

}