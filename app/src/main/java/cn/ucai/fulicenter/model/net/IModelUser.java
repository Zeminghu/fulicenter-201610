package cn.ucai.fulicenter.model.net;

import android.content.Context;

import cn.ucai.fulicenter.model.bean.NewGoodsBean;
import cn.ucai.fulicenter.model.bean.User;
import cn.ucai.fulicenter.model.utils.OkHttpUtils;

/**
 * Created by Administrator on 2017/1/16.
 */

public interface IModelUser {
    void downData(Context context, String username,String password, OnCompleteListener<String> listener);
    void register(Context context, String username, String usernick, String password,OnCompleteListener<String> listener);
}
