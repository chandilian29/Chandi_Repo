/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.controller;

import com.edu.mum.service.ProductService;
import com.mum.edu.domain.Product;
import com.mum.edu.domain.Stock;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Sandy
 */
@Controller
public class ProductController {

    public long id;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id) {
        productService.delete(id);
        return "redirect:/viewProduct";
    }

    @RequestMapping(value = "/addStockTable/{id}", method = RequestMethod.GET)
    public String getProductStock(@PathVariable long id, Model model) {
        Product p = productService.get(id);
        id = p.getId();
        return "stockNext";
    }

    @RequestMapping(value = "/addStockTable/{id}", method = RequestMethod.POST)
    public String stockNext(@RequestParam("quantity") String quantity) {
        Stock stock = new Stock(id, quantity);
        productService.addStock(stock);
        return "sucess";
    }

    @RequestMapping(value = "/viewProduct/{id}", method = RequestMethod.GET)
    public String get(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.get(id));
        return "productDetail";
    }

    @RequestMapping(value = "/viewProduct/{id}", method = RequestMethod.POST)
    public String update(@Valid Product product, BindingResult result, @PathVariable long id) {
        if (!result.hasErrors()) {
            productService.update(id, product); // car.id already set by binding
            return "redirect:/viewProduct";
        } else {
            return "productDetail";
        }
    }

    //Controllers for Product
    @RequestMapping(value = "/viewProduct", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("products", productService.getAll());
        return "productList";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String addProduct(@ModelAttribute("myproduct") Product product) {
        return "addProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@Valid Product product, BindingResult result, RedirectAttributes re) {
        if (!result.hasErrors()) {
            productService.addProduct(product);
        }
        return "redirect:/viewProduct";
    }
}
