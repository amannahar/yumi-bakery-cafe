package com.yumi.cafe.controller;
import org.springframework.http.*;import org.springframework.web.bind.annotation.*;import java.util.*;
@RestController @RequestMapping("/api/payments") public class PaymentController { @PostMapping("/create") public Map<String,Object> create(@RequestBody Map<String,Object> body){return Map.of("mode","DEMO","message","Configure Razorpay/Cashfree credentials to enable live payments","amount",body.getOrDefault("amount",0));} }
