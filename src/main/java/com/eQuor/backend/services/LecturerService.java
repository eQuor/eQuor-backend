package com.eQuor.backend.services;

import com.eQuor.backend.dto.LecturerAttendaneStat;
import com.eQuor.backend.models.Sessions;
import com.eQuor.backend.repositories.SessionRepository;
import com.eQuor.backend.repositories.StudentAttendSessionRepository;
import com.eQuor.backend.repositories.StudentModuleRepository;
import com.eQuor.backend.repositories.StudentRepository;
import org.hibernate.Session;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class LecturerService {

    @Autowired
    private StudentAttendSessionRepository studentAttendSessionRepository;
    @Autowired
    private StudentModuleRepository studentModuleRepository;
    @Autowired
    private ModelMapper modelMapper;



    public LecturerAttendaneStat getattendancecont() {
        Long count = studentAttendSessionRepository.count();
        Long allStudent = studentModuleRepository.count();

        LecturerAttendaneStat lecturerAttendaneStat = new LecturerAttendaneStat();
        lecturerAttendaneStat.setAttendStudent(count);
        lecturerAttendaneStat.setAllStudent(allStudent);

        return lecturerAttendaneStat;
    }



    //Saving random array
    @Autowired
    private SessionRepository sessionRepository;
    public String generateQrSequence(int sessionId) {
        //generate random array of 10 numbers

        Random rand = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);  // Generate random numbers between 0 to 99
        }

        // Convert the array to a string
        String arrayStr = Arrays.toString(array);

        // Print the string
        System.out.println(arrayStr);

        Sessions session = sessionRepository.findById(sessionId);

        if(session != null){
            session.setQrcode(arrayStr);
            sessionRepository.save(session);

            return arrayStr;
        }else{
            String str = "Invalid session id";

            return str;
        }






       // return arrayStr;
    }
}