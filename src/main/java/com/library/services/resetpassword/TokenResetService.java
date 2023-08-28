package com.library.services.resetpassword;

import com.library.domain.user.UserDomain;
import com.library.domain.user.UserRepository;
import com.library.infrastructure.exception.RecordNotFoundException;
import com.library.infrastructure.exception.TokenExpiredException;
import com.library.services.resetpassword.dto.TokenResetPublicData;
import org.springframework.security.core.token.KeyBasedPersistenceTokenService;
import org.springframework.security.core.token.SecureRandomFactoryBean;
import org.springframework.security.core.token.Token;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;

@Service
public class TokenResetService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public TokenResetService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String generateToken(UserDomain userDomain) throws Exception {
        KeyBasedPersistenceTokenService tokenService = getTokenService(userDomain);
        Token token = tokenService.allocateToken(userDomain.getEmail());
        return token.getKey();
    }

    public void updatePassword(String newPassword, String tokenReset) throws Exception {
        TokenResetPublicData tokenResetPublicData = extractPublicDataOfToken(tokenReset);

        if(isTokenExpired(tokenResetPublicData)){
            throw new TokenExpiredException();
        }

        UserDomain userDomain = userRepository.findByEmail(tokenResetPublicData.email())
                .orElseThrow(() -> new RecordNotFoundException(tokenResetPublicData.email()));

        KeyBasedPersistenceTokenService tokenService = getTokenService(userDomain);
        tokenService.verifyToken(tokenReset);

        userDomain.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(userDomain);
    }

    private boolean isTokenExpired(TokenResetPublicData tokenPublicData){
        Instant createdAt = new Date(tokenPublicData.createdAtTimeStamp()).toInstant();
        Instant now = new Date().toInstant();
        return createdAt.plus(Duration.ofMinutes(60)).isBefore(now);
    }

    private KeyBasedPersistenceTokenService getTokenService(UserDomain userDomain) throws Exception {
        KeyBasedPersistenceTokenService tokenService = new KeyBasedPersistenceTokenService();
        tokenService.setServerSecret(userDomain.getPassword());
        tokenService.setServerInteger(16);
        tokenService.setSecureRandom(new SecureRandomFactoryBean().getObject());
        return tokenService;
    }

    private TokenResetPublicData extractPublicDataOfToken(String tokenReset){
        String decodedToken = new String(Base64.getDecoder().decode(tokenReset));
        String[] tokenParts = decodedToken.split(":");
        String email = tokenParts[2];
        Long createdAtTimeStamp = Long.parseLong(tokenParts[0]);
        return new TokenResetPublicData(email, createdAtTimeStamp);
    }

}
