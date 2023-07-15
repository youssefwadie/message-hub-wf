package com.github.youssefwadie.messagehub.folders;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FolderRepository extends ReactiveCassandraRepository<Folder, String> {
}

