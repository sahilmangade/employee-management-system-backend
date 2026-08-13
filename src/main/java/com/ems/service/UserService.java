package com.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dto.LoginDTO;
import com.ems.dto.RegisterDTO;
import com.ems.entity.Employee;
import com.ems.entity.User;
import com.ems.repository.EmployeeRepository;
import com.ems.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userrepo;

    @Autowired
    EmployeeRepository employeerepo;

    public String register(RegisterDTO dto) {

        // Check Employee Code Exists
        Employee employee =
        		employeerepo.findByEmployeecode(
                        dto.getEmployeecode());

        if (employee == null) {
            return "Invalid Employee Code";
        }

        // Check Employee Already Registered
        User existingEmployee =
                userrepo.findByEmployeecode(
                        dto.getEmployeecode());

        if (existingEmployee != null) {
            return "Employee already registered";
        }

        // Check Username Already Exists
        User existingUsername =
                userrepo.findByUsername(
                        dto.getUsername());

        if (existingUsername != null) {
            return "Username already exists";
        }

        // Check Password Match
        if (!dto.getPassword().equals(
                dto.getConfirmpassword())) {

            return "Password and Confirm Password do not match";
        }

        // Save User
        User user = new User();

        user.setEmployeecode(
                dto.getEmployeecode());

        user.setUsername(
                dto.getUsername());

        user.setPassword(
                dto.getPassword());

        user.setConfirmpassword(
                dto.getConfirmpassword());

        user.setRole("EMPLOYEE");

        userrepo.save(user);

        return "Registration Successful";
    }
    
    
    
    // Admin

    public String addAdmin(RegisterDTO dto) {

        // Check Username Already Exists
        User existingUsername =
                userrepo.findByUsername(
                        dto.getUsername());

        if (existingUsername != null) {
            return "Username already exists";
        }

        // Check Employee Code Already Exists
        User existingEmployee =
                userrepo.findByEmployeecode(
                        dto.getEmployeecode());

        if (existingEmployee != null) {
            return "Employee Code already exists";
        }

        // Check Password Match
        if (!dto.getPassword().equals(
                dto.getConfirmpassword())) {

            return "Password and Confirm Password do not match";
        }

        // Create Admin User
        User user = new User();

        user.setEmployeecode(
                dto.getEmployeecode());

        user.setUsername(
                dto.getUsername());

        user.setPassword(
                dto.getPassword());

        user.setConfirmpassword(
                dto.getConfirmpassword());

        // Admin Role
        user.setRole("ADMIN");

        userrepo.save(user);

        return "Admin Created Successfully";
    }
    
    
    
    
    
    // Login
    public User login(LoginDTO dto) {

        User existingUser =
                userrepo.findByUsername(
                        dto.getUsername());

        if(existingUser == null) {
            return null;
        }

        if(existingUser.getPassword().equals(
                dto.getPassword())) {

            return existingUser;
        }

        return null;
    }
}