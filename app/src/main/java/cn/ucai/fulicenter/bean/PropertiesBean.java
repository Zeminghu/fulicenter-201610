package cn.ucai.fulicenter.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/9.334223
 */

public class PropertiesBean implements Serializable{

    /**
     * id : 9522
     * goodsId : 0
     * colorId : 4
     * colorName : 绿色
     * colorCode : #59d85c
     * colorImg : 201309/1380064997570506166.jpg
     * colorUrl : 1
     * albums : [{"pid":7672,"imgId":28283,"imgUrl":"201509/goods_img/7672_P_1442389445199.jpg","thumbUrl":"no_picture.gif"}]
     */

    private int id;
    private int goodsId;
    private int colorId;
    private String colorName;
    private String colorCode;
    private String colorImg;
    private String colorUrl;
    private List<AlbumsBean> albums;

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

    public String getColorUrl() {
        return colorUrl;
    }

    public void setColorUrl(String colorUrl) {
        this.colorUrl = colorUrl;
    }

    public List<AlbumsBean> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumsBean> albums) {
        this.albums = albums;
    }

    public static class AlbumsBean {
        /**
         * pid : 7672
         * imgId : 28283
         * imgUrl : 201509/goods_img/7672_P_1442389445199.jpg
         * thumbUrl : no_picture.gif
         */

        private int pid;
        private int imgId;
        private String imgUrl;
        private String thumbUrl;

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getImgId() {
            return imgId;
        }

        public void setImgId(int imgId) {
            this.imgId = imgId;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getThumbUrl() {
            return thumbUrl;
        }

        public void setThumbUrl(String thumbUrl) {
            this.thumbUrl = thumbUrl;
        }

        @Override
        public String toString() {
            return "AlbumsBean{" +
                    "pid=" + pid +
                    ", imgId=" + imgId +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", thumbUrl='" + thumbUrl + '\'' +
                    '}';
        }
    }
}
