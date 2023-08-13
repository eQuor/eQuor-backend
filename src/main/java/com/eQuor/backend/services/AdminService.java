package com.eQuor.backend.services;

import com.eQuor.backend.models.APIRequest;
import com.eQuor.backend.models.Admin;
import com.eQuor.backend.models.Staff;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class AdminService {

    public List<Staff> getStaff(String id) throws ExecutionException, InterruptedException {
        Firestore database = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> collectionApiFuture = database.collection("Staff").get();
        List<QueryDocumentSnapshot> documentSnapshotList = collectionApiFuture.get().getDocuments();
        List<Staff> staffList = new ArrayList<>();
        for (QueryDocumentSnapshot document : documentSnapshotList){
            Staff staff = document.toObject(Staff.class);
            staff.setId(document.getId());
            DocumentReference approvedAdminRef = (DocumentReference) document.get("ApprovedAdminRef");
            System.out.printf(approvedAdminRef.toString());
            Admin approvedAdmin = approvedAdminRef.get().get().toObject(Admin.class);
            staff.setApprovedAdmin(approvedAdmin);
            staffList.add(staff);
        }
        return staffList;
    }

    public List<APIRequest> getRequestAll(Integer filterByAcceptStatus) throws ExecutionException, InterruptedException {
        Firestore database = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> collectionApiFuture = null;
        if (filterByAcceptStatus == null){
             collectionApiFuture = database.collection("APIRequest").get();
        }
        else{
            collectionApiFuture = database.collection("APIRequest").whereEqualTo("AcceptStatus", filterByAcceptStatus).get();
        }

        List<QueryDocumentSnapshot> documentSnapshotList = collectionApiFuture.get().getDocuments();
        List<APIRequest> apiRequestsList = new ArrayList<>();
        for (QueryDocumentSnapshot document : documentSnapshotList){
            APIRequest apiRequest = document.toObject(APIRequest.class);
            apiRequest.setId(document.getId());
            DocumentReference approvedAdminRef = (DocumentReference) document.get("ApprovedAdminRef");
            System.out.printf(approvedAdminRef.toString());
            Admin approvedAdmin = approvedAdminRef.get().get().toObject(Admin.class);
            apiRequest.setApprovedAdmin(approvedAdmin);
            apiRequestsList.add(apiRequest);
        }
        return apiRequestsList;
    }

    public APIRequest getAPIRequest(String id) throws ExecutionException, InterruptedException {
        if (id.equalsIgnoreCase("") || id == null){
            return null;
        }
        Firestore database = FirestoreClient.getFirestore();
        ApiFuture<DocumentSnapshot> collectionApiFuture = database.collection("APIRequest").document(id).get();
        DocumentSnapshot document = collectionApiFuture.get();
        if (document.exists())
            return document.toObject(APIRequest.class);
        else
            return null;
    }

    public Admin getAdmin(String id) throws ExecutionException, InterruptedException {
        Firestore database = FirestoreClient.getFirestore();
        ApiFuture<DocumentSnapshot> collectionApiFuture = database.collection("Admin").document(id).get();
        DocumentSnapshot document = collectionApiFuture.get();
        if (document.exists())
            return document.toObject(Admin.class);
        else
            return null;
    }


}
