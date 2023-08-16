//package com.eQuor.backend.security;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class FirebaseAuthService implements UserDetailsService {
//    private final FirebaseAuth firebaseAuth;
//
//    public FirebaseAuthService(FirebaseAuth firebaseAuth) {
//        this.firebaseAuth = firebaseAuth;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        FirebaseUser firebaseUser = firebaseAuth.getUserByEmail(username);
//
//        if (firebaseUser == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        return new org.springframework.security.core.userdetails.User(
//                firebaseUser.getEmail(),
//                firebaseUser.getPassword(),
//                firebaseUser.getEmailVerified(),
//                true,
//                true,
//                true,
//                firebaseUser.getRoles()
//        );
//    }
//}
