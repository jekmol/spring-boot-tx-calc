package com.tax.calculator.controller;

import com.tax.calculator.dto.BillDto;
import com.tax.calculator.dto.BillListDto;
import com.tax.calculator.model.Bill;
import com.tax.calculator.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillController {

    @Autowired
    private BillRepository billRepository;

    @RequestMapping(value = "/getbills", method = RequestMethod.GET)
    public BillListDto getBills(){
        List<Bill> result  = billRepository.findAll();
        BillListDto billListDto = new BillListDto();

        for (Bill bill : result) {
            BillDto billDto = new BillDto();
            billDto.setName(bill.getName());
            billDto.setPrice(bill.getPrice());
            billDto.setTaxCode(bill.getTaxCode());

            billListDto.setPriceSubTotal(billListDto.getPriceSubTotal() + bill.getPrice());
            billListDto.setTaxSubTotal(billListDto.getTaxSubTotal() + billDto.getTax());
            billListDto.setGrandTotal(billListDto.getGrandTotal() + billDto.getAmount());

            billListDto.getBills().add(billDto);
        }

        return billListDto;
    }

    @PostMapping(value = "/addbill")
    public Bill addBill(@RequestBody Bill bill) {

        Bill result = billRepository.save(bill);

        return result;
    }
}
