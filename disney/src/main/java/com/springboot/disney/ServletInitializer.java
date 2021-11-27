
package com.springboot.disney;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Cortinez Juan José
 */
public class ServletInitializer extends SpringBootServletInitializer{
     @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DisneyApplication.class);
    }
}
