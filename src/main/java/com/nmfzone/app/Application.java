package com.nmfzone.app;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nmfzone.app.config.App;
// import com.nmfzone.app.model.Developer;
// import com.nmfzone.app.model.Skill;
// import com.nmfzone.app.repository.DeveloperRepository;
// import com.nmfzone.app.repository.SkillRepository;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.nmfzone")
// public class Application implements CommandLineRunner {
public class Application {

    // @Autowired
    // DeveloperRepository developerRepository;
    //
    // @Autowired
    // SkillRepository skillRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        // ctx.register(App.class);
        // ctx.refresh();
    }

    // @Override
	// public void run(String... args) throws Exception {
	// 	Skill javascript = new Skill("javascript", "Javascript language skill");
	// 	Skill ruby = new Skill("ruby", "Ruby language skill");
	// 	Skill emberjs = new Skill("emberjs", "Emberjs framework");
	// 	Skill angularjs = new Skill("angularjs", "Angularjs framework");
    //
	// 	skillRepository.save(javascript);
	// 	skillRepository.save(ruby);
	// 	skillRepository.save(emberjs);
	// 	skillRepository.save(angularjs);
    //
	// 	List<Developer> developers = new LinkedList<Developer>();
	// 	developers.add(new Developer("John", "Smith", "john.smith@example.com",
	// 			Arrays.asList(new Skill[] { javascript, ruby })));
	// 	developers.add(new Developer("Mark", "Johnson", "mjohnson@example.com",
	// 			Arrays.asList(new Skill[] { emberjs, ruby })));
	// 	developers.add(new Developer("Michael", "Williams", "michael.williams@example.com",
	// 			Arrays.asList(new Skill[] { angularjs, ruby })));
	// 	developers.add(new Developer("Fred", "Miller", "f.miller@example.com",
	// 			Arrays.asList(new Skill[] { emberjs, angularjs, javascript })));
	// 	developers.add(new Developer("Bob", "Brown", "brown@example.com",
	// 			Arrays.asList(new Skill[] { emberjs })));
	// 	developerRepository.save(developers);
	// }

}
