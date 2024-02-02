package com.example.Ocochodzi.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("products")
public class ProductsConfingurationProperties {
    public static class Template {
        private boolean allowToMultipleProducts;
        public boolean isAllowToMultipleProducts() { return allowToMultipleProducts; }

        public void setAllowToMultipleProducts(final boolean allowToMultipleProducts) {
            this.allowToMultipleProducts = allowToMultipleProducts;
        }


    }
    private Template template;
    public Template getTemplate() {
        return template;
    }

    public void setTemplate(final Template template) {
        this.template = template;
    }



}
