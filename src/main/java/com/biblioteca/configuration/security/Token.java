package com.biblioteca.configuration.security;

import java.util.List;

public record Token(String token, List<String> roles) {
}
