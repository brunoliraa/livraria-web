package livraria.livraria.controller;


import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import livraria.livraria.model.Edicao;
import livraria.livraria.model.Venda;
import livraria.livraria.service.PaypalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Controller
public class PaypalController {
    @Autowired
    PaypalService paypalService;

    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";


    @PostMapping("/pay")
    public String payment(@ModelAttribute("venda") Venda venda) {
        System.out.println(venda.getValorTotal());

        try {
            Payment payment = paypalService.createPayment(venda.getValorTotal(), "BRL", "paypal",
                    "sale", "teste", "http://localhost:8080/" + CANCEL_URL,
                    "http://localhost:8080/" + SUCCESS_URL);
            //link para redirecionar pro pagamento aprovado
            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    return "redirect:"+link.getHref();
                }
            }

        } catch (PayPalRESTException e) {

            e.printStackTrace();
        }
        return "redirect:/carrinho";
    }

    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "index";
    }

    @GetMapping(value = SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return "success";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/ok";
    }

}
