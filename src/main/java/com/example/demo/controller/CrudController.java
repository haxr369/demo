package com.example.demo.controller;

import com.example.demo.entity.CrudEntity;
import com.example.demo.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class CrudController {
    private final CrudRepository crudEntityRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("update")
    public String updateMember(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        List<CrudEntity> crudEntityList = crudEntityRepository.findByUsername(username);

        if (crudEntityList.isEmpty()) {
            return "입력한 " + username + "이 존재하지 않습니다";
        } else {
            CrudEntity existingEntity = crudEntityList.get(0); //
            existingEntity.setPassword(password);
            crudEntityRepository.save(existingEntity);
            return username + "의 비밀번호를 " + password + "로 변경 완료";
        }
    }


    @GetMapping("delete")
    public String deleteMember(@RequestParam(value = "username") String username) {
        if(crudEntityRepository.findByUsername(username).isEmpty()) { // 값 존재여부 확인
            return "입력한 " + username + "이 존재하지 않습니다";
        } else {
            List<CrudEntity> crudentity = crudEntityRepository.findByUsername(username);
            System.out.println(crudentity);
            crudEntityRepository.delete(crudentity.get(0));
            return username + " 삭제 완료";
        }
    }

    @GetMapping("insert") // create
    public String insertMember(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        System.out.println("이름 : " + username + " 비번 : " + password + "으로 추가 될것입니다.");
        System.out.println(crudEntityRepository.findByUsername(username));
        if(!crudEntityRepository.findByUsername(username).isEmpty()) {
            return "동일한 이름이 이미 있습니다";
        } else {
            CrudEntity entity = CrudEntity.builder().username(username).password(password).build();
            crudEntityRepository.save(entity);
            return "이름 : " + username + " 비번 : " + password + "으로 추가 되었습니다";
        }
    }

    @GetMapping("searchParamRepo") // read
    public String searchParamRepoMember(@RequestParam(value = "username") String username) {
        return crudEntityRepository.findByUsername(username).toString();
    }

}
