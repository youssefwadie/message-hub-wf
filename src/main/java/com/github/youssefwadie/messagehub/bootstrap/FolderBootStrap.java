package com.github.youssefwadie.messagehub.bootstrap;

import com.github.youssefwadie.messagehub.folders.Folder;
import com.github.youssefwadie.messagehub.folders.FolderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
//@Component
public class FolderBootStrap implements CommandLineRunner {
    private final FolderRepository folderRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Folder> folders = List.of(
                new Folder("youssefwadie", "Inbox", "blue"),
                new Folder("youssefwadie", "Sent", "green"),
                new Folder("youssefwadie", "Important", "yellow")
        );

        folderRepository.saveAll(folders).subscribe(
                savedFolder -> log.info("savedFolder: {}", savedFolder.getLabel())
        );
    }
}
