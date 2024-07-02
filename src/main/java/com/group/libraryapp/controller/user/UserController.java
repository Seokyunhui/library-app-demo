package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateReq;
import com.group.libraryapp.dto.user.UserResponse;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {
    private final JdbcTemplate jdbcTemplate;

    public UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateReq req){
        String sql = "INSERT INTO user(name, age) VALUES (? , ?)";
        jdbcTemplate.update(sql, req.getName(),req.getAge());
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers(){
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                return new UserResponse(id, name, age);
        });
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest req){
        String readSql = "SELECT * FROM user WHERE id = ?";
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, req.getId()).isEmpty();
        if(isUserNotExist){
            throw new IllegalArgumentException();
        }

        String sql = "UPDATE user SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, req.getName(), req.getId());
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        String readSql = "SELECT * FROM user WHERE name = ?";
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
        if(isUserNotExist){
            throw new IllegalArgumentException();
        }


        String sql = "DELETE FROM user WHERE name = ? ";
        jdbcTemplate.update(sql, name);

    }


}
