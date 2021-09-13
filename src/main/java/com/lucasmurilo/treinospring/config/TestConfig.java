package com.lucasmurilo.treinospring.config;

import com.lucasmurilo.treinospring.entities.Category;
import com.lucasmurilo.treinospring.entities.Product;
import com.lucasmurilo.treinospring.entities.User;
import com.lucasmurilo.treinospring.repositories.CategoryRepository;
import com.lucasmurilo.treinospring.repositories.ProductRepository;
import com.lucasmurilo.treinospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p3.getCategories().addAll(Arrays.asList(cat1, cat3));
        p4.getCategories().addAll(Arrays.asList(cat1, cat3));
        p5.getCategories().add(cat2);

        cat1.getProducts().addAll(Arrays.asList(p2, p3, p4));
        cat2.getProducts().addAll(Arrays.asList(p1, p5));
        cat3.getProducts().addAll(Arrays.asList(p3, p4));

        categoryRepository.saveAll(Arrays.asList(cat1,cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");


        usuarioRepository.saveAll(Arrays.asList(u1, u2));

    }
}
