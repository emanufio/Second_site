package Second_site;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//e' un annotazione che aggiunge le seguenti annotazioni
//@configuration->  tagga le classi come sorgenti di definizione di bean per il contesto 
//dell applicazione
//@enableautoconfiguration->   dice a spring boot di aggiungere beans basati sulle proprieta' del
//classpath e impostazioni varie
//@componentscan->   dice a spring di controllare altri componenti e impostazioni nel package 
//hello

//indica una classe di configurazione che dichiara uno o pi� metodi bean
@SpringBootApplication
public class Application implements WebMvcConfigurer {

    public static void main(String[] args) {
    	//lancia l applicazione
        SpringApplication.run(Application.class, args);
    }
    
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // Register resource handler for images
        registry.addResourceHandler("/public/images/**").addResourceLocations("/public/images/")
                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
    }
    
    

}