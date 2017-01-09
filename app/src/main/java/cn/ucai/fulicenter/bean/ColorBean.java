package cn.ucai.fulicenter.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/9.
 */

public class ColorBean implements Serializable {

    /**
     * id : 8453
     * goodsId : 0
     * colorId : 5
     * colorName : 紫色
     * colorCode : #a658d1
     * colorImg : 201309/1380065007479814548.jpg
     */

    private int id;
    private int goodsId;
    private int colorId;
    private String colorName;
    private String colorCode;
    private String colorImg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorImg() {
        return colorImg;
    }

    public void setColorImg(String colorImg) {
        this.colorImg = colorImg;
    }

    @Override
    public String toString() {
        return "ColorBean{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", colorId=" + colorId +
                ", colorName='" + colorName + '\'' +
                ", colorCode='" + colorCode + '\'' +
                ", colorImg='" + colorImg + '\'' +
                '}';
    }
}
