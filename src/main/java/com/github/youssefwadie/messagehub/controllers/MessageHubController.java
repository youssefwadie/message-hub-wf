package com.github.youssefwadie.messagehub.controllers;

import com.github.youssefwadie.messagehub.folders.Folder;
import com.github.youssefwadie.messagehub.folders.FolderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MessageHubController {
    private final FolderRepository folderRepository;

    @GetMapping("")
    public Mono<Rendering> homePage(@AuthenticationPrincipal Mono<OAuth2User> principal) {
        if (principal == null) {
            return Mono.fromCallable(this::indexPageRendering);
        }

        return principal
                .map(oAuth2User -> {
                    String userId = oAuth2User.getAttribute("login");
                    if (!StringUtils.hasLength(userId)) {
                        return indexPageRendering();
                    }

                    Flux<Folder> foldersByUserId = folderRepository.findAllByUserId(userId);

                    return Rendering.view("message-hub")
                            .modelAttribute("userFolders", foldersByUserId)
                            .build();
                })
                .defaultIfEmpty(indexPageRendering());
    }


    private Rendering indexPageRendering() {
        return Rendering.view("index").build();
    }
}
