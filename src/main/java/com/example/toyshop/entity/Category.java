package com.example.toyshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.Normalizer;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    @Column(unique = true)
    private String slug;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public String slugify() {
        String a = Normalizer
                .normalize(this.title, Normalizer.Form.NFD)
                .replace("[^\\w\\s-]", "") // Remove all non-word, non-space or non-dash characters
                .replace('-', ' ') // Replace dashes with spaces
                .trim() // Trim leading/trailing whitespace (including what used to be leading/trailing dashes)
                .replace("\\s+", "-") // Replace whitespace (including newlines and repetitions) with single dashes
                .toLowerCase();// Lowercase the final results
        slug = a;
        return a;
    }
}
