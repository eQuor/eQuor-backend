//package com.eQuor.backend.security;
//
//import com.eQuor.backend.models.APIRequest;
//import com.google.api.core.ApiFuture;
//import com.google.cloud.firestore.DocumentSnapshot;
//import com.google.cloud.firestore.Firestore;
//import com.google.cloud.firestore.QuerySnapshot;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthException;
//import com.google.firebase.auth.FirebaseToken;
//import com.google.firebase.cloud.FirestoreClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.concurrent.ExecutionException;
//
//@Service
//public class FirebaseAuthService implements UserDetailsService {
//    @Autowired
//    private FirebaseAuth firebaseAuth;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Firestore database = FirestoreClient.getFirestore();
//        ApiFuture<QuerySnapshot> collectionApiFuture = database.collection("APIRequest").whereEqualTo("Username", username).get();
//        try {
//            QuerySnapshot document = collectionApiFuture.get();
//        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}
