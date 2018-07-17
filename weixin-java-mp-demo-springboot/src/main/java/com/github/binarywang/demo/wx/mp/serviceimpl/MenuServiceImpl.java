package com.github.binarywang.demo.wx.mp.serviceimpl;

import ch.qos.logback.classic.gaffer.PropertyUtil;
import com.github.binarywang.demo.wx.mp.entity.AccessToken;
import com.github.binarywang.demo.wx.mp.entity.ConstantWeChat;
import com.github.binarywang.demo.wx.mp.menu.*;
import com.github.binarywang.demo.wx.mp.service.MenuService;
import com.github.binarywang.demo.wx.mp.utils.CommonUtil;
import com.github.binarywang.demo.wx.mp.utils.WeixinUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

/**
 * @author zhoumin
 * @create 2018-07-11 15:40
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);

    // 菜单创建（POST） 限100（次/天）
    public static String MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    // 菜单查询
    final static String URL_MENU_GET = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

    //菜单删除
    final static String URL_MENU_DELETE = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";



    public static void main(String[] args) throws UnsupportedEncodingException {
        // 第三方用户唯一凭证
        String appId = ConstantWeChat.APPID;
        // 第三方用户唯一凭证密钥
        String appSecret = ConstantWeChat.APPSECRET;

        // 调用接口获取access_token
        AccessToken at = CommonUtil.getToken(appId, appSecret);

        if (null != at) {
            // 调用接口创建菜单
            int result = CommonUtil.createMenu(getMenu(), at.getAccessToken());
            /*JSONObject result = CommonUtil.getMenu(at.getAccessToken());
            Iterator<String> it = result.keys();
            Menu menu = new Menu();*/
//            int result= CommonUtil.deleteMenu(at.getAccessToken());
            /*while (it.hasNext()){
                BasicButton
            }*/
            // 判断菜单创建结果
            /*if (0 == result)
                LOGGER.info("菜单创建成功！");
            else
                LOGGER.info("菜单创建失败，错误码：" + result);*/
        }
    }

    /**
     * 组装菜单数据
     *
     * @return
     * @throws UnsupportedEncodingException
     */
    private static Menu getMenu() throws UnsupportedEncodingException {


        ViewButton btn11 = new ViewButton();
        btn11.setName("充电步骤");
        btn11.setType("view");
        btn11.setUrl("https://www.baidu.com");

        ViewButton btn21 = new ViewButton();
        btn21.setName("常见问题");
        btn21.setType("view");
        btn21.setUrl("https://www.baidu.com");

        ViewButton btn31 = new ViewButton();
        btn31.setName("下载APP");
        btn31.setType("view");
        btn31.setUrl("https://www.baidu.com");

        ViewButton btn41 = new ViewButton();
        btn41.setName("成为合伙人");
        btn41.setType("view");
        btn41.setUrl("https://www.baidu.com");

      /*  ViewButton btn51 = new ViewButton();
        btn51.setName("项目介绍");
        btn51.setType("click");*/
//        btn21.setUrl("https://www.baidu.com");

        CommonButton btn12 = new CommonButton();
        btn12.setName("项目介绍");
        btn12.setType("click");
        btn12.setKey("12");





        /*ViewButton btn22 = new ViewButton();
        btn22.setName("view3");
        btn22.setType("view");
        btn22.setUrl("https://www.baidu.com");*/

        /*ViewButton btn31 = new ViewButton();
        btn31.setName("view4");
        btn31.setType("view");
        btn31.setUrl("");*/

        /*CommonButton btn32 = new CommonButton();
        btn32.setName("普通按钮2");
        btn32.setType("click");
        btn32.setKey("32");*/

        /*CommonButton btn33 = new CommonButton();
        btn33.setName("普通按钮3");
        btn33.setType("click");
        btn33.setKey("33");*/

        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("充电帮助");
        mainBtn1.setSub_button(new BasicButton[] { btn11, btn21,btn31});

        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("招募合伙");
        mainBtn2.setSub_button(new BasicButton[] { btn41, btn12 });


        /*ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("333");
        mainBtn3.setSub_button(new BasicButton[] {*//* btn31, *//*btn32*//*, btn33*//* });*/

        /**

         *在某个一级菜单下没有二级菜单的情况，menu应该这样定义：<br>
         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });
         */
        Menu menu = new Menu();
        /*menu.setButton(new BasicButton[] { btn11, mainBtn2*//*, mainBtn3 *//*});*/
        menu.setButton(new BasicButton[] { mainBtn1, mainBtn2/*, mainBtn3 */});

        return menu;
    }

}
