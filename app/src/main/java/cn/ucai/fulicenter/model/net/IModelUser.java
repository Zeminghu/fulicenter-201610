package cn.ucai.fulicenter.model.net;

import android.content.Context;
import android.view.View;

import java.io.File;

import cn.ucai.fulicenter.controller.activity.LoginActivity;
import cn.ucai.fulicenter.model.bean.CartBean;
import cn.ucai.fulicenter.model.bean.CollectBean;
import cn.ucai.fulicenter.model.bean.MessageBean;
import cn.ucai.fulicenter.model.bean.NewGoodsBean;
import cn.ucai.fulicenter.model.bean.User;
import cn.ucai.fulicenter.model.utils.OkHttpUtils;

/**
 * Created by Administrator on 2017/1/16.
 */

public interface IModelUser {
    void login(Context context, String username, String password, OnCompleteListener<String> listener);
    void register(Context context, String username, String usernick, String password, OnCompleteListener<String> listener);
    void updatNick(Context context, String username, String usernick, OnCompleteListener<String> listener);
    void uploadAvatar(Context context, String username, File file, OnCompleteListener<String> listener);
    void collecCount(Context context,String username,OnCompleteListener<MessageBean> listener);
    void getCollects(Context context,String username,int pageId,int pageSize,OnCompleteListener<CollectBean[]> listener);

    void getCart(Context context, String username, OnCompleteListener<CartBean[]> listener);
   // void addCart(Context context, String username, int goodsId, int count,OnCompleteListener<MessageBean> listener);
    //void delCart(Context context, int cartId,OnCompleteListener<MessageBean> listener);
   //void updateCart(Context context, int cartId,int count,OnCompleteListener<MessageBean> listener);
void updateCart(Context context,int action,String username,int goodsId, int count,int cartId,OnCompleteListener<MessageBean> listener);
}
