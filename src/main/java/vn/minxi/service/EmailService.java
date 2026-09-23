package vn.minxi.service;

public interface EmailService {
	void sendOtp(String email, String otp, String subject);
}
