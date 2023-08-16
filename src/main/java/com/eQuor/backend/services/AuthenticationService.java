package com.eQuor.backend.services;

import com.eQuor.backend.models.AuthenticationRequest;
import com.eQuor.backend.models.AuthenticationResponse;
import com.eQuor.backend.models.RegisterRequest;
import com.eQuor.backend.models.Staff;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import com.eQuor.backend.models.User;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;

    public String register(User request) throws ExecutionException, InterruptedException {

            Firestore database = FirestoreClient.getFirestore();
            ApiFuture<WriteResult> collectionApiFuture = database.collection("User").document().set(request);
            return collectionApiFuture.get().getUpdateTime().toString();
    }


    public AuthenticationResponse register(AuthenticationRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    }
}
