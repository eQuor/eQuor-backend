package com.eQuor.backend.services;

import com.eQuor.backend.dto.AdminMemberCount;
import com.eQuor.backend.repositories.LecturerRepository;
import com.eQuor.backend.repositories.StaffRepository;
import com.eQuor.backend.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;

    public AdminMemberCount getTotalMembers(){
        Long totalLecture=lecturerRepository.count();
        Long totalStaff=staffRepository.count();
        Long totalStudent=studentRepository.count();

        AdminMemberCount adminMemberCount=new AdminMemberCount();
        adminMemberCount.setTotalLecture(totalLecture);
        adminMemberCount.setTotalStudent(totalStudent);
        adminMemberCount.setTotalStaff(totalStaff);



        return adminMemberCount ;

    }


}
