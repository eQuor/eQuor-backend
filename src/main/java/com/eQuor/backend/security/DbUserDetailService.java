package com.eQuor.backend.security;


import com.eQuor.backend.models.Staff;
import com.eQuor.backend.repositories.LecturerRepository;
import com.eQuor.backend.repositories.StaffRepository;
import com.eQuor.backend.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
public class DbUserDetailService implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private StaffRepository staffRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Staff staff = this.staffRepository.findByUsername(username);
        System.out.println(staff);
        if (staff != null){
            return new User(staff.getUsername(), staff.getPassword(), staff.getAuthorities());

        }
        else throw new UsernameNotFoundException("User "+ username +" not found");

    }
}
