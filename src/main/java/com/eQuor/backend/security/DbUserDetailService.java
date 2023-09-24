package com.eQuor.backend.security;


import com.eQuor.backend.models.*;
import com.eQuor.backend.repositories.AdminRepository;
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

    @Autowired
    private AdminRepository adminRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Staff staff = this.staffRepository.findByUsername(username);
            if (staff != null){
                return new UserDetail(staff.getId(), staff.getUsername(), staff.getPassword(), staff.getAuthorities());

            }
            else{

                Student student = this.studentRepository.findByUsername(username);
                if (student != null){

                    return new UserDetail(student.getId(), student.getUsername(), student.getPassword(), student.getAuthorities());
                }
                else{
                    System.out.println("wed");
                    Lecturer lecturer = this.lecturerRepository.findByUsername(username);
                    if (lecturer != null){
                        return new UserDetail(lecturer.getId(), lecturer.getUsername(), lecturer.getPassword(), lecturer.getAuthorities());
                    }
                    else{
                        Admin admin = this.adminRepository.findByUsername(username);
                        if (admin != null){
                            return new UserDetail(admin.getId(), admin.getUsername(), admin.getPassword(), admin.getAuthorities());
                        }
                        else{
                            throw new UsernameNotFoundException("Could not find user " + username);

                        }
                    }
                }
            }
        }catch (Exception exception){
            exception.printStackTrace();
            return null;
        }


    }
}
