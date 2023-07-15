package com.github.youssefwadie.messagehub.bootstrap;

import com.github.youssefwadie.messagehub.folders.Folder;
import com.github.youssefwadie.messagehub.folders.FolderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class FolderBootStrap implements CommandLineRunner {
    private final FolderRepository folderRepository;

    @Override
    public void run(String... args) throws Exception {
        List.of(
                new Folder("youssefwadie", "Inbox", "blue"),
                new Folder("youssefwadie", "Inbox", "blue"),
                new Folder("youssefwadie", "Inbox", "blue"),
                new Folder("youssefwadie", "Inbox", "blue")
        );
    }
}
