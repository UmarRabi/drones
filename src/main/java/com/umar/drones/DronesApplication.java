package com.umar.drones;

import com.umar.drones.services.DronesService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class DronesApplication {

    

	public static void main(String[] args) {  
		SpringApplication.run(DronesApplication.class, args);
                DronesService dronesService=new DronesService();
                dronesService.idle();
	}
}
