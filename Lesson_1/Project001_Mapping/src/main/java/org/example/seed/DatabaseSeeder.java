package org.example.seed;

import org.example.entities.*;
import org.example.utils.HibernateHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DatabaseSeeder {

    public static  void seed(){
        Transaction tx = null;

        try(Session session = HibernateHelper.getSession()){
            tx = session.beginTransaction();

            UserEntity user1 = createUser("john_doe", "john@example.com", "+380971112233");
            UserEntity user2 = createUser("alice_smith", "alice@example.com", "+380509998877");

            session.persist(user1);
            session.persist(user2);

            CategoryEntity electronics = createCategory("Електроніка", "Гаджети та побутова техніка");
            CategoryEntity books = createCategory("Книги", "Художня та наукова література");

            ProductEntity laptop = createProduct("Ноутбук Pro 15", "Потужний ноутбук для роботи", new BigDecimal("45000.00"), 10, electronics);
            ProductEntity phone = createProduct("Cмартфон X", "Сучасний смартфон з чудовою камерою", new BigDecimal("25000.00"), 25, electronics);
            ProductEntity bookJava = createProduct("Java Performance", "Глибоке занурення в JVM", new BigDecimal("1200.00"), 50, books);

            electronics.getProducts().add(laptop);
            electronics.getProducts().add(phone);
            books.getProducts().add(bookJava);

            addPhotoToProduct(laptop, "https://site.com/img/laptop-main.jpg", true);
            addPhotoToProduct(laptop, "https://site.com/img/laptop-side.jpg", false);
            addPhotoToProduct(phone, "https://site.com/img/phone.jpg", true);


            addReview(laptop, user1, 5, "Чудовий ноутбук, рекомендую!");
            addReview(laptop, user2, 4, "Працює швидко, але трохи гріється.");
            addReview(bookJava, user1, 5, "Найкраща книга по Java.");

            session.persist(electronics);
            session.persist(books);

            OrderEntity order = new OrderEntity();
            order.setUser(user1);
            order.setDeliveryAddress("м. Київ, вул. Хрещатик, 1");
            order.setStatus(OrderEntity.OrderStatus.PAID);
            order.setOrderDate(LocalDateTime.now());
            order.setOrderItems(new ArrayList<>());

            OrderItemEntity item1 = createOrderItem(order, laptop, 1, laptop.getPrice());
            OrderItemEntity item2 = createOrderItem(order, bookJava, 2, bookJava.getPrice());

            order.getOrderItems().add(item1);
            order.getOrderItems().add(item2);

            BigDecimal total = item1.getPricePerUnit().multiply(BigDecimal.valueOf(item1.getQuantity()))
                    .add(item2.getPricePerUnit().multiply(BigDecimal.valueOf(item2.getQuantity())));
            order.setTotalPrice(total);

            session.persist(order);

            tx.commit();
            System.out.println("База успішео заовнена");
        } catch (Exception e) {
            if(tx != null && tx.getStatus().canRollback()){
                tx.rollback();
            }
            System.err.println("Помилка під час заплвнення бд: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static UserEntity createUser(String username, String email, String phone){
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword("hasshed");
        user.setPhone(phone);
        user.setOrders(new ArrayList<>());
        user.setReviews(new ArrayList<>());
        return user;
    }

    private static CategoryEntity createCategory(String name, String description){
        CategoryEntity category = new CategoryEntity();
        category.setName(name);
        category.setDescription(description);
        category.setProducts(new ArrayList<>());
        return category;
    }

    private static ProductEntity createProduct(String name, String description, BigDecimal price, int quantity, CategoryEntity category){
        ProductEntity product = new ProductEntity();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantityInStock(quantity);
        product.setCategory(category);
        product.setPhotos(new ArrayList<>());
        product.setReviews(new ArrayList<>());
        product.setOrderItems(new ArrayList<>());
        return product;
    }

    private static void addPhotoToProduct(ProductEntity product, String url, boolean isMain) {
        ProductPhotoEntity photo = new ProductPhotoEntity();
        photo.setUrl(url);
        photo.setIsMain(isMain);
        photo.setProduct(product);
        product.getPhotos().add(photo);
    }

    private static void addReview(ProductEntity product, UserEntity user, int rating, String comment){
        ReviewEntity review = new ReviewEntity();
        review.setRating(rating);
        review.setComment(comment);
        review.setUser(user);
        review.setProduct(product);

        product.getReviews().add(review);
        user.getReviews().add(review);
    }

    private static OrderItemEntity createOrderItem(OrderEntity order, ProductEntity product, int quantity, BigDecimal price){
        OrderItemEntity ordItem = new OrderItemEntity();
        ordItem.setOrder(order);
        ordItem.setProduct(product);
        ordItem.setPricePerUnit(price);
        ordItem.setQuantity(quantity);

        return  ordItem;
    }

}
