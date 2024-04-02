package ma.emsi.studentsapp;

import ma.emsi.studentsapp.entities.Product;
import ma.emsi.studentsapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class StudentsAppApplication implements CommandLineRunner {
    @Autowired //injection 
    private ProductRepository productRepository;


    public static void main(String[] args) {
        SpringApplication.run(StudentsAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"computer",400,2));
        productRepository.save(new Product(null,"Printer",1200,4));
        productRepository.save(new Product(null,"Smartphone",12500,2));
        List<Product> products = productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });
        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println("************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("***************|");
        List<Product> productList = productRepository.findByNameContains("C");
        productList.forEach (p->{
            System.out.println(p);
        });
            System.out.println("***************|");
        List<Product> productList2 = productRepository.search("%C%");
        productList.forEach (p->{
            System.out.println(p);
        });
        List<Product> productList3= productRepository.findByPriceGreaterThan(3000);
        productList.forEach (p->{
            System.out.println(p);
        });
        List<Product> productList4= productRepository.searchByPrice(3000);
        productList.forEach (p->{
            System.out.println(p);
        });







    }
    }
