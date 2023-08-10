package com.equorTest.eQuorTest.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import com.equorTest.eQuorTest.models.User;

import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    public String saveUserDetails(User user) throws ExecutionException, InterruptedException {
        Firestore database = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = database.collection("user").document().set(user);
        return collectionApiFuture.get().getUpdateTime().toString();
    }
}
