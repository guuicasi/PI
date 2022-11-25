package com.mycompany.perfumaria;

import com.mycompany.perfumaria.Pages.LoginPage;
import com.mycompany.perfumaria.Pages.MainPage;
import com.mycompany.perfumaria.Pages.RegisterAddress;
import com.mycompany.perfumaria.Pages.RegisterPage;
import com.mycompany.perfumaria.Pages.ReportPage;
import com.mycompany.perfumaria.Pages.SallerPage;
import com.mycompany.perfumaria.model.Person;
import com.mycompany.perfumaria.model.Product;
import com.mycompany.perfumaria.model.Sale;
import com.mycompany.perfumaria.services.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Perfumaria {
    private static ProductService productService = new ProductService();

    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static RegisterPage registerPage;
    public static RegisterAddress registerAddress;
    public static SallerPage sallerPage;
    public static ReportPage reportPage;
    
    public static List<Product> productList = new ArrayList<Product>();
    public static List<Sale> saleList = new ArrayList<Sale>();
    public static Person person = new Person();
    public static List<Product> cartList = new ArrayList<Product>();

    public static void main(String[] args) {
        setInstanceLoginPage();
        setInstanceReportPage();
        loginPage.setVisible(true);

        productList = productService.getAllProducts();
    }

    public static void setInstanceRegisterAddress() {
        registerAddress = new RegisterAddress();
    }

    public static void setInstanceMainPage() {
        mainPage = new MainPage();
    }

    public static void setInstanceSallerPage() {
        sallerPage = new SallerPage();
    }

    public static void setInstanceRegisterPage() {
        registerPage = new RegisterPage();
    }

    public static void setInstanceLoginPage() {
        loginPage = new LoginPage();
    }

    public static void setInstanceReportPage() {
        reportPage = new ReportPage();
    }
}
