package gaoyang.baway.com.mvpdemo.bean;

import java.io.Serializable;

/**
 * Created by 15218 on 2017/11/13.
 */
public class ShopBean implements Serializable{

    private String name;
    private String image ;
    private String num ;
    private String price ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ShopBean{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", num='" + num + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
