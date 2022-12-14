package jpabook.jpashop;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpashopApplication.class, args);
	}

	@Bean
	Hibernate5Module hibernate5Module(){
		Hibernate5Module hibernate5Module = new Hibernate5Module();
		//실무에서 사용하면 안됨(entity 직접 노출 X) , 성능상에도 문제가됨
		//hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING,true);
		return hibernate5Module;
	}

}
