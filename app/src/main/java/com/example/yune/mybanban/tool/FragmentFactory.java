package com.example.yune.mybanban.tool;/*
       版权所有-----------------翻版必究
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
            .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
 ======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
          佛祖保佑       永无BUG
 */


import com.example.yune.mybanban.base.BaseFragment;
import com.example.yune.mybanban.fragment.AppFragment;
import com.example.yune.mybanban.fragment.KaoQingFragment;
import com.example.yune.mybanban.fragment.MessageFragment;
import com.example.yune.mybanban.fragment.OfficeFragment;
import com.example.yune.mybanban.fragment.OrganizationFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FragmentFactory {
    /**
     * 用来缓存已经创建好的Fragment
     */
    private static HashMap<Integer, BaseFragment> fragments = new HashMap<Integer, BaseFragment>();

    private static List<BaseFragment> fs = new ArrayList<>();

    /**
     * 通过position获取Fragment
     *
     * @param position
     * @return
     */
    public static BaseFragment createFragment(int position) {
        // 先从集合中去取出
        BaseFragment fragment = fragments.get(position);
        if (fragment == null) {
            switch (position) {
                case 0:
                    // 消息
                    fragment = new MessageFragment();
                    break;
                case 1:
                    // 组织
                    fragment = new OrganizationFragment();
                    break;
                case 2:
                    // 场景
                    fragment = new AppFragment();
                    break;
                case 3:
                    // 考勤
                    fragment = new KaoQingFragment();
                    break;
                case 4:
                    // 会议
                    fragment = new OfficeFragment();
                    break;
            }
            // 创建完毕后，保存到map集合中
            if (fragment != null) {
                fragments.put(position, fragment);
            }
        }
        return fragment;
    }

    public static void clear() {
        fragments.clear();
    }
}
