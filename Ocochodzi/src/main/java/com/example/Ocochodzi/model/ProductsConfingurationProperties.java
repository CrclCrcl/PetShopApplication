package com.example.Ocochodzi.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("products")
public class ProductsConfingurationProperties {
    private Template template;
    public Template getTemplate() {
        return template;
    }

    public void setTemplate(final Template template) {
        this.template = template;
    }


    public boolean allowToMultipleProductsFromTemplate;

    public static class Template{
        private boolean allowToMultpileProducts;
       public boolean isAllowToMultpileProducts() {
            return allowToMultpileProducts;
        }

       public void setAllowToMultpileProducts(final boolean allowToMultpileProducts) {
            this.allowToMultpileProducts = allowToMultpileProducts;
        }


    }
}
