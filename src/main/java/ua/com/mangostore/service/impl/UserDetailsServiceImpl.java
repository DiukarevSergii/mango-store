package ua.com.mangostore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.mangostore.entity.Employee;
import ua.com.mangostore.service.EmployeeService;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = employeeService.getByEmail(email);
        if (employee == null)
            throw new UsernameNotFoundException(employee.getFullName() + " not found");

        Set<GrantedAuthority> roles = new HashSet<>();
        System.out.println(employee.getPosition().name().toString());
        roles.add(new SimpleGrantedAuthority(employee.getPosition().name().toString()));

        return new User(employee.getEmail(), employee.getPassword(), roles);
    }
}
