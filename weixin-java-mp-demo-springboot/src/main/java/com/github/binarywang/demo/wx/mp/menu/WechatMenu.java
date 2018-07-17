package com.github.binarywang.demo.wx.mp.menu;

import java.util.Arrays;

public class WechatMenu {
	/**
	 * 菜单按钮
	 */
	private WechatButton[] button;

	public WechatButton[] getButton() {
		return button;
	}


	public void setButton(WechatButton[] button) {
		this.button = button;
	}


	public WechatMenu(WechatButton[] button) {
		super();
		this.button = button;
	}


	public WechatMenu() {
		super();
	}


	@Override
	public String toString() {
		return "WechatMenu [button=" + Arrays.toString(button) + "]";
	}  
}
