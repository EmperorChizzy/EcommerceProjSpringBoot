package com.example.ecommerceprojspringboot.controllers;

import com.example.ecommerceprojspringboot.models.Product;
import com.example.ecommerceprojspringboot.serviceImpl.OrderServiceImpl;
import com.example.ecommerceprojspringboot.serviceImpl.ProductServiceImpl;
import com.example.ecommerceprojspringboot.serviceImpl.UsersServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductServiceImpl productService;
    private UsersServiceImpl usersService;
    private final OrderServiceImpl orderService;

    @Autowired
    public ProductController(ProductServiceImpl productService, UsersServiceImpl usersService, OrderServiceImpl orderService) {
        this.productService = productService;
        this.usersService = usersService;
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public ModelAndView findAllProducts(HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Product> productList = productService.findAllProducts.get();
        return new ModelAndView("dashboard")
                .addObject("products", productList)
                .addObject("cartItems", "Cart Items: "+session.getAttribute("cartItems"));
    }

    @GetMapping("/add-cart")
    public String addToCart(@RequestParam(name = "cart") Long id, HttpServletRequest request, Model model){
        productService.addProductToCart(id, request);
        return "redirect:/products/all";
    }



    @GetMapping("/payment")
    public String checkOut(HttpSession session, Model model){
        productService.checkOutCart(session, model);
        model.addAttribute("paid", "");
        return "checkout";
    }

    @GetMapping("/pay")
    public String orderPayment(HttpSession session, Model model){
        return orderService.makePayment(session, model);
    }



}
