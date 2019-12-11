package com.basket.service.impl;

import com.basket.model.Basket;
import com.basket.model.Product;
import com.basket.repository.ProductRepository;
import com.basket.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BasketServiceImpl implements BasketService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public void putProduct(List<Basket> basketList, int id) {
        boolean check = false;

        for (Basket basket: basketList){
            if (basket.getProduct().getId()== id){
                check = true;
                basket.setMount(basket.getMount() + 1);
                break;
            }
        }
        if (!check){
            Basket basket = new Basket();
            Product product = productRepository.findById(id);
            basket.setProduct(product);
            basket.setMount(1);
            basketList.add(basket);
        }
    }

    @Override
    public void changeAmount(List<Basket> basketList, int id, int amount) {
        for (Basket basket: basketList){
            if (basket.getProduct().getId()== id){
                basket.setMount(amount);
                break;
            }
        }
    }

    @Override
    public void removeProduct(List<Basket> basketList, int id) {
        for (Basket basket: basketList){
            if (basket.getProduct().getId()== id){
                basketList.remove(basket);
                break;
            }
        }
    }
}
