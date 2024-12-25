package com.todomanagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author: Makarand Milind Hinge
 * Email: mmh2212002@gmail.com
 * LinkedIn: linkedin.com/in/makarand-hinge
 *
 * This is the main application class for the Todo Management System.
 * It provides APIs to manage Todo items efficiently.
 */
@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Todo Management Application API",
                version = "1.0",
                description = "API for managing Todos efficiently. " +
                        "If you don't have an email client installed, " +
                        "you can send an email to me directly using any of the following services:" +
                        "<ul>" +
                        "<li><a href='https://mail.google.com/mail/?view=cm&fs=1&to=mmh2212002@gmail.com'>Send Email via Gmail</a></li>" +
                        "<li><a href='https://outlook.live.com/mail/0/deeplink/compose?to=mmh2212002@gmail.com'>Send Email via Outlook</a></li>" +
                        "<li><a href='https://compose.mail.yahoo.com/?to=mmh2212002@gmail.com'>Send Email via Yahoo Mail</a></li>" +
                        "</ul>",
                contact = @Contact(
                        name = "Makarand Milind Hinge",
                        email = "mmh2212002@gmail.com",
                        url = "https://linkedin.com/in/makarand-hinge"
                )
        )
)

public class TodoManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoManagementApplication.class, args);
    }
}
