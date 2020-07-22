package am.harut.springimagegallery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private LocalDateTime uploadDate;
    private String picUrl;
    @ManyToOne
    private Category category;
}
