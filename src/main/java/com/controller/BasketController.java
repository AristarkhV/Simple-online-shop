package com.controller;

import com.model.Basket;
import com.model.Product;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.service.BasketService;
import com.service.ProductService;

import java.util.Optional;

@Controller
@RequestMapping("/user/products")
public class BasketController {

    private final BasketService basketService;
    private final ProductService productService;

    @Autowired
    public BasketController(BasketService basketService, ProductService productService) {
        this.basketService = basketService;
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView viewBasketPage() {
        return new ModelAndView("products_for_user", "products",
                productService.getAllProducts());
    }

    @GetMapping("/basket")
    public ModelAndView viewAllProducts(@AuthenticationPrincipal User sessionUser, Model model) {
        Optional<Basket> optionalBasket = basketService.getBasketByUser(sessionUser);
        Basket basket = null;
        if (optionalBasket.isPresent()) {
            basket = optionalBasket.get();
        }
        model.addAttribute("productsInBasket", productService.getAllProducts());
        return new ModelAndView("basket", "basket", basket);
    }

    @GetMapping("/basket/add")
    public String addProductInBasket(@AuthenticationPrincipal User sessionUser,
                                     @RequestParam("id") Long id) {
        Optional<Basket> optionalBasket = basketService.getBasketByUser(sessionUser);
        Basket basket;
        if (optionalBasket.isPresent()) {
            basket = optionalBasket.get();
        } else {
            basket = new Basket(sessionUser);
            basketService.add(basket);
        }
        Optional<Product> optionalProduct = productService.getById(id);
        optionalProduct.ifPresent(product -> basketService.addProduct(basket, product));
        return "redirect:/user/products/basket";
    }

}
