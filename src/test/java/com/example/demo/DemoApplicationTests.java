package com.example.demo;

import com.example.demo.entity.CrudEntity;
import com.example.demo.repository.CrudRepository;
import com.example.demo.controller.CrudController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private CrudRepository crudRepository;

	@Test
	public void createTest(){
		CrudEntity crudentity = CrudEntity.builder().username("ohsol").password("chansol").build();
		CrudEntity savedEntity = crudRepository.save(crudentity);

		CrudController crudController = new CrudController(crudRepository);
		crudController.insertMember("Hyrn","1234");
	}

	@Test
	public void readTest(){
		CrudController crudController = new CrudController(crudRepository);
		String result = crudController.searchParamRepoMember("Hyrn");
		System.out.println(result);
	}

	@Test
	public void updateTest(){
		CrudController crudController = new CrudController(crudRepository);
		String result = crudController.updateMember("Hyrn","4321");
		System.out.println(result);
	}

	@Test
	public void deleteTest(){
		CrudController crudController = new CrudController(crudRepository);
		String result = crudController.deleteMember("Hyrn");
		System.out.println(result);
	}


}
