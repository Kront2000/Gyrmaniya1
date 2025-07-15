package Entity;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Categories {
    private Long id;
    private String name;

    public Categories(String name) {
        this.name = name;
    }
}
