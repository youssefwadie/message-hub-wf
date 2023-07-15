package com.github.youssefwadie.messagehub.folders;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface FolderRepository extends ReactiveCassandraRepository<Folder, String> {
    Flux<Folder> findAllByUserId(String userId);

}

