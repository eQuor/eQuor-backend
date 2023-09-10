//package com.eQuor.backend.services;
//
//import com.eQuor.backend.dto.AuthenticationResponse;
//import com.eQuor.backend.models.APIRequest;
//import com.eQuor.backend.models.Admin;
//import com.google.api.core.ApiFuture;
//import com.google.cloud.firestore.CollectionReference;
//import com.google.cloud.firestore.Firestore;
//import com.google.cloud.firestore.QuerySnapshot;
//import com.google.firebase.cloud.FirestoreClient;
//import org.springframework.stereotype.Service;
//import com.eQuor.backend.dto.AuthenticationRequest;
//import java.util.concurrent.ExecutionException;
//
//@Service
//public class AuthenticationService {
//
//    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) throws ExecutionException, InterruptedException {
//        Firestore database = FirestoreClient.getFirestore();
//        CollectionReference collection = database.collection("Admin");
//        ApiFuture<QuerySnapshot> future = collection.whereEqualTo("Username", authenticationRequest.getUsername()).get();
//        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
//        QuerySnapshot querySnapshot = future.get();
//        if (querySnapshot.size()>0){
//            Admin admin = querySnapshot.getDocuments().get(0).toObject(Admin.class);
//            admin.setId(querySnapshot.getDocuments().get(0).getId());
//
//            if (authenticationRequest.getPassword().equals(admin.getPassword())){
//                authenticationResponse.setStatus(true);
//                authenticationResponse.setRole("Admin");
//                authenticationResponse.setId(admin.getId());
//                return authenticationResponse;
//            }
//            else {
//                authenticationResponse.setStatus(false);
//                return authenticationResponse;
//            }
//        }
//        else{
//            authenticationResponse.setStatus(false);
//            return authenticationResponse;
//        }
//    }
//}
