package com.controller;

import com.model.Basket;
import com.model.Code;
import com.model.Order;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.service.BasketService;
import com.service.CodeService;
import com.service.MailService;
import com.service.OrderService;
import com.util.RandomHelper;

import java.util.Optional;

@Controller
@RequestMapping("/user/order")
public class OrderController {

    private CodeService codeService;
    private BasketService basketService;
    private OrderService orderService;
    private MailService mailService;

    @Autowired
    private OrderController(CodeService codeService, BasketService basketService,
                            OrderService orderService, MailService mailService) {
        this.codeService = codeService;
        this.basketService = basketService;
        this.orderService = orderService;
        this.mailService = mailService;
    }

    @GetMapping
    public ModelAndView order() {
        return new ModelAndView("order", "order",
                new Order());
    }

    @PostMapping
    public String order(@AuthenticationPrincipal User sessionUser,
                        @ModelAttribute("order") Order order, Model model) {
        Long id = order.getId();
        String firstName = order.getFirstName();
        String lastName = order.getLastName();
        String numberOfPhone = order.getNumberOfPhone();
        String streetName = order.getStreetName();
        String houseNumber = order.getHouseNumber();
        if (firstName.isEmpty() || lastName.isEmpty() || numberOfPhone.isEmpty()
                || streetName.isEmpty() || houseNumber.isEmpty()) {
            model.addAttribute("valid", "The fields is valid");
            return "order";
        } else {
            Code code = new Code(RandomHelper.getFourDigitCode(), sessionUser);
            codeService.add(code);
            Optional<Basket> optBasket = basketService.getBasketByUser(sessionUser);
            if (optBasket.isPresent()) {
                Order currentOrder = new Order(id, firstName, lastName, numberOfPhone, streetName,
                        houseNumber, optBasket.get());
                orderService.addOrder(currentOrder);
            }
            mailService.sendOneTimeCode(code, sessionUser.getEmail());
            return "confirm_order";
        }
    }

    @GetMapping("/confirm")
    public ModelAndView confirmOrder() {
        return new ModelAndView("confirm_order");
    }

    @PostMapping("/confirm")
    public ModelAndView confirmOrder(@RequestParam("code") String enteredCode,
                                     @AuthenticationPrincipal User sessionUser,
                                     Model model) {
        if (enteredCode.isEmpty()) {
            model.addAttribute("wrongCode", "The code is wrong. Try again");
        } else {
            Optional<Code> optionalCode = codeService.getLastCodeForUser(sessionUser);
            if (optionalCode.isPresent()) {
                Code code = optionalCode.get();
                if (enteredCode.equals(code.getCode())) {
                    model.addAttribute("ok", "Your buying was successful");
                } else {
                    model.addAttribute("wrongCode", "The code is wrong. Try again");
                }
            }
        }
        return new ModelAndView("confirm_order");
    }

}
