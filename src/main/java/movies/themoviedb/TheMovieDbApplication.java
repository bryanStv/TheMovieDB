package movies.themoviedb;

import movies.themoviedb.ui.Login;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.*;

@SpringBootApplication
public class TheMovieDbApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(TheMovieDbApplication.class)
                        .headless(false)
                        .web(WebApplicationType.NONE)
                        .run(args);

        EventQueue.invokeLater(() -> {
            // Obtenemos los objetos form a través de Spring
            //LoginUI loginUI = context.getBean(LoginUI.class);
            //loginUI.setVisible(true);
            Login login = context.getBean(Login.class);
            login.main();
            //System.out.println(AnimeService.urlImagen("naruto"));
        });

    }

}
