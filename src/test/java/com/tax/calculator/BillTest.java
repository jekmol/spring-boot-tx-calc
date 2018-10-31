package com.tax.calculator;

import com.tax.calculator.Constants.TaxType;
import com.tax.calculator.dto.BillDto;
import com.tax.calculator.model.Bill;
import com.tax.calculator.repository.BillRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class BillTest {

    @Autowired
    BillRepository billRepository;

    @Test
    public void checkTaxType() throws Exception {
        //FOOD
        Bill foodBill = new Bill();
        foodBill.setName("TEST FOOD");
        foodBill.setTaxCode(TaxType.FOOD.getCode());
        foodBill.setPrice(10000);

        Bill result1 = billRepository.save(foodBill);
        BillDto resultDto1 = new BillDto();
        resultDto1.setPrice(result1.getPrice());
        resultDto1.setTaxCode(result1.getTaxCode());
        double expectedTax1 = result1.getPrice()*10/100;
        double  actualTax1 = resultDto1.getTax();

        String expectedType1 = "Food & Beverage";
        String actualType1 = resultDto1.getType();

        assertEquals(expectedTax1, actualTax1,0.001);
        assertEquals(expectedType1,actualType1);

        //TOBACCO
        Bill tobaccoBill = new Bill();
        tobaccoBill.setName("TEST TOBACCO");
        tobaccoBill.setTaxCode(TaxType.TOBACCO.getCode());
        tobaccoBill.setPrice(20000);

        Bill result2 = billRepository.save(tobaccoBill);
        BillDto resultDto2 = new BillDto();
        resultDto2.setPrice(result2.getPrice());
        resultDto2.setTaxCode(result2.getTaxCode());
        double expectedTax2 = 10 + result2.getPrice()* 2/100;;
        double  actualTax2 = resultDto2.getTax();

        String expectedType2 = "Tobacco";
        String actualType2 = resultDto2.getType();

        assertEquals(expectedTax2, actualTax2,0.001);
        assertEquals(expectedType2,actualType2);

        //ENTERTAINMENT
        Bill entertainmentBill = new Bill();
        entertainmentBill.setName("TEST ENTERTAINMENT");
        entertainmentBill.setTaxCode(TaxType.ENTERTAINMENT.getCode());
        entertainmentBill.setPrice(50);

        Bill result3 = billRepository.save(entertainmentBill);
        BillDto resultDto3 = new BillDto();
        resultDto3.setPrice(result3.getPrice());
        resultDto3.setTaxCode(result3.getTaxCode());
        double expectedTax3 = 0; //tax free
        double actualTax3 = resultDto3.getTax();

        String expectedType3 = "Entertainment";
        String actualType3 = resultDto3.getType();

        assertEquals(expectedTax3, actualTax3,0.001);
        assertEquals(expectedType3,actualType3);

    }
}
