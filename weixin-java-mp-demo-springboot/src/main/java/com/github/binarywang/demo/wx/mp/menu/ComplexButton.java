package com.github.binarywang.demo.wx.mp.menu;

import lombok.Getter;
import lombok.Setter;

/**
 * 父按钮
 * @author zhoumin
 * @create 2018-07-11 15:24
 */
@Setter
@Getter
public class ComplexButton extends BasicButton {
    private BasicButton[] sub_button;

}
