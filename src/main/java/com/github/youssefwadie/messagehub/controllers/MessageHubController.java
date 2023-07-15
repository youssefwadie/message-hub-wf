package com.github.youssefwadie.messagehub.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
@Slf4j
public class MessageHubController {

    @GetMapping("")
    public Mono<Rendering> homePage(@AuthenticationPrincipal Mono<OAuth2User> principal) {
        if (principal == null) {
            return Mono.fromCallable(this::indexPageRendering);
        }

        return principal
                .map(oAuth2User -> {
                    if (StringUtils.hasLength(oAuth2User.getAttribute("name"))) {
                        return Rendering.view("message-hub").build();
                    }
                    return indexPageRendering();
                })
                .defaultIfEmpty(indexPageRendering());

    }


    private Rendering indexPageRendering() {
        return Rendering.view("index").build();
    }
}
