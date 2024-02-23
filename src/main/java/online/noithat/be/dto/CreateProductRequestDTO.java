package online.noithat.be.dto;

import java.util.List;

public class CreateProductRequestDTO {
    String name;
    List<Long> categoriesId;

    float price;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    String img;

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public List<Long> getCategoriesId() {
        return categoriesId;
    }
}
