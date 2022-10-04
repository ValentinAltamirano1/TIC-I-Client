package com.example.usuario.usuario;//import com.example.Restaurante1.Restaurante.JavaFXApplication;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Restaurante1Application {

	public static void main(String[] args) {
		//SpringApplication.run(Restaurante1Application.class, args);
		Application.launch(com.example.usuario.usuario.Application.class,args);
	}

}