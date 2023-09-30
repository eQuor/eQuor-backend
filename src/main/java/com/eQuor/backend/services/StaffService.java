//package com.eQuor.backend.services;
//
//import com.eQuor.backend.models.Admin;
//import com.eQuor.backend.models.Lecturer;
//import com.eQuor.backend.models.Staff;
//import com.eQuor.backend.models.Student;
//import com.google.api.core.ApiFuture;
//import com.google.cloud.firestore.*;
//import com.google.firebase.cloud.FirestoreClient;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ExecutionException;
//
//@Service
//public class StaffService {
//    public String createStudent(Student student) throws ExecutionException, InterruptedException {
//        Firestore database = FirestoreClient.getFirestore();
//        DocumentReference documentReference = database.collection("Staff").document("xUFgo7CczxabWIApFFCO");
//        Map<String, Object> data = new HashMap<>();
//        data.put("fullName", student.getFullName());
//        data.put("email", student.getEmail());
//        data.put("address", student.getAddress());
//        data.put("password", student.getPassword());
//        data.put("indexNo", student.getIndexNo());
//        data.put("regNo",student.getRegNo());
//        data.put("propic",student.getPropic());
//        data.put("userName",student.getUserName());
//        data.put("approvedStaffRef", documentReference);
//        ApiFuture<WriteResult> collectionApiFuture = database.collection("Student").document().set(data);
//        return collectionApiFuture.get().getUpdateTime().toString();
//    }public String createLecturer(Lecturer lecturer) throws ExecutionException, InterruptedException {
//        Firestore database = FirestoreClient.getFirestore();
//        DocumentReference documentReference = database.collection("Staff").document("xUFgo7CczxabWIApFFCO");
//        Map<String, Object> data = new HashMap<>();
//        data.put("fullName", lecturer.getFullName());
//        data.put("email", lecturer.getEmail());
//        data.put("lectureCode",lecturer.getLectureCode());
//        data.put("address", lecturer.getAddress());
//        data.put("password", lecturer.getPassword());
//        data.put("propic",lecturer.getPropic());
//        data.put("userName",lecturer.getUserName());
//        data.put("approvedStaffRef", documentReference);
//        ApiFuture<WriteResult> collectionApiFuture = database.collection("Lecturer").document().set(data);
//        return collectionApiFuture.get().getUpdateTime().toString();
//    }
//
//    public List<Student> getStudent(String id) throws ExecutionException, InterruptedException{
//        Firestore database = FirestoreClient.getFirestore();
//        ApiFuture<QuerySnapshot> collectionApiFuture = database.collection("Student").get();
//        List<QueryDocumentSnapshot> documentSnapshotList = collectionApiFuture.get().getDocuments();
//        List<Student> studentList = new ArrayList<>();
//        for (QueryDocumentSnapshot document : documentSnapshotList){
//            Student student = document.toObject(Student.class);
//            student.setId(document.getId());
//            DocumentReference approvedStaffRef = (DocumentReference) document.get("approvedStaffRef");
//            System.out.printf(approvedStaffRef.toString());
//            Staff approvedStaff = approvedStaffRef.get().get().toObject(Staff.class);
//            student.setApprovedStaff(approvedStaff);
//            studentList.add(student);
//        }
//        return studentList;
//    } public List<Lecturer> getLecturer(String id) throws ExecutionException, InterruptedException{
//        Firestore database = FirestoreClient.getFirestore();
//        ApiFuture<QuerySnapshot> collectionApiFuture = database.collection("Lecturer").get();
//        List<QueryDocumentSnapshot> documentSnapshotList = collectionApiFuture.get().getDocuments();
//        List<Lecturer> lecturerList = new ArrayList<>();
//        for (QueryDocumentSnapshot document : documentSnapshotList){
//            Lecturer lecturer = document.toObject(Lecturer.class);
//            lecturer.setId(document.getId());
//            DocumentReference approvedStaffRef = (DocumentReference) document.get("approvedStaffRef");
//            System.out.printf(approvedStaffRef.toString());
//            Staff approvedStaff = approvedStaffRef.get().get().toObject(Staff.class);
//            lecturer.setApprovedStaff(approvedStaff);
//            lecturerList.add(lecturer);
//        }
//        return lecturerList;
//    }
//}
