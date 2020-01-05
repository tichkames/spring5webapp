package hod.springframework.spring5webapp;

import hod.springframework.spring5webapp.bean.example.FakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring5webappApplication {

	public static void main(String[] args) {
//		SpringApplication.run(Spring5webappApplication.class, args);
		ApplicationContext ctx = SpringApplication.run(Spring5webappApplication.class, args);

		FakeDataSource fakeDS = (FakeDataSource) ctx.getBean(FakeDataSource.class);
		System.out.println(String.format("fakeDS username: %s, password: %s, dburl: %s, customField: %s",
				fakeDS.getUser(), fakeDS.getPass(), fakeDS.getUrl(), fakeDS.getCustomField()));
	}

}
