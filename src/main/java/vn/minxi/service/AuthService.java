package vn.minxi.service;

import vn.minxi.dto.RegisterDTO;
public interface AuthService {
 void register(RegisterDTO dto);

	boolean verifyRegister(String email, String otp);
 void forgotPassword(String email);
 boolean verifyResetOtp(String email, String otp);
 void resetPassword(String email, String password);
}
