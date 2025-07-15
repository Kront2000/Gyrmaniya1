package Entity;

import lombok.*;

@Setter
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Dish {
    private Long id;
    private Categories categories;
    private Long categoriesID;
    private String description;
    private String image_path;
    private String name;
    private Long price;

    public Dish(Long categoriesID, String description, String image_path, String name, Long price) {
        this.categoriesID = categoriesID;
        this.description = description;
        this.image_path = image_path;
        this.name = name;
        this.price = price;
    }

    public Dish(Long id, Categories categories, String description, String image_path, String name, Long price) {
        this.id = id;
        this.categories = categories;
        this.description = description;
        this.image_path = image_path;
        this.name = name;
        this.price = price;
    }
}
