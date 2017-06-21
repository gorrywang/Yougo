package xyz.abug.www.yougo.bean;

/**
 * Created by iswgr on 2017/6/20.
 * 商城衣服实体类
 */

public class ShopVO {
    //类别
    private String mClass;
    //价格
    private String money;
    //名字
    private String name;
    //售出
    private int shouchu;
    //图片
    private int img;

    public ShopVO(String mClass, String money, String name, int shouchu, int img) {
        this.mClass = mClass;
        this.money = money;
        this.name = name;
        this.shouchu = shouchu;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getmClass() {
        return mClass;
    }

    public void setmClass(String mClass) {
        this.mClass = mClass;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShouchu() {
        return shouchu;
    }

    public void setShouchu(int shouchu) {
        this.shouchu = shouchu;
    }
}
