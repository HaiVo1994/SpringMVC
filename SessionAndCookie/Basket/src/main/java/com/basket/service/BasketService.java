package com.basket.service;

import com.basket.model.Basket;
import com.basket.model.Product;

import java.util.List;

public interface BasketService {
    void putProduct(List<Basket> basketList, int id);
    void changeAmount(List<Basket> basketList, int id, int amount);
    void removeProduct(List<Basket> basketList, int id);
}
