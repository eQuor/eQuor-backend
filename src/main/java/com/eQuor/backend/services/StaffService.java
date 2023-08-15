package com.eQuor.backend.services;

import com.eQuor.backend.models.Staff;
import com.eQuor.backend.models.Student;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class StaffService {
    public String createStudent(Student student) throws ExecutionException, InterruptedException {
        Firestore database = FirestoreClient.getFirestore();
        DocumentReference documentReference = database.collection("Staff").document("xUFgo7CczxabWIApFFCO");
        Map<String, Object> data = new HashMap<>();
        data.put("fullname", student.getFullname());
        data.put("Email", student.getEmail());
        data.put("address", student.getAddress());
        data.put("Password", student.getPassword());
        data.put("indexNo", student.getIndexNo());
        data.put("propic",student.getPropic());
        data.put("userName",student.getUserName());
        data.put("approvedStaffRef", documentReference);
        ApiFuture<WriteResult> collectionApiFuture = database.collection("Student").document().set(data);
        return collectionApiFuture.get().getUpdateTime().toString();
    }
}
